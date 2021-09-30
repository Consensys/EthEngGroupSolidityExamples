package etheng.hidden.soliditywrappers;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
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
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Source extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5060405161062138038061062183398101604081905261002f91610061565b600080546001600160a01b0319166001600160a01b0395909516949094179093556001919091556002556003556100ac565b6000806000806080858703121561007757600080fd5b84516001600160a01b038116811461008e57600080fd5b60208601516040870151606090970151919890975090945092505050565b610566806100bb6000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c806302175e85146100675780633893d94014610071578063452d9f25146100795780637ce388e614610081578063dd49430714610089578063f42438a014610091575b600080fd5b61006f610099565b005b61006f610118565b61006f61016e565b61006f6101a2565b61006f6101ea565b61006f61023c565b600054600154600254600354604051631a763bc360e01b8152601160048201526024810193909352604483019190915260648201526001600160a01b0390911690631a763bc3906084015b600060405180830381600087803b1580156100fe57600080fd5b505af1158015610112573d6000803e3d6000fd5b50505050565b600054600154600254600354604051632258ecaf60e21b815260116004820152601760248201526044810193909352606483019190915260848201526001600160a01b0390911690638963b2bc9060a4016100e4565b6040805160048152602481019091526020810180516001600160e01b031663e840e56f60e01b1790526101a090610262565b565b600054600154600254600354604051637043dc5560e11b81526004810193909352602483019190915260448201526001600160a01b039091169063e087b8aa906064016100e4565b604051601160248201526101a0906342b9385560e01b906044015b60408051601f198184030181529190526020810180516001600160e01b03166001600160e01b031990931692909217909152610262565b60405160116024820152601760448201526101a090635eb6d41960e01b90606401610205565b60015460025460035460408051602081019490945283019190915260608201526000906080016040516020818303038152906040529050600082826040516020016102ae92919061048c565b60408051601f198184030181529082905260008054919350916060916001600160a01b0316906102df908590610470565b6000604051808303816000865af19150503d806000811461031c576040519150601f19603f3d011682016040523d82523d6000602084013e610321565b606091505b50909250905081610357576103358161035e565b60405162461bcd60e51b815260040161034e91906104bb565b60405180910390fd5b5050505050565b60606044825110156103a357505060408051808201909152601d81527f5472616e73616374696f6e2072657665727465642073696c656e746c79000000602082015290565b600482019150818060200190518101906103bd91906103c3565b92915050565b6000602082840312156103d557600080fd5b815167ffffffffffffffff808211156103ed57600080fd5b818401915084601f83011261040157600080fd5b8151818111156104135761041361051a565b604051601f8201601f19908116603f0116810190838211818310171561043b5761043b61051a565b8160405282815287602084870101111561045457600080fd5b6104658360208301602088016104ee565b979650505050505050565b600082516104828184602087016104ee565b9190910192915050565b6000835161049e8184602088016104ee565b8351908301906104b28183602088016104ee565b01949350505050565b60208152600082518060208401526104da8160408501602087016104ee565b601f01601f19169190910160400192915050565b60005b838110156105095781810151838201526020016104f1565b838111156101125750506000910152565b634e487b7160e01b600052604160045260246000fdfea26469706673582212201b1ec2754239d48d80f9b6520276e11e4089568c1944631f53bfd6c45766ac7b64736f6c63430008050033";

    public static final String FUNC_CALLFUNCNOPARAMS = "callFuncNoParams";

    public static final String FUNC_CALLFUNCNOPARAMSEXPLICIT = "callFuncNoParamsExplicit";

    public static final String FUNC_CALLFUNCONEPARAM = "callFuncOneParam";

    public static final String FUNC_CALLFUNCONEPARAMEXPLICIT = "callFuncOneParamExplicit";

    public static final String FUNC_CALLFUNCTWOPARAMS = "callFuncTwoParams";

    public static final String FUNC_CALLFUNCTWOPARAMSEXPLICIT = "callFuncTwoParamsExplicit";

    public static final Event DUMP_EVENT = new Event("Dump", 
            Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
    ;

    @Deprecated
    protected Source(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Source(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Source(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Source(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<DumpEventResponse> getDumpEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DUMP_EVENT, transactionReceipt);
        ArrayList<DumpEventResponse> responses = new ArrayList<DumpEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DumpEventResponse typedResponse = new DumpEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._b = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DumpEventResponse> dumpEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DumpEventResponse>() {
            @Override
            public DumpEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DUMP_EVENT, log);
                DumpEventResponse typedResponse = new DumpEventResponse();
                typedResponse.log = log;
                typedResponse._b = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DumpEventResponse> dumpEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DUMP_EVENT));
        return dumpEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> callFuncNoParams() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CALLFUNCNOPARAMS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> callFuncNoParamsExplicit() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CALLFUNCNOPARAMSEXPLICIT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> callFuncOneParam() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CALLFUNCONEPARAM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> callFuncOneParamExplicit() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CALLFUNCONEPARAMEXPLICIT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> callFuncTwoParams() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CALLFUNCTWOPARAMS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> callFuncTwoParamsExplicit() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CALLFUNCTWOPARAMSEXPLICIT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Source load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Source(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Source load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Source(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Source load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Source(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Source load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Source(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Source> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _dest, BigInteger _expected1, BigInteger _expected2, BigInteger _expected3) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _dest), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected1), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected2), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected3)));
        return deployRemoteCall(Source.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Source> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _dest, BigInteger _expected1, BigInteger _expected2, BigInteger _expected3) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _dest), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected1), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected2), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected3)));
        return deployRemoteCall(Source.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Source> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _dest, BigInteger _expected1, BigInteger _expected2, BigInteger _expected3) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _dest), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected1), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected2), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected3)));
        return deployRemoteCall(Source.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Source> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _dest, BigInteger _expected1, BigInteger _expected2, BigInteger _expected3) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _dest), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected1), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected2), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected3)));
        return deployRemoteCall(Source.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class DumpEventResponse extends BaseEventResponse {
        public byte[] _b;
    }
}
