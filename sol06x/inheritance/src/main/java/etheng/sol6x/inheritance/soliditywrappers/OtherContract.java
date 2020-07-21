package etheng.sol6x.trycatch.soliditywrappers;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.16.
 */
@SuppressWarnings("rawtypes")
public class OtherContract extends Contract {
    public static final String BINARY = "6080604052600160005534801561001557600080fd5b50610178806100256000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c8063b4e857c214610030575b600080fd5b61004d6004803603602081101561004657600080fd5b503561005f565b60408051918252519081900360200190f35b6000600782106100b6576040805162461bcd60e51b815260206004820152601b60248201527f506172616d2073686f756c64206265206c657373207468616e20370000000000604482015290519081900360640190fd5b81600614156100c457600080fd5b81600514156100d257600080fd5b8160041415610128576040805162461bcd60e51b815260206004820152601c60248201527f4661696c696e672062656361757365205f706172616d20776173203400000000604482015290519081900360640190fd5b81600314156101375760008083fe5b50600054016011019056fea2646970667358221220a3ea1776aeb9b16fdfba610c5f17171d6d4619d11aeb75d288cb7a85c9c6f0c464736f6c634300060b0033";

    public static final String FUNC_AFUNCTION = "aFunction";

    @Deprecated
    protected OtherContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected OtherContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected OtherContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected OtherContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> aFunction(BigInteger _param) {
        final Function function = new Function(FUNC_AFUNCTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_param)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static OtherContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new OtherContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static OtherContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new OtherContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static OtherContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new OtherContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static OtherContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new OtherContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<OtherContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(OtherContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<OtherContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(OtherContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<OtherContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(OtherContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<OtherContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(OtherContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
