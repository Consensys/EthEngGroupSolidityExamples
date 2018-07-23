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
var Migrations = artifacts.require("./Migrations.sol");
var VotingGreetingImpl = artifacts.require("./VotingGreeting.sol");
var VotingAlgMajority = artifacts.require("./VotingAlgMajority.sol");
var VotingAlgMajorityWhoVoted = artifacts.require("./VotingAlgMajorityWhoVoted.sol");
var VotingGreetingDataHolder = artifacts.require("./VotingGreetingDataHolder.sol");
var VotingAnalysis = artifacts.require("./VotingAnalysis.sol");


module.exports = function(deployer) {
    deployer.deploy(Migrations);
    deployer.deploy(VotingAlgMajority);
    deployer.deploy(VotingAnalysis);
    deployer.deploy(VotingAlgMajorityWhoVoted).then(() => {
        return deployer.deploy(VotingGreetingImpl);
    }).then(() => {
        return deployer.deploy(VotingGreetingDataHolder, VotingGreetingImpl.address, VotingAlgMajority.address, 3, 2);
    }).then(async () => {
        let votingImpl = await VotingGreetingImpl.deployed();
        await votingImpl.setDataHolder(VotingGreetingDataHolder.address);
    });



};
