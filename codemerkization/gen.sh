#!/usr/bin/env bash
rm -rf build

BUILDDIR=./build
BUILDDIRO=./build/optimize
BUILDDIRN=./build/normal
CONTRACTSDIR=contracts


# compiling one file also compiles its dependendencies. We use overwrite to avoid the related warnings.
solc $CONTRACTSDIR/ERC20.sol --allow-paths . --asm --asm-json --hashes --userdoc  --devdoc  --metadata --opcodes --bin --abi --optimize -o $BUILDDIRO --overwrite
solc $CONTRACTSDIR/Conditional.sol --allow-paths . --asm --asm-json --hashes --userdoc  --devdoc  --metadata --opcodes --bin --abi --optimize -o $BUILDDIRO --overwrite

ls $BUILDDIRO

