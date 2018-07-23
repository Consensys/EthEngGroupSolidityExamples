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
/**
 * Check the mechanics of the voting.
 *
 *
 */
contract('VotingGreeting: Voting', function(accounts) {
    let common = require('./common');


    // Start out by adding an extra participant to the voting.
    it("Add one participants", async function() {
        let secondParticipant = accounts[1];
        let greetingInterface = await common.getInstance();

        // Check that they are not a participant.
        let isParticipant = await greetingInterface.isParticipant.call(secondParticipant);
        assert.equal(isParticipant, false);

        await greetingInterface.proposeVote(secondParticipant, common.VOTE_ADD_PARTICIPANT, 0);
        // Wait until the voting period, and the vote viewing period have expired.
        await common.mineBlocks(parseInt(common.VOTE_CHANGE_VOTING_PERIOD) + parseInt(common.VOTE_CHANGE_VOTE_VIEWING_PERIOD));
        await greetingInterface.actionVotes(secondParticipant);

        isParticipant = await greetingInterface.isParticipant.call(secondParticipant);
        assert.equal(isParticipant, true, "Second Participant: isParticipant == false");
    });


    it("Failed Voting: Not Enough Votes", async function() {
        const newVotingPeriod = "5";
        let greetingInterface = await common.getInstance();

        await greetingInterface.proposeVote(common.NON_PARTICIPANT_VOTE, common.VOTE_CHANGE_VOTING_PERIOD, newVotingPeriod);
        // Wait until the voting period, and the vote viewing period have expired.
        await common.mineBlocks(parseInt(common.VOTE_CHANGE_VOTING_PERIOD) + parseInt(common.VOTE_CHANGE_VOTE_VIEWING_PERIOD));
        await greetingInterface.actionVotes(common.NON_PARTICIPANT_VOTE);
        // Check that the voting period has not changed.
        const votingPeriod = await greetingInterface.getVotingPeriod.call();
        assert.equal(votingPeriod, common.VOTING_PERIOD);
    });

    it("Attempt to vote during Vote Viewing Period", async function() {
        const newVotingPeriod = "5";
        let greetingInterface = await common.getInstance();

        await greetingInterface.proposeVote(common.NON_PARTICIPANT_VOTE, common.VOTE_CHANGE_VOTING_PERIOD, newVotingPeriod);
        // Wait until the voting period, and the vote viewing period have expired.
        await common.mineBlocks(parseInt(common.VOTE_CHANGE_VOTING_PERIOD));

        // Attempt to vote outside of the voting period
        let didNotTriggerError = false;
        try {
            await greetingInterface.vote(common.NON_PARTICIPANT_VOTE, common.VOTE_CHANGE_VOTING_PERIOD, true, {from: secondParticipant});
            didNotTriggerError = true;
        } catch(err) {
            // Expect that a revert will be called as the transaction is being sent by an account other than the owner.
            //console.log("ERROR! " + err.message);
            // Wait for the vote viewing period
            await common.mineBlocks(parseInt(common.VOTE_CHANGE_VOTE_VIEWING_PERIOD));
            // and action to vote to clear it.
            await greetingInterface.actionVotes(common.NON_PARTICIPANT_VOTE);
        }
        assert.equal(didNotTriggerError, false);
    });

    it("Attempt to vote on an item for which there is no voting proposal", async function() {
        const newVotingPeriod = "5";
        let greetingInterface = await common.getInstance();

        await greetingInterface.proposeVote(common.NON_PARTICIPANT_VOTE, common.VOTE_CHANGE_VOTING_PERIOD, newVotingPeriod);
        // Wait until the voting period, and the vote viewing period have expired.
        await common.mineBlocks(parseInt(common.VOTE_CHANGE_VOTING_PERIOD));

        // Attempt to vote on something which is not being voted on.
        let didNotTriggerError = false;
        try {
            await greetingInterface.vote(common.NON_PARTICIPANT_VOTE, common.VOTE_CHANGE_VOTE_VIEWING_PERIOD, true, {from: secondParticipant});
            didNotTriggerError = true;
        } catch(err) {
            // Expect that a revert will be called as the transaction is being sent by an account other than the owner.
            //console.log("ERROR! " + err.message);
        }
        assert.equal(didNotTriggerError, false);
    });


});
