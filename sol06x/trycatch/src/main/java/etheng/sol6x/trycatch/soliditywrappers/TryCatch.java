package etheng.sol6x.trycatch.soliditywrappers;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
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
public class TryCatch extends Contract {
    public static final String BINARY = "608060405260016000556001600255600160035534801561001f57600080fd5b50604051610a2b380380610a2b8339818101604052602081101561004257600080fd5b5051600180546001600160a01b0319166001600160a01b039092169190911790556109b9806100726000396000f3fe608060405234801561001057600080fd5b50600436106100935760003560e01c8063804778211161006657806380477821146101f057806382e67005146101f8578063cc8a55e214610200578063dc8d30701461021d578063f18f8a501461024057610093565b806339bd92761461009857806347dd980e1461019a578063493b62f6146101c957806351cb44b4146101e6575b600080fd5b6100b5600480360360208110156100ae57600080fd5b503561025d565b604051808481526020018060200180602001838103835285818151815260200191508051906020019080838360005b838110156100fc5781810151838201526020016100e4565b50505050905090810190601f1680156101295780820380516001836020036101000a031916815260200191505b50838103825284518152845160209182019186019080838360005b8381101561015c578181015183820152602001610144565b50505050905090810190601f1680156101895780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b6101b7600480360360208110156101b057600080fd5b5035610341565b60408051918252519081900360200190f35b6100b5600480360360208110156101df57600080fd5b50356103c0565b6101ee610414565b005b6101ee6104ba565b6101ee6104c9565b6101ee6004803603602081101561021657600080fd5b5035610538565b6101b76004803603604081101561023357600080fd5b50803590602001356105b6565b6101b76004803603602081101561025657600080fd5b5035610631565b6000606080306001600160a01b031663f18f8a50856040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156102a657600080fd5b505afa9250505080156102cb57506040513d60208110156102c657600080fd5b505160015b610330576102d7610732565b806102e257506102f1565b6064935091506060905061033a565b3d80801561031b576040519150601f19603f3d011682016040523d82523d6000602084013e610320565b606091505b506065935060609250905061033a565b9250606091508190505b9193909250565b6000306001600160a01b031663f18f8a50836040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561038757600080fd5b505afa9250505080156103ac57506040513d60208110156103a757600080fd5b505160015b6103b8575060666103bb565b90505b919050565b60015460408051630f18f8a560e41b815260048101849052905160009260609283926001600160a01b039092169163f18f8a5091602480820192602092909190829003018186803b1580156102a657600080fd5b6040516104209061071f565b604051809103906000f080156104335760015b610465576040517f4b161dbd67bb8510ef47f0259c83af0b0bef0964f3c346c9b7143977a25dad2e90600090a16104b8565b600180546001600160a01b0383166001600160a01b0319909116811790915560408051918252517f558d76d690d3d1b9d669ff8b9c5af088ba13e7035287169328a6e8abf7d8e6e49181900360200190a1505b565b6104c46002610631565b600255565b60408051630f18f8a560e41b8152600260048201529051309163f18f8a50916024808301926020929190829003018186803b15801561050757600080fd5b505afa15801561051b573d6000803e3d6000fd5b505050506040513d602081101561053157600080fd5b5051600255565b306001600160a01b031663f18f8a50826040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561057c57600080fd5b505afa9250505080156105a157506040513d602081101561059c57600080fd5b505160015b6105af57601b6003556105b3565b6003555b50565b60003063f18f8a50835a03856040518363ffffffff1660e01b81526004018082815260200191505060206040518083038187803b1580156105f657600080fd5b5086fa9350505050801561061c57506040513d602081101561061757600080fd5b505160015b6106285750606761062b565b90505b92915050565b600060088210610688576040805162461bcd60e51b815260206004820152601b60248201527f506172616d2073686f756c64206265206c657373207468616e20380000000000604482015290519081900360640190fd5b816006141561069657600080fd5b81600514156106a457600080fd5b81600414156106fa576040805162461bcd60e51b815260206004820152601c60248201527f4661696c696e672062656361757365205f706172616d20776173203400000000604482015290519081900360640190fd5b81600314156107095760008083fe5b816007141561071457fe5b5060005401600d0190565b6101a8806107dc83390190565b60e01c90565b600060443d1015610742576107d8565b600481823e6308c379a0610756825161072c565b14610760576107d8565b6040513d600319016004823e80513d67ffffffffffffffff816024840111818411171561079057505050506107d8565b828401915081519250808311156107aa57505050506107d8565b503d830160208383010111156107c2575050506107d8565b601f91909101601f191681016020016040529150505b9056fe6080604052600160005534801561001557600080fd5b50610183806100256000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c8063f18f8a5014610030575b600080fd5b61004d6004803603602081101561004657600080fd5b503561005f565b60408051918252519081900360200190f35b6000600882106100b6576040805162461bcd60e51b815260206004820152601b60248201527f506172616d2073686f756c64206265206c657373207468616e20380000000000604482015290519081900360640190fd5b81600614156100c457600080fd5b81600514156100d257600080fd5b8160041415610128576040805162461bcd60e51b815260206004820152601c60248201527f4661696c696e672062656361757365205f706172616d20776173203400000000604482015290519081900360640190fd5b81600314156101375760008083fe5b816007141561014257fe5b5060005401600d019056fea26469706673582212200b42508327b41382811d83c39d4b5c5cd4ec20be5975e6b39280426906fc9f7564736f6c634300060b0033a2646970667358221220f7b1903319640145b4f9e0a7a204c3237f52570716cd68192804211165f5fae764736f6c634300060b0033";

    public static final String FUNC_DEPLOYOTHERCONTRACT = "deployOtherContract";

    public static final String FUNC_DOCATCHALL = "doCatchAll";

    public static final String FUNC_DOINTERNAL1 = "doInternal1";

    public static final String FUNC_DOINTERNAL2 = "doInternal2";

    public static final String FUNC_DOTRYCATCHOTHERCONTRACT = "doTryCatchOtherContract";

    public static final String FUNC_DOTRYCATCHSAMECONTRACT = "doTryCatchSameContract";

    public static final String FUNC_FAILURESITUATIONS = "failureSituations";

    public static final String FUNC_RETAINSOMEGAS = "retainSomeGas";

    public static final String FUNC_UPDATESTATE = "updateState";

    public static final Event CONTRACTDEPLOYMENTFAILED_EVENT = new Event("ContractDeploymentFailed", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event CONTRACTDEPLOYMENTSUCCESS_EVENT = new Event("ContractDeploymentSuccess", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected TryCatch(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TryCatch(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TryCatch(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TryCatch(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ContractDeploymentFailedEventResponse> getContractDeploymentFailedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CONTRACTDEPLOYMENTFAILED_EVENT, transactionReceipt);
        ArrayList<ContractDeploymentFailedEventResponse> responses = new ArrayList<ContractDeploymentFailedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ContractDeploymentFailedEventResponse typedResponse = new ContractDeploymentFailedEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ContractDeploymentFailedEventResponse> contractDeploymentFailedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ContractDeploymentFailedEventResponse>() {
            @Override
            public ContractDeploymentFailedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CONTRACTDEPLOYMENTFAILED_EVENT, log);
                ContractDeploymentFailedEventResponse typedResponse = new ContractDeploymentFailedEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Flowable<ContractDeploymentFailedEventResponse> contractDeploymentFailedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CONTRACTDEPLOYMENTFAILED_EVENT));
        return contractDeploymentFailedEventFlowable(filter);
    }

    public List<ContractDeploymentSuccessEventResponse> getContractDeploymentSuccessEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CONTRACTDEPLOYMENTSUCCESS_EVENT, transactionReceipt);
        ArrayList<ContractDeploymentSuccessEventResponse> responses = new ArrayList<ContractDeploymentSuccessEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ContractDeploymentSuccessEventResponse typedResponse = new ContractDeploymentSuccessEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.deployedAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ContractDeploymentSuccessEventResponse> contractDeploymentSuccessEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ContractDeploymentSuccessEventResponse>() {
            @Override
            public ContractDeploymentSuccessEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CONTRACTDEPLOYMENTSUCCESS_EVENT, log);
                ContractDeploymentSuccessEventResponse typedResponse = new ContractDeploymentSuccessEventResponse();
                typedResponse.log = log;
                typedResponse.deployedAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ContractDeploymentSuccessEventResponse> contractDeploymentSuccessEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CONTRACTDEPLOYMENTSUCCESS_EVENT));
        return contractDeploymentSuccessEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> deployOtherContract() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DEPLOYOTHERCONTRACT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> doCatchAll(BigInteger _param) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DOCATCHALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_param)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> doInternal1() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DOINTERNAL1, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> doInternal2() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DOINTERNAL2, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<BigInteger, String, byte[]>> doTryCatchOtherContract(BigInteger _param) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DOTRYCATCHOTHERCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_param)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicBytes>() {}));
        return new RemoteFunctionCall<Tuple3<BigInteger, String, byte[]>>(function,
                new Callable<Tuple3<BigInteger, String, byte[]>>() {
                    @Override
                    public Tuple3<BigInteger, String, byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, String, byte[]>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (byte[]) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple3<BigInteger, String, byte[]>> doTryCatchSameContract(BigInteger _param) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DOTRYCATCHSAMECONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_param)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicBytes>() {}));
        return new RemoteFunctionCall<Tuple3<BigInteger, String, byte[]>>(function,
                new Callable<Tuple3<BigInteger, String, byte[]>>() {
                    @Override
                    public Tuple3<BigInteger, String, byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, String, byte[]>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (byte[]) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> failureSituations(BigInteger _param) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_FAILURESITUATIONS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_param)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> retainSomeGas(BigInteger _param, BigInteger _gasToKeep) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_RETAINSOMEGAS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_param), 
                new org.web3j.abi.datatypes.generated.Uint256(_gasToKeep)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> updateState(BigInteger _param) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATESTATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_param)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TryCatch load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TryCatch(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TryCatch load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TryCatch(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TryCatch load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TryCatch(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TryCatch load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TryCatch(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TryCatch> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _other) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _other)));
        return deployRemoteCall(TryCatch.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<TryCatch> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _other) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _other)));
        return deployRemoteCall(TryCatch.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TryCatch> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _other) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _other)));
        return deployRemoteCall(TryCatch.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TryCatch> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _other) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _other)));
        return deployRemoteCall(TryCatch.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ContractDeploymentFailedEventResponse extends BaseEventResponse {
    }

    public static class ContractDeploymentSuccessEventResponse extends BaseEventResponse {
        public String deployedAddress;
    }
}
