/**
 * This file contains code which is common to many of the test files.
 */

const VotingGreetingImpl = artifacts.require("./VotingGreetingImpl.sol");
// All tests of the public API must be tested via the interface. This ensures all functions
// which are assumed to be part of the public API actually are in the interface.
const VotingGreeting = artifacts.require("./VotingGreeting.sol");



// Note that these values need to match what is set in the 1_initial_migration.js file.
const VOTING_PERIOD = "3";
const VOTE_VIEWING_PERIOD = "2";


// Voting actions. Taken from VotingGreeting.sol.
const VOTE_NONE = "0";
const VOTE_ADD_PARTICIPANT = "1";
const VOTE_REMOVE_PARTICIPANT = "2";
const VOTE_CHANGE_VOTING_ALG = "3";
const VOTE_CHANGE_VOTING_PERIOD = "4";
const VOTE_CHANGE_VOTE_VIEWING_PERIOD = "5";
const VOTE_SET_NEW_IMPLEMENTATION = "6";
const VOTE_CHANGE_GREETING = "7";

// Value used to indicate non-participant voting.
const NON_PARTICIPANT_VOTE = "0";

const mineOneBlock = async function() {
    // Mine one or more blocks.
    await web3.currentProvider.send({
        jsonrpc: '2.0',
        method: 'evm_mine',
        params: [],
        id: 0,
    })
};


const mineBlocks = async function(n) {
    for (let i = 0; i < n; i++) {
        await mineOneBlock()
    }
}


module.exports = {
    VOTING_PERIOD: VOTING_PERIOD,
    VOTE_VIEWING_PERIOD: VOTE_VIEWING_PERIOD,

    VOTE_NONE: VOTE_NONE,
    VOTE_ADD_PARTICIPANT: VOTE_ADD_PARTICIPANT,
    VOTE_REMOVE_PARTICIPANT: VOTE_REMOVE_PARTICIPANT,
    VOTE_CHANGE_VOTING_ALG: VOTE_CHANGE_VOTING_ALG,
    VOTE_CHANGE_VOTING_PERIOD: VOTE_CHANGE_VOTING_PERIOD,
    VOTE_CHANGE_VOTE_VIEWING_PERIOD: VOTE_CHANGE_VOTE_VIEWING_PERIOD,
    VOTE_SET_NEW_IMPLEMENTATION: VOTE_SET_NEW_IMPLEMENTATION,
    VOTE_CHANGE_GREETING: VOTE_CHANGE_GREETING,

    NON_PARTICIPANT_VOTE: NON_PARTICIPANT_VOTE,

    getInstance: async function() {
        let impl = await VotingGreetingImpl.deployed();
        return await VotingGreeting.at(impl.address);
    },

    mineOneBlock: mineOneBlock,

    mineBlocks: mineBlocks

}

