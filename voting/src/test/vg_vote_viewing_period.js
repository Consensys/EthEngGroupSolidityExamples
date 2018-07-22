/**
 * Check that the vote viewing period can be changed.
 *
 * Just check with one participant.
 *
 */
contract('VotingGreeting: Vote Viewing Period', function(accounts) {
    let common = require('./common');

    it("getVoteViewingPeriodInitial", async function() {
        let greetingInterface = await common.getInstance();
        const voteViewingPeriod = await greetingInterface.getVoteViewingPeriod.call();
        assert.equal(voteViewingPeriod, common.VOTE_VIEWING_PERIOD);
    });

    it("changeVoteViewingPeriod", async function() {
        const newVoteViewingPeriod = "5";
        let greetingInterface = await common.getInstance();

        //let block = await web3.eth.getBlock("latest");
        //console.log("Block: " + block.number);

        await greetingInterface.proposeVote(common.NON_PARTICIPANT_VOTE, common.VOTE_CHANGE_VOTE_VIEWING_PERIOD, newVoteViewingPeriod);
        // Wait until the voting period, and the vote viewing period have expired.
        await common.mineBlocks(parseInt(common.VOTE_CHANGE_VOTING_PERIOD) + parseInt(common.VOTE_CHANGE_VOTE_VIEWING_PERIOD));
        // Check that the vote viewing period does not change until the voting is actioned.
        const voteViewingPeriod = await greetingInterface.getVoteViewingPeriod.call();
        assert.equal(voteViewingPeriod, common.VOTE_VIEWING_PERIOD);

        //block = await web3.eth.getBlock("latest");
        //console.log("Block: " + block.number);

        await greetingInterface.actionVotes(common.NON_PARTICIPANT_VOTE);
        let newVoteViewingPeriodActual = await greetingInterface.getVoteViewingPeriod.call();
        assert.equal(newVoteViewingPeriod, newVoteViewingPeriodActual);
    });


    // TODO Vote Viewing Period edge case: 0 (should work)

    // TODO Vote Viewing Period edge case: just less than max uint16

    // TODO Vote Viewing Period edge case: just larger than max uint16





});
