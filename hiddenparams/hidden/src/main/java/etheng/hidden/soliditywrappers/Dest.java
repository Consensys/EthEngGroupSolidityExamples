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
import org.web3j.abi.datatypes.Bool;
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
public class Dest extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5060405161056a38038061056a83398101604081905261002f91610040565b60009290925560015560025561006e565b60008060006060848603121561005557600080fd5b8351925060208401519150604084015190509250925092565b6104ed8061007d6000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c80631a763bc31461006757806342b938551461007c5780635eb6d4191461008f5780638963b2bc146100a2578063e087b8aa146100b5578063e840e56f146100c8575b600080fd5b61007a61007536600461044a565b6100d0565b005b61007a61008a3660046103e3565b610157565b61007a61009d3660046103fc565b610175565b61007a6100b036600461047c565b61024a565b61007a6100c336600461041e565b610255565b61007a610299565b6100db8383836102b3565b8360111461011d5760405162461bcd60e51b815260206004820152600a602482015269115c9c9bdc8e8815985b60b21b60448201526064015b60405180910390fd5b604051600181527ff7c630da6df086d6ed502f0fc2cb33c52db1e56e1aee68b2a159b6e0117673779060200160405180910390a150505050565b60008060006101646103ab565b9250925092506100db8383836102b3565b60008060006101826103ab565b9250925092506101938383836102b3565b846011146101d15760405162461bcd60e51b815260206004820152600b60248201526a4572726f723a2056616c3160a81b6044820152606401610114565b8360171461020f5760405162461bcd60e51b815260206004820152600b60248201526a22b93937b91d102b30b61960a91b6044820152606401610114565b604051600181527ff7c630da6df086d6ed502f0fc2cb33c52db1e56e1aee68b2a159b6e0117673779060200160405180910390a15050505050565b6101938383836102b3565b6102608383836102b3565b604051600181527ff7c630da6df086d6ed502f0fc2cb33c52db1e56e1aee68b2a159b6e0117673779060200160405180910390a1505050565b60008060006102a66103ab565b9250925092506102608383835b60005483146103045760405162461bcd60e51b815260206004820152601760248201527f466972737420706172616d206e6f7420636f72726563740000000000000000006044820152606401610114565b60015482146103555760405162461bcd60e51b815260206004820152601860248201527f5365636f6e6420706172616d206e6f7420636f727265637400000000000000006044820152606401610114565b60025481146103a65760405162461bcd60e51b815260206004820152601760248201527f546869726420706172616d206e6f7420636f72726563740000000000000000006044820152606401610114565b505050565b600080808036806020605f19820184376000519550602060408203600037600051945060208082036000376000519350505050909192565b6000602082840312156103f557600080fd5b5035919050565b6000806040838503121561040f57600080fd5b50508035926020909101359150565b60008060006060848603121561043357600080fd5b505081359360208301359350604090920135919050565b6000806000806080858703121561046057600080fd5b5050823594602084013594506040840135936060013592509050565b600080600080600060a0868803121561049457600080fd5b50508335956020850135955060408501359460608101359450608001359250905056fea2646970667358221220f8e27346dd13d36a62d16382dbef027241b65ccfcdbd268c16b2d38b39f05ca264736f6c63430008050033";

    public static final String FUNC_FUNCNOPARAMS = "funcNoParams";

    public static final String FUNC_FUNCNOPARAMSEXPLICIT = "funcNoParamsExplicit";

    public static final String FUNC_FUNCONEPARAM = "funcOneParam";

    public static final String FUNC_FUNCONEPARAMEXPLICIT = "funcOneParamExplicit";

    public static final String FUNC_FUNCTWOPARAMS = "funcTwoParams";

    public static final String FUNC_FUNCTWOPARAMSEXPLICIT = "funcTwoParamsExplicit";

    public static final Event ALLGOOD_EVENT = new Event("AllGood", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
    ;

    @Deprecated
    protected Dest(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Dest(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Dest(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Dest(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AllGoodEventResponse> getAllGoodEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ALLGOOD_EVENT, transactionReceipt);
        ArrayList<AllGoodEventResponse> responses = new ArrayList<AllGoodEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AllGoodEventResponse typedResponse = new AllGoodEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.happy = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AllGoodEventResponse> allGoodEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AllGoodEventResponse>() {
            @Override
            public AllGoodEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ALLGOOD_EVENT, log);
                AllGoodEventResponse typedResponse = new AllGoodEventResponse();
                typedResponse.log = log;
                typedResponse.happy = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AllGoodEventResponse> allGoodEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ALLGOOD_EVENT));
        return allGoodEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> funcNoParams() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FUNCNOPARAMS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> funcNoParamsExplicit(BigInteger a1, BigInteger a2, BigInteger a3) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FUNCNOPARAMSEXPLICIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a1), 
                new org.web3j.abi.datatypes.generated.Uint256(a2), 
                new org.web3j.abi.datatypes.generated.Uint256(a3)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> funcOneParam(BigInteger _val) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FUNCONEPARAM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_val)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> funcOneParamExplicit(BigInteger _val, BigInteger a1, BigInteger a2, BigInteger a3) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FUNCONEPARAMEXPLICIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_val), 
                new org.web3j.abi.datatypes.generated.Uint256(a1), 
                new org.web3j.abi.datatypes.generated.Uint256(a2), 
                new org.web3j.abi.datatypes.generated.Uint256(a3)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> funcTwoParams(BigInteger _val1, BigInteger _val2) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FUNCTWOPARAMS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_val1), 
                new org.web3j.abi.datatypes.generated.Uint256(_val2)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> funcTwoParamsExplicit(BigInteger _val1, BigInteger _val2, BigInteger a1, BigInteger a2, BigInteger a3) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FUNCTWOPARAMSEXPLICIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_val1), 
                new org.web3j.abi.datatypes.generated.Uint256(_val2), 
                new org.web3j.abi.datatypes.generated.Uint256(a1), 
                new org.web3j.abi.datatypes.generated.Uint256(a2), 
                new org.web3j.abi.datatypes.generated.Uint256(a3)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Dest load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Dest(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Dest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Dest(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Dest load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Dest(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Dest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Dest(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Dest> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger _expected1, BigInteger _expected2, BigInteger _expected3) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_expected1), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected2), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected3)));
        return deployRemoteCall(Dest.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Dest> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger _expected1, BigInteger _expected2, BigInteger _expected3) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_expected1), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected2), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected3)));
        return deployRemoteCall(Dest.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Dest> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _expected1, BigInteger _expected2, BigInteger _expected3) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_expected1), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected2), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected3)));
        return deployRemoteCall(Dest.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Dest> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _expected1, BigInteger _expected2, BigInteger _expected3) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_expected1), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected2), 
                new org.web3j.abi.datatypes.generated.Uint256(_expected3)));
        return deployRemoteCall(Dest.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class AllGoodEventResponse extends BaseEventResponse {
        public Boolean happy;
    }
}
