pragma solidity ^0.4.23;


contract AbstractVotingAlg {
    /**
     * Asses a vote.
     *
     * @param numParticipants Total number of participants.
     * @param numVotedFor     Number of participants who voted for the proposal.
     * @param numVotedAgainst Number of participants who voted against the proposal.
     * @return true if the result of the vote true. That is, given the voting algorithm
     *  the result of the vote is for what was being voted on.
     */
    function assess(uint32 numParticipants, uint32 numVotedFor, uint32 numVotedAgainst) public pure returns (bool);
}