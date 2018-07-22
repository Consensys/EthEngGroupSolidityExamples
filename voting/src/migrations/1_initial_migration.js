var Migrations = artifacts.require("./Migrations.sol");
var VotingGreetingImpl = artifacts.require("./VotingGreetingImpl.sol");
var VotingAlgMajority = artifacts.require("./VotingAlgMajority.sol");
var VotingAlgMajorityWhoVoted = artifacts.require("./VotingAlgMajorityWhoVoted.sol");
var VotingGreetingDataHolder = artifacts.require("./VotingGreetingDataHolder.sol");


module.exports = function(deployer) {
    deployer.deploy(Migrations);
    deployer.deploy(VotingAlgMajority);
    deployer.deploy(VotingAlgMajorityWhoVoted).then(() => {
        return deployer.deploy(VotingGreetingImpl);
    }).then(() => {
        return deployer.deploy(VotingGreetingDataHolder, VotingGreetingImpl.address, VotingAlgMajority.address, 3, 2);
    }).then(async () => {
        let votingImpl = await VotingGreetingImpl.deployed();
        await votingImpl.setDataHolder(VotingGreetingDataHolder.address);
    });



};
