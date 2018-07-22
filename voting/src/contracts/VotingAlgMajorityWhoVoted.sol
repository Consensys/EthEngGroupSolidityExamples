pragma solidity ^0.4.23;

import "./AbstractVotingAlg.sol";

contract VotingAlgMajorityWhoVoted is AbstractVotingAlg {

    function assess(uint32 /* numParticipants */, uint32 numVotedFor, uint32 numVotedAgainst) public pure returns (bool) {
        return (numVotedFor > numVotedAgainst);
    }
}