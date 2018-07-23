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
 * Measure the gas usage of functions.
 *
 *  At present, these tests simply print out to the screen.
 */
contract('VotingGreeting: Gas Usage', function(accounts) {
    let common = require('./common');


    it("gas for voting", async function() {
        const newVotingPeriod = "5";
        let greetingInterface = await common.getInstance();

        let result = await greetingInterface.proposeVote(common.NON_PARTICIPANT_VOTE, common.VOTE_CHANGE_VOTING_PERIOD, newVotingPeriod);
        console.log("gas cost of proposeVote: " + result.receipt.gasUsed);
        // Wait until the voting period, and the vote viewing period have expired.
        await common.mineBlocks(parseInt(common.VOTE_CHANGE_VOTING_PERIOD) + parseInt(common.VOTE_CHANGE_VOTE_VIEWING_PERIOD));
        result = await greetingInterface.actionVotes(common.NON_PARTICIPANT_VOTE);
        console.log("gas cost of actionVotes: " + result.receipt.gasUsed);
    });

});
