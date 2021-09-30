/*
 * Copyright 2021 ConsenSys AG.
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
pragma solidity >=0.8;

abstract contract Auth {

    function extractHiddenParams() internal pure returns (uint256 a1, uint256 a2, uint256 a3) {
        bytes calldata allParams = msg.data;
        uint256 len = allParams.length;

        assembly {
            calldatacopy(0x0, sub(len, 96), 32)
            a1 := mload(0)
            calldatacopy(0x0, sub(len, 64), 32)
            a2 := mload(0)
            calldatacopy(0x0, sub(len, 32), 32)
            a3 := mload(0)
//            a1 := mload(add(allParams, len))
//            a2 := mload(add(allParams, sub(len, 32)))
//            a3 := mload(add(allParams, sub(len, 64)))
        }
    }
}

