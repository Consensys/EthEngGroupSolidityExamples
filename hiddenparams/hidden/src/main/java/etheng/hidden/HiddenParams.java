/*
 * Copyright 2021 ConsenSys Software.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package etheng.hidden;

import etheng.hidden.soliditywrappers.Dest;
import etheng.hidden.soliditywrappers.Source;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class HiddenParams {
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

  Dest destContract;
  Source sourceContract;

  public static void main(String[] args) throws Exception {
    (new HiddenParams()).doStuff();
  }

  public void doStuff() throws Exception {

    String privateKey0 = new KeyPairGen().generateKeyPairGetPrivateKey();
    this.credentials = Credentials.create(privateKey0);

    this.web3j = Web3j.build(new HttpService(URI), POLLING_INTERVAL, new ScheduledThreadPoolExecutor(5));
    this.tm = new RawTransactionManager(this.web3j, this.credentials, BLOCKCHAIN_ID.longValue(), RETRY, POLLING_INTERVAL);

    LOG.info("Deploying contracts");
    this.destContract = Dest.deploy(this.web3j, this.tm, this.freeGasProvider, EXPECTED1, EXPECTED2, EXPECTED3).send();
    String destContractAddress = this.destContract.getContractAddress();
    LOG.info(" destContract deployed to address: {}", destContractAddress);

    this.sourceContract = Source.deploy(this.web3j, this.tm, this.freeGasProvider,
            destContractAddress, EXPECTED1, EXPECTED2, EXPECTED3).send();
    LOG.info(" sourceContract deployed to address: {}", this.sourceContract.getContractAddress());


    LOG.info("callFuncNoParams Hidden Params");
    TransactionReceipt receipt1;
    try {
      receipt1 = this.sourceContract.callFuncNoParams().send();
    } catch (TransactionException ex) {
      receipt1 = ex.getTransactionReceipt().orElseThrow(Exception::new);
    }
    LOG.info(" StatusOK: {}", receipt1.isStatusOK());
    LOG.info(" Gas used: {}", receipt1.getGasUsed());
    if (!receipt1.isStatusOK()) {
      LOG.info("  Revert Reason: {}", RevertReason.decodeRevertReason(receipt1.getRevertReason()));
    }
    List<Source.DumpEventResponse> dumpEventResponses = this.sourceContract.getDumpEvents(receipt1);
    for (Source.DumpEventResponse event: dumpEventResponses) {
        LOG.info("   DumpEvent: {}", new BigInteger(1, event._b).toString(16));
    }

    LOG.info("callFuncNoParams Explicit Params");
    try {
      receipt1 = this.sourceContract.callFuncNoParamsExplicit().send();
    } catch (TransactionException ex) {
      receipt1 = ex.getTransactionReceipt().orElseThrow(Exception::new);
    }
    LOG.info(" StatusOK: {}", receipt1.isStatusOK());
    LOG.info(" Gas used: {}", receipt1.getGasUsed());
    if (!receipt1.isStatusOK()) {
      LOG.info("  Revert Reason: {}", RevertReason.decodeRevertReason(receipt1.getRevertReason()));
    }
    dumpEventResponses = this.sourceContract.getDumpEvents(receipt1);
    for (Source.DumpEventResponse event: dumpEventResponses) {
      LOG.info("   DumpEvent: {}", new BigInteger(1, event._b).toString(16));
    }



    LOG.info("callFuncOneParam Hidden Params");
    try {
      receipt1 = this.sourceContract.callFuncOneParam().send();
    } catch (TransactionException ex) {
      receipt1 = ex.getTransactionReceipt().orElseThrow(Exception::new);
    }
    LOG.info(" StatusOK: {}", receipt1.isStatusOK());
    LOG.info(" Gas used: {}", receipt1.getGasUsed());
    if (!receipt1.isStatusOK()) {
      LOG.info("  Revert Reason: {}", RevertReason.decodeRevertReason(receipt1.getRevertReason()));
    }
    for (Source.DumpEventResponse event: dumpEventResponses) {
      LOG.info("   DumpEvent: {}", new BigInteger(1, event._b).toString(16));
    }

    LOG.info("callFuncOneParam Explicit Params");
    try {
      receipt1 = this.sourceContract.callFuncOneParamExplicit().send();
    } catch (TransactionException ex) {
      receipt1 = ex.getTransactionReceipt().orElseThrow(Exception::new);
    }
    LOG.info(" StatusOK: {}", receipt1.isStatusOK());
    LOG.info(" Gas used: {}", receipt1.getGasUsed());
    if (!receipt1.isStatusOK()) {
      LOG.info("  Revert Reason: {}", RevertReason.decodeRevertReason(receipt1.getRevertReason()));
    }
    for (Source.DumpEventResponse event: dumpEventResponses) {
      LOG.info("   DumpEvent: {}", new BigInteger(1, event._b).toString(16));
    }


    LOG.info("callFuncTwoParams Hidden Params");
    try {
      receipt1 = this.sourceContract.callFuncTwoParams().send();
    } catch (TransactionException ex) {
      receipt1 = ex.getTransactionReceipt().orElseThrow(Exception::new);
    }
    LOG.info(" StatusOK: {}", receipt1.isStatusOK());
    LOG.info(" Gas used: {}", receipt1.getGasUsed());
    if (!receipt1.isStatusOK()) {
      LOG.info("  Revert Reason: {}", RevertReason.decodeRevertReason(receipt1.getRevertReason()));
    }
    for (Source.DumpEventResponse event: dumpEventResponses) {
      LOG.info("   DumpEvent: {}", new BigInteger(1, event._b).toString(16));
    }


    LOG.info("callFuncTwoParams Explicit Params");
    try {
      receipt1 = this.sourceContract.callFuncTwoParamsExplicit().send();
    } catch (TransactionException ex) {
      receipt1 = ex.getTransactionReceipt().orElseThrow(Exception::new);
    }
    LOG.info(" StatusOK: {}", receipt1.isStatusOK());
    LOG.info(" Gas used: {}", receipt1.getGasUsed());
    if (!receipt1.isStatusOK()) {
      LOG.info("  Revert Reason: {}", RevertReason.decodeRevertReason(receipt1.getRevertReason()));
    }
    for (Source.DumpEventResponse event: dumpEventResponses) {
      LOG.info("   DumpEvent: {}", new BigInteger(1, event._b).toString(16));
    }

  }
}
