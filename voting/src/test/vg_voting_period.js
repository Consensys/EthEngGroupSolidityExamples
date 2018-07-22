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
 * Check that the voting period can be changed.
 *
 * Just check with one participant.
 *
 */
contract('VotingGreeting: Voting Period', function(accounts) {
    let common = require('./common');

    it("getVotingPeriodInitial", async function() {
        let greetingInterface = await common.getInstance();
        const votingPeriod = await greetingInterface.getVotingPeriod.call();
        assert.equal(votingPeriod, common.VOTING_PERIOD);
    });

    it("changeVotingPeriod", async function() {
        const newVotingPeriod = "5";
        let greetingInterface = await common.getInstance();

        //let block = await web3.eth.getBlock("latest");
        //console.log("Block: " + block.number);

        await greetingInterface.proposeVote(common.NON_PARTICIPANT_VOTE, common.VOTE_CHANGE_VOTING_PERIOD, newVotingPeriod);
        // Wait until the voting period, and the vote viewing period have expired.
        await common.mineBlocks(parseInt(common.VOTE_CHANGE_VOTING_PERIOD) + parseInt(common.VOTE_CHANGE_VOTE_VIEWING_PERIOD));
        // Check that the voting period does not change until the voting is actioned.
        const votingPeriod = await greetingInterface.getVotingPeriod.call();
        assert.equal(votingPeriod, common.VOTING_PERIOD);

        //block = await web3.eth.getBlock("latest");
        //console.log("Block: " + block.number);

        await greetingInterface.actionVotes(common.NON_PARTICIPANT_VOTE);
        let newVotingPeriodActual = await greetingInterface.getVotingPeriod.call();
        assert.equal(newVotingPeriod, newVotingPeriodActual);
    });

    // TODO Voting Period edge case: 0

    // TODO Voting Period edge case: just less than max uint16

    // TODO Voting Period edge case: just larger than max uint16





});
