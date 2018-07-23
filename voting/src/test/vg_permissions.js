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
 * Check that non participants can not use the API.
 *
 *
 */
contract('VotingGreeting: Non Participants', function(accounts) {
    let common = require('./common');


    it("Propose Vote", async function() {
        let secondParticipant = accounts[1];
        const newVotingPeriod = "5";

        let greetingInterface = await common.getInstance();
        // Check that the participant is not a valid participant.
        let didNotTriggerError = false;
        try {
            await greetingInterface.proposeVote(common.NON_PARTICIPANT_VOTE, common.VOTE_CHANGE_VOTING_PERIOD, newVotingPeriod, {from: secondParticipant});
            didNotTriggerError = true;
        } catch(err) {
            // Expect that a revert will be called as the transaction is being sent by an account other than the owner.
            //console.log("ERROR! " + err.message);
        }
        assert.equal(didNotTriggerError, false);
    });


    // TODO one test per API needed here!
});
