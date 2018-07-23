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
 * VotingGreeting.sol unitinialised tests: test the state of the contract, based
 * on only the constructor having been run.
 *
 */
contract('VotingGreetingV2: Empty Tests', function(accounts) {

    let common = require('./common');

    it("getVersion", async function() {
        let greetingInterface = await common.getInstanceV2();
        const ver = await greetingInterface.getVersion.call();
        assert.equal(ver, 2);
    });
});
