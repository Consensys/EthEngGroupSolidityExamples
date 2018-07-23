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
 * Check that a participant can be added.
 *
 *
 */
contract('VotingGreeting: Add Participants', function(accounts) {
    let common = require('./common');


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

    it("Check that a participant can not be added twice", async function() {
        let firstParticipantAgain = accounts[0];
        let greetingInterface = await common.getInstance();

        // Check that they are a participant.
        let isParticipant = await greetingInterface.isParticipant.call(firstParticipantAgain);
        assert.equal(isParticipant, true);

        // Check that attempting to add an exisitng participant causes a revert.
        let didNotTriggerError = false;
        try {
            await greetingInterface.proposeVote(firstParticipantAgain, common.VOTE_ADD_PARTICIPANT, 0);
            didNotTriggerError = true;
        } catch(err) {
            // Expect that a revert will be called as the transaction is being sent by an account other than the owner.
            //console.log("ERROR! " + err.message);
        }
        assert.equal(didNotTriggerError, false);
    });

    // In Truffle, tests are run sequentially within a file, and the state is maintained between tests.
    it("Add a third participant", async function() {
        let secondParticipant = accounts[1];
        let thirdParticipant = accounts[2];
        const newVotingPeriod = "5";

        let greetingInterface = await common.getInstance();
        // Based on the last test, secondParticipant should be a participant, and third participant should
        // not be a participant.
        let isParticipant = await greetingInterface.isParticipant.call(secondParticipant);
        assert.equal(isParticipant, true, "Second Participant: isParticipant == false");
        isParticipant = await greetingInterface.isParticipant.call(thirdParticipant);
        assert.equal(isParticipant, false, "Third Participant: isParticipant == true");

        // Add the third participant.
        // Note that the second participant must vote.
        await greetingInterface.proposeVote(thirdParticipant, common.VOTE_ADD_PARTICIPANT, 0);
        await greetingInterface.vote(thirdParticipant, common.VOTE_ADD_PARTICIPANT, true, {from: secondParticipant});
        await common.mineBlocks(parseInt(common.VOTE_CHANGE_VOTING_PERIOD) + parseInt(common.VOTE_CHANGE_VOTE_VIEWING_PERIOD));
        await greetingInterface.actionVotes(thirdParticipant);

        isParticipant = await greetingInterface.isParticipant.call(thirdParticipant);
        assert.equal(isParticipant, true, "Third Participant: isParticipant == false");
    });

    it("Add fourth and fifth participants at the same time", async function() {
        let secondParticipant = accounts[1];
        let thirdParticipant = accounts[2];
        let fourthParticipant = accounts[3];
        let fifthParticipant = accounts[4];

        let greetingInterface = await common.getInstance();
        // Second participant proposes to add fourth and fifth participant.
        await greetingInterface.proposeVote(fourthParticipant, common.VOTE_ADD_PARTICIPANT, 0, {from: secondParticipant});
        await greetingInterface.proposeVote(fifthParticipant, common.VOTE_ADD_PARTICIPANT, 0, {from: secondParticipant});
        // Third participant votes for fourth and first and third participant votes for fifth.
        await greetingInterface.vote(fourthParticipant, common.VOTE_ADD_PARTICIPANT, true, {from: thirdParticipant});
        await greetingInterface.vote(fifthParticipant, common.VOTE_ADD_PARTICIPANT, true, {from: thirdParticipant});
        await greetingInterface.vote(fifthParticipant, common.VOTE_ADD_PARTICIPANT, true);

        // Wait until the voting period, and the vote viewing period have expired.
        await common.mineBlocks(parseInt(common.VOTE_CHANGE_VOTING_PERIOD) + parseInt(common.VOTE_CHANGE_VOTE_VIEWING_PERIOD));
        await greetingInterface.actionVotes(fourthParticipant);
        await greetingInterface.actionVotes(fifthParticipant);

        let isParticipant = await greetingInterface.isParticipant.call(fourthParticipant);
        assert.equal(isParticipant, true, "Fourth Participant: isParticipant == false");
        isParticipant = await greetingInterface.isParticipant.call(fifthParticipant);
        assert.equal(isParticipant, true, "Fifth Participant: isParticipant == false");
    });




});
