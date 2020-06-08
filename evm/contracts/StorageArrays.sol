/*
 * Copyright 2019 ConsenSys AG.
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
pragma solidity >=0.4.23;

contract StorageArrays {
    uint256[] private arrayUint256;
    byte[] private arrayByte;

    function setUint256ArrayVal(uint256 _ofs, uint256 _val) external {
        arrayUint256[_ofs] = _val;
    }

    function setByteArrayVal(uint256 _ofs, byte _val) external {
        arrayByte[_ofs] = _val;
    }
}