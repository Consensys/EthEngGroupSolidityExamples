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
pragma solidity ^0.4.23;

import "./VotingGreetingInterface.sol";


/**
 * Contract to allow analysis of what is by voted on and who has voted on what.
 */
contract VotingAnalysis {
    uint16 constant NUM_RETURNED = 10;


    /**
     * Return the an array of addresses being actively voted on. Due to issues with returning variable length arrays
     * from solidity, the returned array is limited to 10.
     */
    function activeVotes(address _votingGreetingImpl, uint _offset) external view returns (address[NUM_RETURNED]) {
        VotingGreetingInterface vg = VotingGreetingInterface(_votingGreetingImpl);
        address[] memory active = vg.getActiveVotes();
        address[NUM_RETURNED] memory active1;

        uint ofs = _offset;
        uint found = 0;
        while (ofs < active.length && found < NUM_RETURNED) {
            if (active[ofs] != 0) {
                active1[found++] = active[ofs];
            }
            ofs++;
        }
        return active1;
    }

    /**
     * Find the offset of the first item actively being voted on.
     *
     * @param _votingGreetingImpl  The address of the VotingGreeting contract.`
     * @param _offset              The offset within the voting data structure to use.
     * @return bool   True if there is an active vote.
     *         uint   The offset of the active vote.
     */
    function findFirstActiveVote(address _votingGreetingImpl, uint _offset) external view returns (bool, uint) {
        VotingGreetingInterface vg = VotingGreetingInterface(_votingGreetingImpl);
        address[] memory active = vg.getActiveVotes();

        uint ofs = _offset;
        while (ofs < active.length) {
            if (active[ofs] != 0) {
                return (true, ofs);
            }
            ofs++;
        }
        return (false, 0);
    }


    // TODO Write some code to provide ananlysis of an active vote.

}