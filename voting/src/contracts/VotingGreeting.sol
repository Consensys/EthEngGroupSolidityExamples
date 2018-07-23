/*
 * Copyright 2018 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
pragma solidity ^0.4.23;

import "./VotingGreetingInterface.sol";
import "./VotingAlgInterface.sol";
import "./VotingGreetingDataHolder.sol";


/**
 * Implementation of greeting contract which has a voting capability.
 */
contract VotingGreeting is VotingGreetingInterface {
    uint16 constant public VERSION_ONE = 1;

    // Indications the type of vote.
    enum VoteType {
        VOTE_NONE,                          // 0: MUST be the first value so it is the zero / deleted value.
        VOTE_ADD_PARTICIPANT,               // 1
        VOTE_REMOVE_PARTICIPANT,            // 2
        VOTE_CHANGE_VOTING_ALG,             // 3
        VOTE_CHANGE_VOTING_PERIOD,          // 4
        VOTE_CHANGE_VOTING_VIEWING_PERIOD,  // 5
        VOTE_SET_NEW_IMPLEMENTATION,        // 6
        VOTE_CHANGE_GREETING                // 7
    }


    address public initialOwner;


    struct Votes {
        VoteType voteType;
        uint endOfVotingBlockNumber;
        address votingAlgorithmContract;

        // Have map as well as array to ensure constant time / constant cost look-up, independent of number of participants.
        mapping(address=>bool) hasVoted;

        uint32 numVotedFor;
        uint32 numVotedAgainst;

        // Address of user who has voted. Only needed so analysis contract can determine easily who has voted.
        address[] addressVoted;
        bool[] addressVotedFor; // True if the address voted for the action.

        // Additional information such as proposed voting contract, or proposed voting period.
        uint256 additionalInfo;

        // Index into activeVotes array.
        uint activeVoteIndex;
    }

    // Votes for setting a new greeting, adding and removing participants, for
    // changing voting algorithm and voting period.
    // For votes related to participants (adding or removing), then the address is of the affected participant.
    // For votes not related to participants (set new greeting, change voting period or algorithm), then the address is 0.
    mapping(address=>Votes) votes;
    // An array containing what is actively being voted on.
    address[] activeVotes;
    // For non-participant related votes, the participant is set as 0x00.
    address private constant VOTE_PARTICIPANT_NONE = 0x0;

    // Data holder contract.
    VotingGreetingDataHolder dataHolder;


    /**
     * Function modifier to ensure only participants can call the function.
     *
     * @dev Throws if the message sender isn't a participant.
     */
    modifier onlyParticipant() {
        require(dataHolder.participants(msg.sender));
        _;
    }

    /**
     * @dev The Ownable constructor sets the original `owner` of the contract to the sender
     * account.
     */
    constructor() public {
        initialOwner = msg.sender;
    }


    // The owner can call this once only. They should call this when the contracts are first deployed.
    function setDataHolder(address _dataHolder) external {
        require(msg.sender == initialOwner);
        require(address(dataHolder) == 0);
        dataHolder = VotingGreetingDataHolder(_dataHolder);
    }


    function proposeVote(address _participant, uint16 _action, uint256 _additionalData) external onlyParticipant() {
        // This will throw an error if the action is not a valid VoteType.
        VoteType action = VoteType(_action);

        // Can't start a vote if a vote is already underway.
        require(votes[_participant].voteType == VoteType.VOTE_NONE);

        // If the action is to add a participant, then they shouldn't be a participant already.
        if (action == VoteType.VOTE_ADD_PARTICIPANT) {
            require(dataHolder.participants(_participant) == false);
        }
        // If the action is to remove a participant, then they should be a participant already
        // and they can't be the last participant.
        else if (action == VoteType.VOTE_REMOVE_PARTICIPANT) {
            require(dataHolder.participants(_participant) == true);
            require(dataHolder.numParticipants() > 1);
        }
        else {
            // For non-participant voting, _participant must be zero.
            require(_participant == VOTE_PARTICIPANT_NONE);
        }


        // The vote proposer is recorded as the entity which submitted this transaction.
        uint activeVoteIndex = activeVotes.length;
        votes[_participant] = Votes({
            voteType: action,
            endOfVotingBlockNumber: block.number + dataHolder.votingPeriod(),
            votingAlgorithmContract: dataHolder.votingAlgorithmContract(),
            // hasVoted: maps don't need to be initialised.
            numVotedFor: 0,
            numVotedAgainst: 0,
            addressVoted: new address[](0),
            addressVotedFor: new bool[](0),
            additionalInfo: _additionalData,
            activeVoteIndex: activeVoteIndex
        });
        activeVotes.push(_participant);
        // The vote proposer is also record as being for the proposal.
        vote(_participant, _action, true);
    }

    function vote(address _participant, uint16 _action, bool _voteFor) public {
        // This will throw an error if the action is not a valid VoteType.
        VoteType action = VoteType(_action);

        // The type of vote must match what is currently being voted on.
        // Note that this will catch the case when someone is voting when there is no active vote.
        require(votes[_participant].voteType == action);
        // Ensure the account has not voted yet.
        require(votes[_participant].hasVoted[msg.sender] == false);

        // Check voting period has not expired.
        require(votes[_participant].endOfVotingBlockNumber >= block.number);

        // Indicate msg.sender has voted.
        votes[_participant].hasVoted[msg.sender] = true;
        if (_voteFor) {
            votes[_participant].numVotedFor++;
        } else {
            votes[_participant].numVotedAgainst++;
        }
        votes[_participant].addressVoted.push(msg.sender);
        votes[_participant].addressVotedFor.push(_voteFor);
    }


    function actionVotes(address _participant) external {
        // If no vote is underway, then there is nothing to action.
        VoteType action = votes[_participant].voteType;
        require(action != VoteType.VOTE_NONE);
        // Can only action vote after voting period has ended.
        require(votes[_participant].endOfVotingBlockNumber + dataHolder.voteViewingPeriod() <= block.number);

        VotingAlgInterface voteAlg = VotingAlgInterface(votes[_participant].votingAlgorithmContract);
        //emit Dump(dataHolder.numParticipants(), votes[_participant].numVotedFor, votes[_participant].numVotedAgainst);
        bool result = voteAlg.assess(dataHolder.numParticipants(), votes[_participant].numVotedFor, votes[_participant].numVotedAgainst);

        emit VoteResult(_participant, uint16(action), result);

        if (result) {
            // The vote has been voted up.
            if (action == VoteType.VOTE_ADD_PARTICIPANT) {
                dataHolder.addParticipant(_participant);
            }
            else if (action == VoteType.VOTE_REMOVE_PARTICIPANT) {
                dataHolder.removeParticipant(_participant);
            }
            else if (action == VoteType.VOTE_CHANGE_VOTING_ALG) {
                dataHolder.setVotingAlgorithm(address(votes[_participant].additionalInfo));
            }
            else if (action == VoteType.VOTE_CHANGE_VOTING_PERIOD) {
                //emit Dump(uint(votes[_participant].additionalInfo), uint16(votes[_participant].additionalInfo), uint(temp2));
                dataHolder.setVotingPeriod(uint16(votes[_participant].additionalInfo));
            }
            else if (action == VoteType.VOTE_CHANGE_VOTING_VIEWING_PERIOD) {
                dataHolder.setVoteViewingPeriod(uint16(votes[_participant].additionalInfo));
            }
            else if (action == VoteType.VOTE_SET_NEW_IMPLEMENTATION) {
                dataHolder.setVotingGreetingImpl(address(votes[_participant].additionalInfo));
            }
            else if (action == VoteType.VOTE_CHANGE_GREETING) {
                dataHolder.setGreeting(votes[_participant].additionalInfo);
            }
        }


        // The vote is over. Now delete the voting arrays and indicate there is no vote underway.
        // Remove all values from the map: The maps themselves can't be deleted in Solidity.
        for (uint i = 0; i < votes[_participant].addressVoted.length; i++) {
            delete votes[_participant].hasVoted[msg.sender];
        }
        // This will recursively delete everything in the structure, except for the map, which was
        // deleted in the for loop above.
        delete votes[_participant];

        // Remove from the array of active votes.
        delete activeVotes[votes[_participant].activeVoteIndex];
    }


    function getGreeting() external view returns (uint256) {
        return dataHolder.greeting();
    }

    function getVotingPeriod() external view returns (uint32) {
        return dataHolder.votingPeriod();
    }

    function getVoteViewingPeriod() external view returns (uint32) {
        return dataHolder.voteViewingPeriod();
    }

    function getVotingAlgorithm() external view returns (address) {
        return dataHolder.votingAlgorithmContract();
    }

    function isParticipant(address _participant) external view returns(bool) {
        return dataHolder.participants(_participant);
    }

    function getNumberParticipants() external view returns(uint32) {
        return dataHolder.numParticipants();
    }

    function getActiveVotes() external view returns(address[]) {
        return activeVotes;
    }


    function getVersion() external pure returns (uint16) {
        return VERSION_ONE;
    }


    //event Dump(uint val1, uint val2, uint val3);
}