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
 * Check that upgrade works.
 *
 *
 */
contract('VotingGreetingV2: Upgrade', function(accounts) {
    let common = require('./common');


    it("Upgrade", async function() {
        let greetingInterface = await common.getInstance();
        let greetingInterfaceV2 = await common.getInstanceV2();

        await greetingInterface.proposeVote(common.NON_PARTICIPANT_VOTE, common.VOTE_SET_NEW_IMPLEMENTATION, greetingInterfaceV2.address);
        // Wait until the voting period, and the vote viewing period have expired.
        await common.mineBlocks(parseInt(common.VOTE_CHANGE_VOTING_PERIOD) + parseInt(common.VOTE_CHANGE_VOTE_VIEWING_PERIOD));
        await greetingInterface.actionVotes(common.NON_PARTICIPANT_VOTE);

        // The implementation which the data holder will accept transactions from has changed to the v2 contract.
        const newVotingPeriod = "5";
        await greetingInterfaceV2.proposeVote(common.NON_PARTICIPANT_VOTE, common.VOTE_CHANGE_VOTING_PERIOD, newVotingPeriod);
        // Wait until the voting period, and the vote viewing period have expired.
        await common.mineBlocks(parseInt(common.VOTE_CHANGE_VOTING_PERIOD) + parseInt(common.VOTE_CHANGE_VOTE_VIEWING_PERIOD));
        await greetingInterfaceV2.actionVotes(common.NON_PARTICIPANT_VOTE);
        let newVotingPeriodActual = await greetingInterfaceV2.getVotingPeriod.call();
        assert.equal(newVotingPeriod, newVotingPeriodActual);
    });

});
