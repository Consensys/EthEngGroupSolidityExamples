package etheng.sol6x.trycatch.soliditywrappers;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
    public static final String BINARY = "6080604052600180556001600255600160035534801561001e57600080fd5b506040516109bd3803806109bd8339818101604052602081101561004157600080fd5b5051600080546001600160a01b039092166001600160a01b031990921691909117905561094a806100736000396000f3fe608060405234801561001057600080fd5b50600436106100935760003560e01c806351cb44b41161006657806351cb44b414610203578063804778211461020d57806382e6700514610215578063cc8a55e21461021d578063dc8d30701461023a57610093565b8063183d1e0c1461009857806339bd9276146100c757806347dd980e146101c9578063493b62f6146101e6575b600080fd5b6100b5600480360360208110156100ae57600080fd5b503561025d565b60408051918252519081900360200190f35b6100e4600480360360208110156100dd57600080fd5b5035610345565b604051808481526020018060200180602001838103835285818151815260200191508051906020019080838360005b8381101561012b578181015183820152602001610113565b50505050905090810190601f1680156101585780820380516001836020036101000a031916815260200191505b50838103825284518152845160209182019186019080838360005b8381101561018b578181015183820152602001610173565b50505050905090810190601f1680156101b85780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b6100b5600480360360208110156101df57600080fd5b5035610429565b6100e4600480360360208110156101fc57600080fd5b50356104a7565b61020b6104f9565b005b61020b610544565b61020b610553565b61020b6004803603602081101561023357600080fd5b50356105c2565b6100b56004803603604081101561025057600080fd5b5080359060200135610640565b6000600782106102b4576040805162461bcd60e51b815260206004820152601b60248201527f506172616d2073686f756c64206265206c657373207468616e20370000000000604482015290519081900360640190fd5b81600614156102c257600080fd5b81600514156102d057600080fd5b8160041415610326576040805162461bcd60e51b815260206004820152601c60248201527f4661696c696e672062656361757365205f706172616d20776173203400000000604482015290519081900360640190fd5b81600314156103355760008083fe5b6002548201600d0190505b919050565b6000606080306001600160a01b031663183d1e0c856040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561038e57600080fd5b505afa9250505080156103b357506040513d60208110156103ae57600080fd5b505160015b610418576103bf6106ce565b806103ca57506103d9565b60649350915060609050610422565b3d808015610403576040519150601f19603f3d011682016040523d82523d6000602084013e610408565b606091505b5060659350606092509050610422565b9250606091508190505b9193909250565b6000306001600160a01b031663183d1e0c836040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561046f57600080fd5b505afa92505050801561049457506040513d602081101561048f57600080fd5b505160015b6104a057506066610340565b9050610340565b6000805460408051635a742be160e11b815260048101859052905160609283926001600160a01b039091169163b4e857c291602480820192602092909190829003018186803b15801561038e57600080fd5b604051610505906106bb565b604051809103906000f080156105185760015b61052157610542565b600080546001600160a01b0319166001600160a01b03929092169190911790555b565b61054e600261025d565b600155565b6040805163060f478360e21b8152600260048201529051309163183d1e0c916024808301926020929190829003018186803b15801561059157600080fd5b505afa1580156105a5573d6000803e3d6000fd5b505050506040513d60208110156105bb57600080fd5b5051600155565b306001600160a01b031663183d1e0c826040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561060657600080fd5b505afa92505050801561062b57506040513d602081101561062657600080fd5b505160015b61063957601b60035561063d565b6003555b50565b60003063183d1e0c835a03856040518363ffffffff1660e01b81526004018082815260200191505060206040518083038187803b15801561068057600080fd5b5086fa935050505080156106a657506040513d60208110156106a157600080fd5b505160015b6106b2575060676106b5565b90505b92915050565b61019d8061077883390190565b60e01c90565b600060443d10156106de57610774565b600481823e6308c379a06106f282516106c8565b146106fc57610774565b6040513d600319016004823e80513d67ffffffffffffffff816024840111818411171561072c5750505050610774565b828401915081519250808311156107465750505050610774565b503d8301602083830101111561075e57505050610774565b601f91909101601f191681016020016040529150505b9056fe6080604052600160005534801561001557600080fd5b50610178806100256000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c8063b4e857c214610030575b600080fd5b61004d6004803603602081101561004657600080fd5b503561005f565b60408051918252519081900360200190f35b6000600782106100b6576040805162461bcd60e51b815260206004820152601b60248201527f506172616d2073686f756c64206265206c657373207468616e20370000000000604482015290519081900360640190fd5b81600614156100c457600080fd5b81600514156100d257600080fd5b8160041415610128576040805162461bcd60e51b815260206004820152601c60248201527f4661696c696e672062656361757365205f706172616d20776173203400000000604482015290519081900360640190fd5b81600314156101375760008083fe5b50600054016011019056fea2646970667358221220a3ea1776aeb9b16fdfba610c5f17171d6d4619d11aeb75d288cb7a85c9c6f0c464736f6c634300060b0033a2646970667358221220a9b3a3bbbdae6db2ba9aaee92f6f8ee71be69e3778c2f323e27f8cecd647aa3e64736f6c634300060b0033";

    public static final String FUNC_DEPLOYOTHERCONTRACT = "deployOtherContract";

    public static final String FUNC_DOCATCHALL = "doCatchAll";

    public static final String FUNC_DOINTERNAL1 = "doInternal1";

    public static final String FUNC_DOINTERNAL2 = "doInternal2";

    public static final String FUNC_DOTRYCATCHOTHERCONTRACT = "doTryCatchOtherContract";

    public static final String FUNC_DOTRYCATCHSAMECONTRACT = "doTryCatchSameContract";

    public static final String FUNC_LOCAL = "local";

    public static final String FUNC_RETAINSOMEGAS = "retainSomeGas";

    public static final String FUNC_UPDATESTATE = "updateState";

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

    public RemoteFunctionCall<TransactionReceipt> deployOtherContract() {
        final Function function = new Function(
                FUNC_DEPLOYOTHERCONTRACT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> doCatchAll(BigInteger _param) {
        final Function function = new Function(FUNC_DOCATCHALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_param)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> doInternal1() {
        final Function function = new Function(
                FUNC_DOINTERNAL1, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> doInternal2() {
        final Function function = new Function(
                FUNC_DOINTERNAL2, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<BigInteger, String, byte[]>> doTryCatchOtherContract(BigInteger _param) {
        final Function function = new Function(FUNC_DOTRYCATCHOTHERCONTRACT, 
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
        final Function function = new Function(FUNC_DOTRYCATCHSAMECONTRACT, 
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

    public RemoteFunctionCall<BigInteger> local(BigInteger _param) {
        final Function function = new Function(FUNC_LOCAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_param)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> retainSomeGas(BigInteger _param, BigInteger _gasToKeep) {
        final Function function = new Function(FUNC_RETAINSOMEGAS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_param), 
                new org.web3j.abi.datatypes.generated.Uint256(_gasToKeep)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> updateState(BigInteger _param) {
        final Function function = new Function(
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
}
