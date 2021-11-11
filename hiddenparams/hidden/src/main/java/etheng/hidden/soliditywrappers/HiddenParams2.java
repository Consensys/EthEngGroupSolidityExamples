package etheng.hidden.soliditywrappers;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
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
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class HiddenParams2 extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061062f806100206000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c8063c771ce2d1461005c578063cea5c35814610085578063de292789146100aa578063e51b2a0e146100b2578063fb80fe9e146100ba575b600080fd5b61006f61006a3660046103f0565b6100cf565b60405161007c91906104eb565b60405180910390f35b61008d610136565b604080519283526001600160a01b0390911660208301520161007c565b61008d61015e565b61008d610207565b6100cd6100c836600461051e565b610212565b005b606083838360405160200161010092919091825260601b6bffffffffffffffffffffffff1916602082015260340190565b60408051601f198184030181529082905261011e929160200161054e565b60405160208183030381529060405290509392505050565b60008080368060206033198201843760005194506014808203600c3760005193505050509091565b6000806000805461016e9061057d565b80601f016020809104026020016040519081016040528092919081815260200182805461019a9061057d565b80156101e75780601f106101bc576101008083540402835291602001916101e7565b820191906000526020600020905b8154815290600101906020018083116101ca57829003601f168201915b50505050508060200190518101906101ff91906105b8565b915091509091565b6000806101ff610136565b6040805160048152602481019091526020810180516001600160e01b031663728d950760e11b17905260006102488285856100cf565b9050600080306001600160a01b03168360405161026591906105dd565b6000604051808303816000865af19150503d80600081146102a2576040519150601f19603f3d011682016040523d82523d6000602084013e6102a7565b606091505b5091509150816102fd5760405162461bcd60e51b815260206004820152601a60248201527f43726f737320636f6e74726163742063616c6c206661696c6564000000000000604482015260640160405180910390fd5b8051610310906000906020840190610319565b50505050505050565b8280546103259061057d565b90600052602060002090601f016020900481019282610347576000855561038d565b82601f1061036057805160ff191683800117855561038d565b8280016001018555821561038d579182015b8281111561038d578251825591602001919060010190610372565b5061039992915061039d565b5090565b5b80821115610399576000815560010161039e565b634e487b7160e01b600052604160045260246000fd5b6001600160a01b03811681146103dd57600080fd5b50565b80356103eb816103c8565b919050565b60008060006060848603121561040557600080fd5b833567ffffffffffffffff8082111561041d57600080fd5b818601915086601f83011261043157600080fd5b813581811115610443576104436103b2565b604051601f8201601f19908116603f0116810190838211818310171561046b5761046b6103b2565b8160405282815289602084870101111561048457600080fd5b826020860160208301376000602084830101528097505050505050602084013591506104b2604085016103e0565b90509250925092565b60005b838110156104d65781810151838201526020016104be565b838111156104e5576000848401525b50505050565b602081526000825180602084015261050a8160408501602087016104bb565b601f01601f19169190910160400192915050565b6000806040838503121561053157600080fd5b823591506020830135610543816103c8565b809150509250929050565b600083516105608184602088016104bb565b8351908301906105748183602088016104bb565b01949350505050565b600181811c9082168061059157607f821691505b602082108114156105b257634e487b7160e01b600052602260045260246000fd5b50919050565b600080604083850312156105cb57600080fd5b825191506020830151610543816103c8565b600082516105ef8184602087016104bb565b919091019291505056fea2646970667358221220b399cd91dfb9ec83749722be289151b289309f32082469d280292832025c054d64736f6c63430008090033";

    public static final String FUNC_CALLEDEXT = "calledExt";

    public static final String FUNC_ENCODENONATOMICAUTHPARAMS = "encodeNonAtomicAuthParams";

    public static final String FUNC_EXTRACTNONATOMICAUTHPARAMS = "extractNonAtomicAuthParams";

    public static final String FUNC_GETRESULT = "getResult";

    public static final String FUNC_TEST = "test";

    @Deprecated
    protected HiddenParams2(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected HiddenParams2(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected HiddenParams2(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected HiddenParams2(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Tuple2<BigInteger, String>> calledExt() {
        final Function function = new Function(FUNC_CALLEDEXT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        return new RemoteFunctionCall<Tuple2<BigInteger, String>>(function,
                new Callable<Tuple2<BigInteger, String>>() {
                    @Override
                    public Tuple2<BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<byte[]> encodeNonAtomicAuthParams(byte[] _functionCall, BigInteger _sourceBcId, String _sourceContract) {
        final Function function = new Function(FUNC_ENCODENONATOMICAUTHPARAMS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(_functionCall), 
                new org.web3j.abi.datatypes.generated.Uint256(_sourceBcId), 
                new org.web3j.abi.datatypes.Address(160, _sourceContract)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<Tuple2<BigInteger, String>> extractNonAtomicAuthParams() {
        final Function function = new Function(FUNC_EXTRACTNONATOMICAUTHPARAMS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        return new RemoteFunctionCall<Tuple2<BigInteger, String>>(function,
                new Callable<Tuple2<BigInteger, String>>() {
                    @Override
                    public Tuple2<BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple2<BigInteger, String>> getResult() {
        final Function function = new Function(FUNC_GETRESULT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        return new RemoteFunctionCall<Tuple2<BigInteger, String>>(function,
                new Callable<Tuple2<BigInteger, String>>() {
                    @Override
                    public Tuple2<BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> test(BigInteger _sourceBcId, String _sourceContract) {
        final Function function = new Function(
                FUNC_TEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_sourceBcId), 
                new org.web3j.abi.datatypes.Address(160, _sourceContract)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static HiddenParams2 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new HiddenParams2(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static HiddenParams2 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new HiddenParams2(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static HiddenParams2 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new HiddenParams2(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static HiddenParams2 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new HiddenParams2(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<HiddenParams2> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(HiddenParams2.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<HiddenParams2> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(HiddenParams2.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<HiddenParams2> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(HiddenParams2.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<HiddenParams2> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(HiddenParams2.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
