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

contract Memory {
  uint256 val1;
  
  function dynamicArray(uint256 _param) external {
    uint256[] memory dArray;
    dArray[0] = 5;
    dArray[10] = _param;
      
    uint256 total;
    for (uint256 i = 0; i < dArray.length; i++) {
      total += dArray[i];
    }
    val1 = total;
  }

    
}