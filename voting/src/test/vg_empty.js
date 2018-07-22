/**
 * VotingGreetingImpl.sol unitinialised tests: test the state of the contract, based
 * on only the constructor having been run.
 *
 */
const VotingGreetingImpl = artifacts.require("./VotingGreetingImpl.sol");
// All tests of the public API must be tested via the interface. This ensures all functions
// which are assumed to be part of the public API actually are in the interface.
const VotingGreeting = artifacts.require("./VotingGreeting.sol");

const VotingAlg = artifacts.require("./VotingAlgMajority.sol");

contract('VotingGreeting: Empty Tests', function(accounts) {

    let common = require('./common');

    it("getVersion", async function() {
        let greetingInterface = await common.getInstance();
        const ver = await greetingInterface.getVersion.call();
        assert.equal(ver, 1);
    });

    it("getGreeting", async function() {
        let greetingInterface = await common.getInstance();
        const greeting = await greetingInterface.getGreeting.call();
        assert.equal(greeting, 0);
    });

    it("getVotingPeriod", async function() {
        let greetingInterface = await common.getInstance();
        const votingPeriod = await greetingInterface.getVotingPeriod.call();
        assert.equal(votingPeriod, common.VOTING_PERIOD);
    });

    it("getVoteViewingPeriod", async function() {
        let greetingInterface = await common.getInstance();
        const voteViewingPeriod = await greetingInterface.getVoteViewingPeriod.call();
        assert.equal(voteViewingPeriod, common.VOTE_VIEWING_PERIOD);
    });

    it("getVotingAlg", async function() {
        let votingAlg = await VotingAlg.deployed();
        let greetingInterface = await common.getInstance();
        const votingAlgorithm = await greetingInterface.getVotingAlgorithm.call();
        assert.equal(votingAlgorithm, votingAlg.address);
    });


    it("isParticipantOwner", async function() {
        let greetingInterface = await common.getInstance();
        const isParticipant = await greetingInterface.isParticipant.call(accounts[0]);
        assert.equal(isParticipant, true);
    });

    it("isParticipantOther", async function() {
        let greetingInterface = await common.getInstance();
        const isParticipant = await greetingInterface.isParticipant.call(accounts[1]);
        assert.equal(isParticipant, false);
    });

    it("getNumberParticipants", async function() {
        let greetingInterface = await common.getInstance();
        const actualNumParticipants = await greetingInterface.getNumberParticipants.call();
        assert.equal(actualNumParticipants, 1);
    });


//    it("getNumberUnmaskedSidechainParticipants", async function() {
  //      let pinningInstance = await Pinning.new();
    //    let pinningAddress = pinningInstance.address;
      //  let pinningInterface = await AbstractPinning.at(pinningAddress);
//        let didNotTriggerError = false;
  //      try {
    //        const hasS = await pinningInterface.getNumberUnmaskedSidechainParticipants.call(zeroSidechainId, testOrgInfoAddress1);
      //      didNotTriggerError = true;
//        } catch(err) {
  //          // Expect that a revert will be called as the transaction is being sent by an account other than the owner.
    //        //console.log("ERROR! " + err.message);
      //  }

        //assert.equal(didNotTriggerError, false);
//    });
});
