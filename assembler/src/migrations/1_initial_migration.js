var Migrations = artifacts.require("./Migrations.sol");
var AddressToBytes = artifacts.require("./AddressToBytes.sol");



module.exports = function(deployer) {
    deployer.deploy(Migrations);
    deployer.deploy(AddressToBytes);
};
