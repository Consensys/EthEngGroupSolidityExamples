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
pragma solidity >=0.4.23;


contract Birthday {
    bytes32 public maskedUser; // Only this user can retrieve the balance.
    uint256 public constant PRIME = 65537;

    /**
     * Send some Ether to the contract and set-up who can use the contract.
     *
     * @param _user The keccak256 of the address of the user of the contract.
     */
    constructor (bytes32 _user) public payable {
        maskedUser = _user;
    }

    /**
     * Return the Ether balance of the contract if the user can determine a
     * salt such that check ends up being zero.
     *
     * @param _salt The salt value.
     */
    function happy(uint256 _salt) external {
        require(keccak256(abi.encodePacked(msg.sender)) == maskedUser);

        uint256 mask = uint256(keccak256(abi.encodePacked(msg.sender, _salt)));
        uint256 check = (mask % PRIME);
        require(check == 0);

        msg.sender.transfer(address(this).balance);
    }
}