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

import "./Base.sol";
import "./OtherContract.sol";

contract TryCatch is Base {
    OtherContract otherContract;
    uint256 val1 = 1;
    uint256 state = 1;

    constructor(address _other) public {
        otherContract = OtherContract(_other);
    }

    function doTryCatchOtherContract(uint256 _param) external view returns (uint256, string memory, bytes memory) {
        try otherContract.failureSituations(_param) returns (uint256 v) {
            string memory noReason1;
            bytes memory noBytes1;
            return (v, noReason1, noBytes1);
        } catch Error(string memory reason) {
            // This is executed in case revert was called and a reason string was provided.
            bytes memory noBytes2;
            return (100, reason, noBytes2);
        } catch (bytes memory lowLevelData) {
            // This is executed in case revert() was used or there was a failing assertion, division
            // by zero, etc.
            string memory noReason2;
            return (101, noReason2, lowLevelData);
        }

    }

    function doTryCatchSameContract(uint256 _param) external view returns (uint256, string memory, bytes memory) {
      try this.failureSituations(_param) returns (uint256 v) {
        string memory noReason1;
        bytes memory noBytes1;
        return (v, noReason1, noBytes1);
      } catch Error(string memory reason) {
        // This is executed in case revert was called and a reason string was provided.
        bytes memory noBytes2;
        return (100, reason, noBytes2);
      } catch (bytes memory lowLevelData) {
        // This is executed in case revert() was used or there was a failing assertion, division
        // by zero, etc.
        string memory noReason2;
        return (101, noReason2, lowLevelData);
    }

    }

    function doCatchAll(uint256 _param) external view returns (uint256) {
        try this.failureSituations(_param) returns (uint256 v) {
            return (v);
        } catch {
            return 102;
        }
    }


    function deployOtherContract() public {
      try new OtherContract() returns(OtherContract deployedInstance) {
        otherContract = deployedInstance;
        emit ContractDeploymentSuccess(address(deployedInstance));
      } catch {
        // Do something if the deploy fails!
        emit ContractDeploymentFailed();
      }
    }



    function retainSomeGas(uint256 _param, uint256 _gasToKeep) external view returns (uint256){
      try this.failureSituations{gas:(gasleft() - _gasToKeep)}(_param) returns (uint256 v) {
        return (v);
      } catch {
        return 103;
      }

    }

    function updateState(uint256 _param) external {
      try this.failureSituations(_param) returns (uint256 v) {
        state = v;
      } catch {
        state = 27;
      }
    }



    function doInternal1() external {
        val1 = failureSituations(2);
    }

    function doInternal2() external {
        val1 = this.failureSituations(2);
    }


    event ContractDeploymentFailed();
    event ContractDeploymentSuccess(address deployedAddress);

}
