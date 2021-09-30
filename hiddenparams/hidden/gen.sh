#!/usr/bin/env bash
set -e
rm -rf build

HERE=hidden
BUILDDIR=$HERE/build
CONTRACTSDIR=$HERE/src/main/solidity
OUTPUTDIR=$HERE/src/main/java
PACKAGE=etheng.hidden.soliditywrappers

WEB3J=web3j


solc $CONTRACTSDIR/Dest.sol --allow-paths . --bin --abi --optimize -o $BUILDDIR --overwrite
solc $CONTRACTSDIR/Source.sol --allow-paths . --bin --abi --optimize -o $BUILDDIR --overwrite

$WEB3J generate solidity -a=$BUILDDIR/Dest.abi -b=$BUILDDIR/Dest.bin -o=$OUTPUTDIR -p=$PACKAGE
$WEB3J generate solidity -a=$BUILDDIR/Source.abi -b=$BUILDDIR/Source.bin -o=$OUTPUTDIR -p=$PACKAGE
