package com.github.ontio.thread;


import com.alibaba.fastjson.JSONObject;
import com.github.ontio.OntSdk;
import com.github.ontio.account.Account;
import com.github.ontio.common.Helper;
import com.github.ontio.core.transaction.Transaction;
import com.github.ontio.network.exception.ConnectorException;
import com.github.ontio.sdk.exception.SDKException;
import com.github.ontio.smartcontract.neovm.abi.BuildParams;
import com.github.ontio.utils.ConfigParam;
import com.github.ontio.utils.ConstantParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("ScheduleTaskThread")
@Scope("prototype")
public class ScheduleTaskThread extends Thread {


    private static final Logger logger = LoggerFactory.getLogger(ScheduleTaskThread.class);

    @Autowired
    private ConfigParam configParam;

    @Autowired
    private Environment env;

    @Override
    public void run() {
        try {
            logger.info("*************************ScheduleTask, initParam*************************");
            initParam();
        } catch (Exception e) {
            logger.error("*************************ScheduleTask, initParam Exception*************************");
            e.printStackTrace();
        }

        while(true) {
            try {
                //查询剩余时间
                if (getRemainingTime() != 0) {
                    logger.info("*************************ScheduleTask, Sleep*************************");
                    // 等待剩余时间后尝试结束
                    Thread.sleep(getRemainingTime()*1000);
                }
                String status = getRoundGameStatus();
                if (getRemainingTime() == 0 && !status.equals("") && status.equals(ConstantParam.STATUS_ON)) {
                    logger.info("*************************ScheduleTask, endCurrentRound*************************");
                    endCurrentRound();
                }
                String status2 = getRoundGameStatus();
                if (!status2.equals("") && status2.equals(ConstantParam.STATUS_OFF)){
                    logger.info("*************************ScheduleTask, startNewRound*************************");
                    startNewRound();
                }
            } catch (Exception e) {
                logger.error("*************************ScheduleTask, Exception*************************");
                e.printStackTrace();
            }
        }
    }

    private long getCurrentRound() throws SDKException, ConnectorException, IOException {
        List paramList = new ArrayList();
        paramList.add("getCurrentRound".getBytes());
        List temp = new ArrayList();
        paramList.add(temp);
        byte[] args = BuildParams.createCodeParamsScript(paramList);
        Transaction tx = ConstantParam.ONT_SDKSERVICE.vm().makeInvokeCodeTransaction(Helper.reverse(ConstantParam.ONG_PLAYER_CODEHASH), (String)null, args, (String)null, 0L, 0L);

        Object obj = ConstantParam.ONT_SDKSERVICE.getConnect().sendRawTransactionPreExec(tx.toHexString());
        String res = ((JSONObject)obj).getString("Result");
        if (res.equals("")){
            return 0;
        }
        return Long.valueOf(Helper.reverse(res), 16);
    }
    private int getRemainingTime() throws ConnectorException, IOException, SDKException {
        long round = getCurrentRound();
        if(round == 0) {
            return 0;
        }
        List paramList = new ArrayList();
        paramList.add("getCurrentRemainingTime".getBytes());
        List list = new ArrayList();
        paramList.add(list);
        byte[] args = BuildParams.createCodeParamsScript(paramList);
        Transaction tx = ConstantParam.ONT_SDKSERVICE.vm().makeInvokeCodeTransaction(Helper.reverse(ConstantParam.ONG_PLAYER_CODEHASH), (String)null, args, (String)null, 0L, 0L);
        Object obj = ConstantParam.ONT_SDKSERVICE.getConnect().sendRawTransactionPreExec(tx.toHexString());
        return Long.valueOf(Helper.reverse(((JSONObject)obj).getString("Result")), 16).intValue();
    }

    private void endCurrentRound() throws Exception {
        List paramList = new ArrayList();
        paramList.add("endCurrentRound".getBytes());
        List temp = new ArrayList();
        paramList.add(temp);
        byte[] args = BuildParams.createCodeParamsScript(paramList);
        Transaction tx = ConstantParam.ONT_SDKSERVICE.vm().makeInvokeCodeTransaction(Helper.reverse(ConstantParam.ONG_PLAYER_CODEHASH),
                (String)null, args, ConstantParam.OPERATION_ADMIN.getAddressU160().toBase58(), (long)ConstantParam.GAS_LIMIT, (long)ConstantParam.GAS_PRICE);
        ConstantParam.ONT_SDKSERVICE.signTx(tx, new Account[][]{{ConstantParam.OPERATION_ADMIN}});
        ConstantParam.ONT_SDKSERVICE.getConnect().sendRawTransactionSync(tx.toHexString());
    }

    private String getRoundGameStatus() throws ConnectorException, IOException, SDKException {
        long round = getCurrentRound();
        if (round==0) {
            return "";
        }
        List paramList = new ArrayList();
        paramList.add("getRoundGameStatus".getBytes());
        List list = new ArrayList();
        list.add(round);
        paramList.add(list);
        byte[] args = BuildParams.createCodeParamsScript(paramList);
        Transaction tx = ConstantParam.ONT_SDKSERVICE.vm().makeInvokeCodeTransaction(Helper.reverse(ConstantParam.ONG_PLAYER_CODEHASH), (String)null, args, (String)null, 0L, 0L);
        Object obj = ConstantParam.ONT_SDKSERVICE.getConnect().sendRawTransactionPreExec(tx.toHexString());
        if (((JSONObject)obj).getString("Result").equals("")){
            return "";
        }
        return new String(Helper.hexToBytes(((JSONObject)obj).getString("Result")));
    }

    private void startNewRound() throws Exception {
        List paramList = new ArrayList();
        paramList.add("startNewRound".getBytes());
        List temp = new ArrayList();
        paramList.add(temp);
        byte[] args = BuildParams.createCodeParamsScript(paramList);
        Transaction tx = ConstantParam.ONT_SDKSERVICE.vm().makeInvokeCodeTransaction(Helper.reverse(ConstantParam.ONG_PLAYER_CODEHASH),
                (String)null, args, ConstantParam.OPERATION_ADMIN.getAddressU160().toBase58(), (long)ConstantParam.GAS_LIMIT, (long)ConstantParam.GAS_PRICE);
        ConstantParam.ONT_SDKSERVICE.signTx(tx, new Account[][]{{ConstantParam.OPERATION_ADMIN}});
        ConstantParam.ONT_SDKSERVICE.getConnect().sendRawTransactionSync(tx.toHexString());
    }

    private void initParam() throws Exception {
        if(ConstantParam.ONT_SDKSERVICE == null) {
            for (int i = 0; i < configParam.NODE_AMOUNT; i++) {
                ConstantParam.MAINCHAIN_RPCLIST.add(env.getProperty("mainchain.rpc.url_" + i));
            }
            ConstantParam.MAINCHAIN_RPCURL = configParam.MAINCHAIN_RPC_URL;
            OntSdk sdkService = OntSdk.getInstance();
            sdkService.setRpc(configParam.MAINCHAIN_RPC_URL);
            sdkService.openWalletFile(configParam.walletFile);
            ConstantParam.OPERATION_ADMIN = sdkService.getWalletMgr().getAccount(configParam.operationAdminAddress,configParam.operationAdminPassword);
            ConstantParam.ONT_SDKSERVICE = sdkService;
            ConstantParam.ONG_PLAYER_CODEHASH = configParam.ONG_PLAYER_CODEHASH;
            ConstantParam.ONT_PLAYER_CODEHASH = configParam.ONT_PLAYER_CODEHASH;
            ConstantParam.ONT_BET_CODEHASH = configParam.ONT_BET_CODEHASH;

            List<String> list = new ArrayList<>();
            list.add(configParam.ONG_PLAYER_CODEHASH);
            list.add(configParam.ONT_PLAYER_CODEHASH);
            list.add(configParam.ONT_BET_CODEHASH);
            ConstantParam.CODEHASH_LIST = list;
            ConstantParam.GAS_LIMIT = configParam.gasLimit;
            ConstantParam.GAS_PRICE = configParam.gasPrice;
        }
    }

}
