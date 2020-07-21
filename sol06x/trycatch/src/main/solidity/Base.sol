/*
 * Copyright 2020 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
pragma solidity >=0.6.11;

contract Base {
    uint256 val2 = 1;

    function failureSituations(uint256 _param) public view returns (uint256) {
        require(_param < 8, "Param should be less than 8");
        require(_param != 6); // Require with no reason
        if (_param == 5) {
            revert();
        }
        if (_param == 4) {
            revert("Failing because _param was 4");
        }
        if (_param == 3) {
            uint256 zero = 0;
            return _param / zero;
        }
        assert(_param != 7);

        return _param + val2 + 13;
    }
}
