package etheng.hidden;

import etheng.hidden.soliditywrappers.Dest;
import etheng.hidden.soliditywrappers.HiddenParams2;
import etheng.hidden.soliditywrappers.Source;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class HiddenTest2 {

    private static final Logger LOG = LogManager.getLogger(HiddenParams.class);

    private static final BigInteger BLOCKCHAIN_ID = BigInteger.valueOf(31);
    private static final String IP_PORT = "127.0.0.1:8310";
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



    public static final BigInteger EXPECTED1 = BigInteger.valueOf(41);
    public static final BigInteger EXPECTED2 = BigInteger.valueOf(47);
    public static final BigInteger EXPECTED3 = BigInteger.valueOf(53);

    HiddenParams2 testContract;

    public static void main(String[] args) throws Exception {
        (new HiddenTest2()).doStuff();
    }

    public void doStuff() throws Exception {

        String privateKey0 = new KeyPairGen().generateKeyPairGetPrivateKey();
        this.credentials = Credentials.create(privateKey0);

        this.web3j = Web3j.build(new HttpService(URI), POLLING_INTERVAL, new ScheduledThreadPoolExecutor(5));
        this.tm = new RawTransactionManager(this.web3j, this.credentials, BLOCKCHAIN_ID.longValue(), RETRY, POLLING_INTERVAL);

        LOG.info("Deploying contracts");
        this.testContract = HiddenParams2.deploy(this.web3j, this.tm, this.freeGasProvider).send();
        String anAddress = this.testContract.getContractAddress();

        Random notVeryRandom = new Random();
        byte[] bcId = new byte[32];
        notVeryRandom.nextBytes(bcId);
        BigInteger val = new BigInteger(1, bcId);

        TransactionReceipt receipt1;
        try {
            receipt1 = this.testContract.test(val, anAddress).send();
        } catch (TransactionException ex) {
            receipt1 = ex.getTransactionReceipt().orElseThrow(Exception::new);
        }
        LOG.info(" StatusOK: {}", receipt1.isStatusOK());
        LOG.info(" Gas used: {}", receipt1.getGasUsed());
        if (!receipt1.isStatusOK()) {
            LOG.info("  Revert Reason: {}", RevertReason.decodeRevertReason(receipt1.getRevertReason()));
        }

        Tuple2<BigInteger, String> result = this.testContract.getResult().send();
        LOG.info("Encoded: {}, {}", val.toString(16), anAddress);
        LOG.info("Decoded: {}, {}", result.component1().toString(16), result.component2());

    }


}
