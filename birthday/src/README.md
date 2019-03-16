# Birthday

These directories contain some code used as a challenge: The entity which deploys 
 the contract has to determine a salt, which when message digested with the user's 
 address has an output which is modulo 2**16+1.

The contracts are written in Solidity. The code is tested utilising the Truffle 
framework.  For more information on installing and using Truffle, please 
refer to: http://truffleframework.com/docs/getting_started/installation



# Truffle Installation:
```
npm install -g truffle
```

# Running the tests:
Truffle permits writing tests in Javascript or Solidity.  The tests that 
are currently included are writted in Javascript, which uses the 
Mocha framework (https://mochajs.org/) and 
Chai (http://www.chaijs.com/) for assertions.

## To run the tests:
1. Start the Truffle dev blockchain + console:
```
truffle develop
```

2. Compile the Solidity source:
```
compile
```

3. Ensure the latest contracts are deployed:
```
migrate --reset
```

4. Run the tests:
```
test
```

5. To exit:
```
.exit
```


# Running the Truffle console logger
Execute the following command in a separate window to your Truffle developer console:
```
truffle develop --log
```

# Running the gas tests and example
Execute the following command:
```
truffle develop
```
Then for the examples execute:
```
test test_examples/example.js
```
Then for the gas cost tests execute:
```
test test_gas/gas_test.js
```
