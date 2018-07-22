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
 * Check that the greeting can be set and can be changed.
 *
 * Just check with one participant.
 *
 */

var Web3 = require('web3');
var web3 = new Web3();

contract('VotingGreeting: Greeting', function(accounts) {
    let common = require('./common');

    it("getGreetingInitial", async function() {
        let greetingInterface = await common.getInstance();
        const greeting = await greetingInterface.getGreeting.call();
        assert.equal(greeting, 0);
    });

    it("changeGreetingExactLength", async function() {
        const newGreeting = "Welcome to the voting greeting!!";
        //                   12345678901234567890123456789012
        await commonTest(newGreeting);
    });

    it("changeGreetingOneCharacter", async function() {
        const newGreeting = "x";
        //                   12345678901234567890123456789012
        await commonTest(newGreeting);
    });

    it("changeGreetingFiveCharacters", async function() {
        const newGreeting = "hello";
        //                   12345678901234567890123456789012
        await commonTest(newGreeting);
    });


    async function commonTest(newGreeting) {
        let newGreetingHex = web3.utils.asciiToHex(newGreeting);
        let greetingInterface = await common.getInstance();
        //let block = await web3.eth.getBlock("latest");
        //console.log("Block: " + block.number);

        await greetingInterface.proposeVote(common.NON_PARTICIPANT_VOTE, common.VOTE_CHANGE_GREETING, newGreetingHex);
        // Wait until the voting period, and the vote viewing period have expired.
        await common.mineBlocks(parseInt(common.VOTE_CHANGE_VOTING_PERIOD) + parseInt(common.VOTE_CHANGE_VOTE_VIEWING_PERIOD));

        //block = await web3.eth.getBlock("latest");
        //console.log("Block: " + block.number);

        await greetingInterface.actionVotes(common.NON_PARTICIPANT_VOTE);

        const newGreetingActualInt = await greetingInterface.getGreeting.call();
        const newGreetingActual = web3.utils.hexToUtf8(web3.utils.toHex(newGreetingActualInt));

        assert.equal(newGreeting, newGreetingActual);
    }

});
