// SPDX-License-Identifier: MIT

pragma solidity ^0.6.0;


contract Conditional{
    address owner;
    uint256 state;

    constructor() public {
        owner = msg.sender;
    }


    function stuff(uint256 _amount) external {
        require(msg.sender == owner);
        if (state == 2) {
            doThis(_amount);
        }
        else {
            doThat(_amount+1);
        }
    }

    function doThis(uint256) private {
    }

    function doThat(uint256) private {
    }
}
