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

/**
 * Contract to hold long term persistent data for the Voting Greeter application.
 */
contract VotingGreetingDataHolder {
    // The greeting to be returned by getGreeting().
    uint256 public greeting;

    // Voting period in blocks. This is the period in which participants can vote. Must be greater than 0.
    uint32 public votingPeriod;

    // Voting viewing period in blocks. This is the period between when the voting has completed and when
    // the vote can be actioned. Once the vote is actioned, all information about who voted and how they voted
    // is removed from the ledger.
    uint32 public voteViewingPeriod;

    // The algorithm for assessing the votes.
    address public votingAlgorithmContract;

    // The participants of the contract.
    mapping(address=>bool) public participants;
    uint32 public numParticipants;

    address public votingGreetingImpl;


    /**
     * Function modifier to ensure only participants can call the function.
     *
     * @dev Throws if the message sender isn't a participant.
     */
    modifier onlyVotingGreeterImpl() {
        require(msg.sender == votingGreetingImpl);
        _;
    }

    constructor (address _votingGreetingImpl, address _votingAlg, uint32 _votingPeriod, uint32 _voteViewingPeriod) public {
        votingGreetingImpl = _votingGreetingImpl;
        votingAlgorithmContract = _votingAlg;
        votingPeriod = _votingPeriod;
        voteViewingPeriod = _voteViewingPeriod;

        // The creator of the contract is a participant.
        participants[msg.sender] = true;
        numParticipants = 1;
    }


    function setVotingGreetingImpl(address _newVotingGreetingImpl) public onlyVotingGreeterImpl() {
        votingGreetingImpl = _newVotingGreetingImpl;
    }

    function setGreeting(uint256 _newGreeting) public onlyVotingGreeterImpl() {
        greeting = _newGreeting;
    }


    function setVotingPeriod(uint16 _newVotingPeriod) public onlyVotingGreeterImpl() {
        votingPeriod = _newVotingPeriod;
    }

    function setVoteViewingPeriod(uint16 _newVoteViewingPeriod) public onlyVotingGreeterImpl() {
        voteViewingPeriod = _newVoteViewingPeriod;
    }

    function setVotingAlgorithm(address _newVotingAlgorithmContract) public onlyVotingGreeterImpl() {
        votingAlgorithmContract = _newVotingAlgorithmContract;
    }

    function addParticipant(address _participant) public onlyVotingGreeterImpl() {
        participants[_participant] = true;
        numParticipants++;
    }

    function removeParticipant(address _participant) public onlyVotingGreeterImpl() {
        participants[_participant] = false;
        numParticipants--;
    }
}