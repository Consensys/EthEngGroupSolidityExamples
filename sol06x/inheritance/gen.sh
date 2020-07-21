#!/usr/bin/env bash
set -e
rm -rf build

HERE=inheritance
BUILDDIR=$HERE/build
CONTRACTSDIR=$HERE/src/main/solidity
OUTPUTDIR=$HERE/src/main/java
PACKAGE=etheng.sol6x.trycatch.soliditywrappers
WEB3J=web3j

pwd

# compiling one file also compiles its dependendencies. We use overwrite to avoid the related warnings.
solc $CONTRACTSDIR/Implementation.sol --allow-paths . --bin --abi --optimize -o $BUILDDIR --overwrite
solc $CONTRACTSDIR/A.sol --allow-paths . --bin --abi --optimize -o $BUILDDIR --overwrite
solc $CONTRACTSDIR/Immutable.sol --allow-paths . --bin --abi --optimize -o $BUILDDIR --overwrite
# ls -al $BUILDDIR

$WEB3J solidity generate -a=$BUILDDIR/Implementation.abi -b=$BUILDDIR/Implementation.bin -o=$OUTPUTDIR -p=$PACKAGE
