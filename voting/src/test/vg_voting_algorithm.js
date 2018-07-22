/**
 * Check that the voting algorithm can be changed.
 *
 * Just check with one participant.
 *
 */
const VotingAlg = artifacts.require("./VotingAlgMajority.sol");
const VotingAlgMajorityWhoVoted = artifacts.require("./VotingAlgMajorityWhoVoted.sol");


contract('VotingGreeting: Voting Algorithm', function(accounts) {
    let common = require('./common');

    it("getVotingAlgInitial", async function() {
        let votingAlg = await VotingAlg.deployed();
        let greetingInterface = await common.getInstance();
        const votingAlgorithm = await greetingInterface.getVotingAlgorithm.call();
        assert.equal(votingAlgorithm, votingAlg.address);
    });

    it("changeVotingAlgorithm", async function() {
        let originalVotingAlg = await VotingAlg.deployed();
        let newVotingAlg = await VotingAlgMajorityWhoVoted.deployed();
        let greetingInterface = await common.getInstance();



        //let block = await web3.eth.getBlock("latest");
        //console.log("Block: " + block.number);

        await greetingInterface.proposeVote(common.NON_PARTICIPANT_VOTE, common.VOTE_CHANGE_VOTING_ALG, newVotingAlg.address);
        // Wait until the voting period, and the vote viewing period have expired.
        await common.mineBlocks(parseInt(common.VOTE_CHANGE_VOTING_PERIOD) + parseInt(common.VOTE_CHANGE_VOTE_VIEWING_PERIOD));
        // Check that the voting algorithm does not change until the voting is actioned.
        const votingAlgorithm = await greetingInterface.getVotingAlgorithm.call();
        assert.equal(votingAlgorithm, originalVotingAlg.address);

        //block = await web3.eth.getBlock("latest");
        //console.log("Block: " + block.number);

        await greetingInterface.actionVotes(common.NON_PARTICIPANT_VOTE);

        const newVotingAlgorithmActual = await greetingInterface.getVotingAlgorithm.call();
        assert.equal(newVotingAlgorithmActual, newVotingAlg.address);
    });
});
