/**
 * Test out the address to bytes conversion routines. In particular, this 
 * demonstrates the relative gas costs of each method.
 */
const AddressToBytes = artifacts.require("./AddressToBytes.sol");


contract('Assembler: AddressToBytes', function(accounts) {
    const zeroAddress = "0x0";

    const ADDRESS = "0x123456789a123456789a123456789a123456789a";


    it("test", async function() {

        let addressToBytes = await AddressToBytes.deployed();

        let bytes = await addressToBytes.toBytes0.call(ADDRESS);
        assert.equal(bytes, ADDRESS);
        //console.log("toBytes0: " + bytes);

        bytes = await addressToBytes.toBytes2.call(ADDRESS);
        assert.equal(bytes, ADDRESS);

        let transactionResult = await addressToBytes.callToBytes0(ADDRESS);
        bytes = await addressToBytes.result0.call();
        assert.equal(bytes, ADDRESS);
        console.log("Gas Used (toBytes0): " + transactionResult.receipt.gasUsed);

        transactionResult = await addressToBytes.callToBytes1(ADDRESS);
        bytes = await addressToBytes.result1.call();
        assert.equal(bytes, ADDRESS);
        console.log("Gas Used (toBytes1): " + transactionResult.receipt.gasUsed);

        transactionResult = await addressToBytes.callToBytes2(ADDRESS);
        bytes = await addressToBytes.result2.call();
        assert.equal(bytes, ADDRESS);
        console.log("Gas Used (toBytes2): " + transactionResult.receipt.gasUsed);


        transactionResult = await addressToBytes.toBytes0Transaction(ADDRESS);
        console.log("Gas Used (toBytes0): " + transactionResult.receipt.gasUsed);

        transactionResult = await addressToBytes.toBytes1Transaction(ADDRESS);
        console.log("Gas Used (toBytes1): " + transactionResult.receipt.gasUsed);

        transactionResult = await addressToBytes.toBytes2Transaction(ADDRESS);
        console.log("Gas Used (toBytes2): " + transactionResult.receipt.gasUsed);


    });


});
