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
const Birthday = artifacts.require("./Birthday.sol");

contract('Test:', function(accounts) {

    const PRIME = 65537;

    const ALL_ZEROS_256_BIT = "0000000000000000000000000000000000000000000000000000000000000000";
    const ALL_ZEROS_256_BIT_LEN = ALL_ZEROS_256_BIT.length;


    it("unmask", async function() {
        let user = accounts[0];
        let giver = accounts[1];
        let maskedAddress  = web3.utils.keccak256(user);

        let instance = await Birthday.new(maskedAddress, {from: giver, value: web3.utils.toWei("1","ether")});

        // Check the balances. accounts[0] and [1] have used some Ether to deploy Birthday contract here
        // and in the migration.js.
        // The balance of the contract should be at 1 Ether.
        let balance = await web3.eth.getBalance(user);
        console.log("balance user: " + balance);
        balance = await web3.eth.getBalance(giver);
        console.log("balance giver: " + balance);
        balance = await web3.eth.getBalance(instance.address);
        console.log("balance contract: " + balance);


        var salty = 0;
        var check = 0;
        var salt1;
        do {
            // Loop around incrementing salty until a value is found such that check will be zero.
            // This brute force method won't take long as the prime is small.
            salty++;
            salt1 = salty.toString(16);
            salt1 = ALL_ZEROS_256_BIT.substr(0, ALL_ZEROS_256_BIT_LEN - salt1.length) + salt1;
            //console.log("salt: " + salt1);

            let mask  = web3.utils.keccak256(user + salt1);
            //console.log("Mask: " + mask);

            let maskInt = BigInt(mask);
            //console.log("Mask: " + maskInt);

            check = maskInt % BigInt(PRIME);
            //console.log("Check: " + check);

        } while (check !== 0n);

        let salt = "0x" + salt1;

        let result = await instance.happy(salt, {from: user});
        console.log("Gas used: " + result.receipt.gasUsed);


        // Check the balances. accounts[0] should now be 1 Ether richer!
        // The balance of the contract should be zero now.
        balance = await web3.eth.getBalance(user);
        console.log("balance user: " + balance);
        balance = await web3.eth.getBalance(giver);
        console.log("balance giver: " + balance);
        balance = await web3.eth.getBalance(instance.address);
        console.log("balance contract: " + balance);
    });
});