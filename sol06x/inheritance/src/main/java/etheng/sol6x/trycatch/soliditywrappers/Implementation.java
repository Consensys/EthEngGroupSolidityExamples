package etheng.sol6x.trycatch.soliditywrappers;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class Implementation extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50600060208190527f67be87c3ff9960ca1e9cfac5cab2ff4747269cf9ed20c9b7306235ac35a491c5805460ff19908116600190811790925563907ebd0960e01b9092527ffdae8fba2a571348f54c6f645784de80434d4577ad59c0b86a43f8d2f8afa78c80549092161790556101658061008c6000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c8063741351541161005b57806374135154146100825780638ca174a314610082578063b1ade4db146100e1578063da3ba911146100825761007d565b8063013d45d61461008257806301ffc9a71461008c57806354fd4d50146100c7575b600080fd5b61008a6100e9565b005b6100b3600480360360208110156100a257600080fd5b50356001600160e01b0319166100eb565b604080519115158252519081900360200190f35b6100cf61010a565b60408051918252519081900360200190f35b61008a61010f565b565b6001600160e01b03191660009081526020819052604090205460ff1690565b600281565b6101176100e9565b61011f6100e9565b6101276100e9565b6100e96100e956fea26469706673582212209085f7fd6e1002578c785c34edf9875b658a56e3ee60b6251a8c372d730bf6e564736f6c634300060b0033";

    public static final String FUNC_FUNC1 = "func1";

    public static final String FUNC_FUNC2 = "func2";

    public static final String FUNC_FUNC3 = "func3";

    public static final String FUNC_FUNC4 = "func4";

    public static final String FUNC_FUNC5 = "func5";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_VERSION = "version";

    @Deprecated
    protected Implementation(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Implementation(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Implementation(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Implementation(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> func1() {
        final Function function = new Function(
                FUNC_FUNC1, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> func2() {
        final Function function = new Function(
                FUNC_FUNC2, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> func3() {
        final Function function = new Function(
                FUNC_FUNC3, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> func4() {
        final Function function = new Function(
                FUNC_FUNC4, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> func5() {
        final Function function = new Function(
                FUNC_FUNC5, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceID) {
        final Function function = new Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> version() {
        final Function function = new Function(FUNC_VERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Implementation load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Implementation(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Implementation load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Implementation(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Implementation load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Implementation(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Implementation load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Implementation(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Implementation> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Implementation.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Implementation> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Implementation.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Implementation> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Implementation.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Implementation> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Implementation.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
