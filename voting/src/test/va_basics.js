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
 * Check the basics of the Voting Analysis contract.
 *
 *
 */
const VotingAnalysis = artifacts.require("./VotingAnalysis.sol");

const NUM_RETURNED = 10;

contract('VotingAnalysis: Basics', function(accounts) {
    let common = require('./common');


    it("Active votes when there are no votes", async function() {
        let greetingInterface = await common.getInstance();
        let greetingAddress = greetingInterface.address;

        let votingAnalysis = await VotingAnalysis.deployed();

        let activeVotes = await votingAnalysis.activeVotes.call(greetingAddress, 0);
        for (let i = 0; i < NUM_RETURNED; i++) {
            assert.equal(activeVotes[i], 0);
        }
    });

    it("Active votes when there is one active vote", async function() {
        let secondParticipant = accounts[1];
        let thirdParticipant = accounts[2];
        let fourthParticipant = accounts[3];
        let fifthParticipant = accounts[4];

        let greetingInterface = await common.getInstance();
        let greetingAddress = greetingInterface.address;
        let votingAnalysis = await VotingAnalysis.deployed();

        await greetingInterface.proposeVote(secondParticipant, common.VOTE_ADD_PARTICIPANT, 0);

        let activeVotes = await votingAnalysis.activeVotes.call(greetingAddress, 0);
        assert.equal(activeVotes[0], secondParticipant, "activeVotes[0]");
        for (let i = 1; i < NUM_RETURNED; i++) {
            assert.equal(activeVotes[i], 0, "activeVotes["+i+"]");
        }

        // Wait until the voting period, and the vote viewing period have expired.
        await common.mineBlocks(parseInt(common.VOTE_CHANGE_VOTING_PERIOD) + parseInt(common.VOTE_CHANGE_VOTE_VIEWING_PERIOD));
        await greetingInterface.actionVotes(secondParticipant);
    });



});
