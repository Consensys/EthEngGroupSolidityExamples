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

contract HiddenParams2 {

    function encodeNonAtomicAuthParams(
        bytes memory _functionCall,
        uint256 _sourceBcId,
        address _sourceContract
    ) public pure returns (bytes memory) {
        return bytes.concat(_functionCall, abi.encodePacked(_sourceBcId, _sourceContract));
    }


    function extractNonAtomicAuthParams()
    public
    pure
    returns (uint256 _sourceBcId, address _sourceContract)
    {
        bytes calldata allParams = msg.data;
        uint256 len = allParams.length;

        assembly {
            calldatacopy(0x0, sub(len, 52), 32)
            _sourceBcId := mload(0)
//            calldatacopy(0x0, sub(len, 32), 32)
            calldatacopy(12, sub(len, 20), 20)
            _sourceContract := mload(0)
        }
    }

    bytes theResult;

    function test(uint256 _sourceBcId, address _sourceContract) external {
        bytes memory functionCall = abi.encodeWithSelector(this.calledExt.selector);

        bytes memory _callWithAuth = encodeNonAtomicAuthParams(functionCall, _sourceBcId, _sourceContract);

        (bool success, bytes memory result) = address(this).call(_callWithAuth);
        require(success, "Cross contract call failed");
        theResult = result;
    }

    function getResult() external view
        returns (uint256, address) {
        return abi.decode(theResult, (uint256, address));

    }

    function calledExt() external pure returns (uint256, address) {
        return extractNonAtomicAuthParams();
    }


}
