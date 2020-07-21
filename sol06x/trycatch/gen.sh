#!/usr/bin/env bash
set -e
rm -rf build

HERE=trycatch
BUILDDIR=$HERE/build
CONTRACTSDIR=$HERE/src/main/solidity
OUTPUTDIR=$HERE/src/main/java
PACKAGE=etheng.sol6x.trycatch.soliditywrappers
WEB3J=web3j

pwd

# compiling one file also compiles its dependendencies. We use overwrite to avoid the related warnings.
solc $CONTRACTSDIR/OtherContract.sol --allow-paths . --bin --abi --optimize -o $BUILDDIR --overwrite
solc $CONTRACTSDIR/TryCatch.sol --allow-paths . --bin --abi --optimize -o $BUILDDIR --overwrite
# ls -al $BUILDDIR

$WEB3J solidity generate -a=$BUILDDIR/OtherContract.abi -b=$BUILDDIR/OtherContract.bin -o=$OUTPUTDIR -p=$PACKAGE
$WEB3J solidity generate -a=$BUILDDIR/TryCatch.abi -b=$BUILDDIR/TryCatch.bin -o=$OUTPUTDIR -p=$PACKAGE
