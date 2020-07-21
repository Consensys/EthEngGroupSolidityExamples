package etheng.sol6x.trycatch;

import etheng.sol6x.common.KeyPairGen;
import etheng.sol6x.trycatch.soliditywrappers.OtherContract;
import etheng.sol6x.trycatch.soliditywrappers.TryCatch;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class SomeTryCatch {
  private static final Logger LOG = LogManager.getLogger(SomeTryCatch.class);

  private static final BigInteger BLOCKCHAIN_ID = BigInteger.valueOf(30);
  private static final String IP_PORT = "127.0.0.1:8300";
  private static final String URI = "http://" + IP_PORT + "/";


  // Have the polling interval equal to the block time.
  private static final int POLLING_INTERVAL = 2000;
  // Retry requests to Ethereum Clients up to five times.
  private static final int RETRY = 5;

  private Web3j web3j;
  private TransactionManager tm;
  private Credentials credentials;
  // A gas provider which indicates no gas is charged for transactions.
  private ContractGasProvider freeGasProvider =  new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT);

  OtherContract otherContract;
  TryCatch tryCatchContract;

  public static void main(String[] args) throws Exception {
    (new SomeTryCatch()).doStuff();
  }

  public void doStuff() throws Exception {

    String privateKey0 = new KeyPairGen().generateKeyPairGetPrivateKey();
    this.credentials = Credentials.create(privateKey0);

    this.web3j = Web3j.build(new HttpService(URI), POLLING_INTERVAL, new ScheduledThreadPoolExecutor(5));
    this.tm = new RawTransactionManager(this.web3j, this.credentials, BLOCKCHAIN_ID.longValue(), RETRY, POLLING_INTERVAL);

    deployContracts();
    showDifferenceCallInternalExternal();

    callTryCatch(0);
    callTryCatch(1);
    callTryCatch(2);
  }

  public void deployContracts() throws Exception {
    LOG.info("Deploying contracts");
    this.otherContract = OtherContract.deploy(this.web3j, this.tm, this.freeGasProvider).send();
    String otherContractAddress = this.otherContract.getContractAddress();
    LOG.info(" OtherContract deployed to address: {}", otherContractAddress);

    this.tryCatchContract = TryCatch.deploy(this.web3j, this.tm, this.freeGasProvider, otherContractAddress).send();
    LOG.info(" TryCatch contract deployed to address: {}", this.tryCatchContract.getContractAddress());
  }


  private void showDifferenceCallInternalExternal() throws Exception {
    LOG.info("Call Do Internal1");
    TransactionReceipt receipt1;
    try {
      receipt1 = this.tryCatchContract.doInternal1().send();
    } catch (TransactionException ex) {
      receipt1 = ex.getTransactionReceipt().orElseThrow(Exception::new);
    }
    LOG.info(" StatusOK: {}", receipt1.isStatusOK());
    LOG.info(" Gas used: {}", receipt1.getGasUsed());
    if (!receipt1.isStatusOK()) {
      LOG.info("  Revert Reason: {}", receipt1.getRevertReason());
    }

    LOG.info("Call Do Internal2");
    TransactionReceipt receipt2;
    try {
      receipt2 = this.tryCatchContract.doInternal2().send();
    } catch (TransactionException ex) {
      receipt2 = ex.getTransactionReceipt().orElseThrow(Exception::new);
    }
    LOG.info(" StatusOK: {}", receipt2.isStatusOK());
    LOG.info(" Gas used: {}", receipt2.getGasUsed());
    if (!receipt2.isStatusOK()) {
      LOG.info("  Revert Reason: {}", receipt2.getRevertReason());
    }
  }


  public void callTryCatch(int scenario) throws Exception {
    LOG.info("Call Try Catch: Scenario: {}", scenario);
    LOG.info(" Scenario - no reverts to catch");
    callTryCatch(scenario, BigInteger.TWO);
    LOG.info(" Scenario - divide by zero");
    callTryCatch(scenario, BigInteger.valueOf(3));
    LOG.info(" Scenario - revert with reason");
    callTryCatch(scenario, BigInteger.valueOf(4));
    LOG.info(" Scenario - revert with no reason");
    callTryCatch(scenario, BigInteger.valueOf(5));
    LOG.info(" Scenario - require with no reason");
    callTryCatch(scenario, BigInteger.valueOf(6));
    LOG.info(" Scenario - assert(false)");
    callTryCatch(scenario, BigInteger.valueOf(7));
    LOG.info(" Scenario - require with reason");
    callTryCatch(scenario, BigInteger.valueOf(8));
  }

  private void callTryCatch(int scenario, BigInteger paramValue) throws Exception {
    Tuple3<BigInteger, String, byte[]> result = null;
    BigInteger result1 = null;
    switch (scenario) {
      case 0:
        result = this.tryCatchContract.doTryCatchSameContract(paramValue).send();
        break;
      case 1:
        result = this.tryCatchContract.doTryCatchOtherContract(paramValue).send();
        break;
      case 2:
        result1 = this.tryCatchContract.doCatchAll(paramValue).send();
        break;
    }

    switch (scenario) {
      case 0:
      case 1:
        BigInteger theResult = result.component1();
        String revertReason = result.component2();
        byte[] lowLevelData = result.component3();

        LOG.info("  Result: {}", theResult);
        LOG.info("  Caught Revert Reason: {}", revertReason);
        if (lowLevelData.length == 0) {
          LOG.info("  Caught LowLevelData: Zero length");
        }
        else {
          LOG.info("  Caught LowLevelData / Error: 0x{}", (new BigInteger(1, lowLevelData)).toString(16));
        }
        break;
      case 2:
        LOG.info("  Result: {}", result1);
        break;
    }


  }



}
