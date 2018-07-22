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
