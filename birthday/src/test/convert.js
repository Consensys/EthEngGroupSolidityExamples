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


    it("convert", async function() {
        let user = "0x52a64516247f10f05D5c9E3AC20De57090813852";
        let maskedAddress  = web3.utils.keccak256(user);
        console.log("address: " + user);
        console.log("masked address: " + maskedAddress);

        let giver = accounts[1];

        let instance = await Birthday.new(maskedAddress);
        let result1 = await instance.check.call(user);
        let result = web3.utils.toHex(result1);
        console.log("masked: " + result);



    });
});