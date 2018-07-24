pragma solidity ^0.4.23;

/**
 * This contract demonstrates multiple ways of converting from an address to bytes. The examples
 * are taken from stack exchange:
 *
 * https://ethereum.stackexchange.com/questions/884/how-to-convert-an-address-to-bytes-in-solidity/13663#13663
 *
 */
contract AddressToBytes {
    bytes public result0;
    bytes public result1;
    bytes public result2;



    /**
     * Convert an address to bytes using Ethereum assembler.
     *
     * Explaination here:
     * https://ethereum.stackexchange.com/questions/24809/help-to-understand-assembly-method
     *
     * Copying from the above link:
     *
     * 1. let m := mload(0x40) - sets m to current top of memory
     * 2. xor(0x140000000000000000000000000000000000000000, a) - puts 0x14 in front of the
     *    20 bytes of address data and returns a 32-byte word padded with leading zeroes:
     *    0x000000000000000000000014aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
     * 3. add(m, 20) - when the result of the xor is written, it is shifted 20 bytes relative
     *    to the top of memory. This is both clever and dangerous; there's no guarantee that
     *    the memory at m was empty, and we are not competely over-writing it. Anyway, this
     *    puts the 0x14 where we want it at the end of the word and followed by the aaaas
     *    overflowing into the next word.
     * 4. mstore(0x40, add(m, 52)) - finally we update the top of memory pointer; we've added 52 bytes
     *    in total (32 + 20). This would be better as add(m, 64) in my view in case anything elsewhere
     *    relies on memory being word-aligned, but I may be over-cautious.
     * 5. b := m - finally return the (pointer to the) result.
     */
    function toBytes0(address _address) public pure returns (bytes b){
        assembly {
            let m := mload(0x40)
            mstore(add(m, 20), xor(0x140000000000000000000000000000000000000000, _address))
            mstore(0x40, add(m, 52))
            b := m
        }
    }

    function toBytes1(address i) public returns (bytes by) {
        by = new bytes(20);
        assembly {
            let count := 0
            let byptr := add(by, 32)
            loop:
            jumpi(end, eq(count, 20))
            mstore8(byptr, byte(add(count,12), i))
            byptr := add(byptr, 1)
            count := add(count, 1)
            jump(loop)
            end:
        }
        return by;
    }

    function toBytes2(address x) public pure returns (bytes b) {
        b = new bytes(20);
        for (uint i = 0; i < 20; i++)
            b[i] = byte(uint8(uint(x) / (2**(8*(19 - i)))));
    }



    function callToBytes0(address _address) external {
        result0 = toBytes0(_address);
    }
    function callToBytes1(address _address) external {
        result1 = toBytes1(_address);
    }
    function callToBytes2(address _address) external {
        result2 = toBytes2(_address);
    }






    function toBytes0Transaction(address _address) public {
        bytes memory b;
        assembly {
            let m := mload(0x40)
            mstore(add(m, 20), xor(0x140000000000000000000000000000000000000000, _address))
            mstore(0x40, add(m, 52))
            b := m
        }
    }

    function toBytes1Transaction(address i) public {
        bytes memory by = new bytes(20);
        assembly {
            let count := 0
            let byptr := add(by, 32)
            loop:
            jumpi(end, eq(count, 20))
            mstore8(byptr, byte(add(count,12), i))
            byptr := add(byptr, 1)
            count := add(count, 1)
            jump(loop)
            end:
        }
    }

    function toBytes2Transaction(address x) public {
        bytes memory b = new bytes(20);
        for (uint i = 0; i < 20; i++)
            b[i] = byte(uint8(uint(x) / (2**(8*(19 - i)))));
    }



}