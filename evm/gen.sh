#!/usr/bin/env bash
rm -rf build

BUILDDIR=./build
BUILDDIRO=./build/optimize
BUILDDIRN=./build/normal
CONTRACTSDIR=contracts


# compiling one file also compiles its dependendencies. We use overwrite to avoid the related warnings.
solc $CONTRACTSDIR/Simple.sol --allow-paths . --asm --asm-json --hashes --userdoc  --devdoc  --metadata --opcodes --bin --abi --optimize -o $BUILDDIRO --overwrite
solc $CONTRACTSDIR/SimpleFallBack.sol --allow-paths . --asm --asm-json --hashes --userdoc  --devdoc  --metadata --opcodes --bin --abi --optimize -o $BUILDDIRO --overwrite
solc $CONTRACTSDIR/StorageLayout.sol --allow-paths . --asm --asm-json --hashes --userdoc  --devdoc  --metadata --opcodes --bin --abi --optimize -o $BUILDDIRO --overwrite
solc $CONTRACTSDIR/StorageMappings.sol --allow-paths . --asm --asm-json --hashes --userdoc  --devdoc  --metadata --opcodes --bin --abi --optimize -o $BUILDDIRO --overwrite
solc $CONTRACTSDIR/StorageBytes.sol --allow-paths . --asm --asm-json --hashes --userdoc  --devdoc  --metadata --opcodes --bin --abi --optimize -o $BUILDDIRO --overwrite
solc $CONTRACTSDIR/StorageArrays.sol --allow-paths . --asm --asm-json --hashes --userdoc  --devdoc  --metadata --opcodes --bin --abi --optimize -o $BUILDDIRO --overwrite



solc $CONTRACTSDIR/Memory.sol --allow-paths . --asm --asm-json --hashes --userdoc  --devdoc  --metadata --opcodes --bin --abi --optimize -o $BUILDDIRO --overwrite
solc $CONTRACTSDIR/Modifier.sol --allow-paths . --asm --asm-json --hashes --userdoc  --devdoc  --metadata --opcodes --bin --abi --optimize -o $BUILDDIRO --overwrite
solc $CONTRACTSDIR/ERC20.sol --allow-paths . --asm --asm-json --hashes --userdoc  --devdoc  --metadata --opcodes --bin --abi --optimize -o $BUILDDIRO --overwrite



solc $CONTRACTSDIR/Simple.sol --allow-paths . --asm --asm-json --hashes --userdoc  --devdoc  --metadata --opcodes --bin --abi -o $BUILDDIRN --overwrite
# solc $CONTRACTSDIR/ERC20.sol --allow-paths . --asm --asm-json --hashes --userdoc  --devdoc  --metadata --opcodes --bin --abi -o $BUILDDIRN --overwrite
ls $BUILDDIRO

