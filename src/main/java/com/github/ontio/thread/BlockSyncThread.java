package com.github.ontio.thread;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.ontio.OntSdk;
import com.github.ontio.asyncService.BlkSyncService;
import com.github.ontio.dao.BlkHeightMapper;
import com.github.ontio.network.exception.ConnectorException;
import com.github.ontio.utils.ConfigParam;
import com.github.ontio.utils.ConstantParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("BlockSyncThread")
@Scope("prototype")
public class BlockSyncThread extends Thread{
    private static final Logger logger = LoggerFactory.getLogger(BlockSyncThread.class);

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private ConfigParam configParam;

    @Autowired
    private Environment env;

    @Autowired
    private BlkHeightMapper blkHeightMapper;

    @Autowired
    private BlkSyncService blkSyncService;


    @Override
    public void run() {
        logger.info("========{}.run=======", CLASS_NAME);

        try{
            //初始化node列表
            initNodeRpcList();
            int oneBlockTryTime = 1;
            while (true) {

                int remoteBlockHieght = getRemoteBlockHeight();
                logger.info("######remote blockheight:{}", remoteBlockHieght);

                int dbBlockHeight = blkHeightMapper.selectDBHeight();
                logger.info("######db blockheight:{}", dbBlockHeight);
                dbBlockHeight = dbBlockHeight +1;
                //wait for generating block
                if (dbBlockHeight >= remoteBlockHieght) {
                    logger.info("+++++++++wait for block+++++++++");
                    try {
                        Thread.sleep(configParam.BLOCK_INTERVAL);
                    } catch (InterruptedException e) {
                        logger.error("error...", e);
                        e.printStackTrace();
                    }
                    oneBlockTryTime++;
                    if (oneBlockTryTime >= configParam.NODE_WAITFORBLOCKTIME_MAX) {
                        switchNode();
                        oneBlockTryTime = 1;
                    }
                    continue;
                }

                oneBlockTryTime = 1;

                Object event = ConstantParam.ONT_SDKSERVICE.getConnect().getSmartCodeEvent(dbBlockHeight);
                if (event != null) {
                    List eventList = new ArrayList();
                    logger.info("event: "+ event);
                    for(Object obj : (JSONArray)event){
                        if ((Integer) ((JSONObject)obj).get("State") == 1  && ((JSONObject)obj).get("Notify") != null){
                            JSONArray notifyArray = (JSONArray) ((JSONObject)obj).get("Notify");
                            for(Object notify : notifyArray){
                                if(((JSONObject)notify).getString("ContractAddress").equals(ConstantParam.ONT_PLAYER_CODEHASH)) {
                                    if(((JSONArray)((JSONObject)notify).get("States")).size() !=0){
                                        eventList.add(obj);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(eventList.size() != 0) {
                        blkSyncService.handleEventList(eventList);
                    }
                }

                blkHeightMapper.update(dbBlockHeight);

            }
        }catch (Exception e) {
            logger.error("Exception occured，Synchronization thread can't work,error ...", e);
        }

    }


    private void initNodeRpcList() {
        for (int i = 0; i < configParam.NODE_AMOUNT; i++) {
            ConstantParam.MAINCHAIN_RPCLIST.add(env.getProperty("mainchain.rpc.url_" + i));
        }
        ConstantParam.MAINCHAIN_RPCURL = configParam.MAINCHAIN_RPC_URL;
        OntSdk sdkService = OntSdk.getInstance();
        sdkService.setRpc(configParam.MAINCHAIN_RPC_URL);
        ConstantParam.ONT_SDKSERVICE = sdkService;
        ConstantParam.ONT_PLAYER_CODEHASH = configParam.ONT_PLAYER_CODEHASH;
    }

    private int getRemoteBlockHeight() throws Exception {

        int remoteHeight = 0;
        int tryTime = 1;
        while (true) {
            try {
                remoteHeight = ConstantParam.ONT_SDKSERVICE.getConnect().getBlockHeight();
                break;
            } catch (ConnectorException ex) {
                logger.error("getBlockHeight error, try again...restful:{},error:", ConstantParam.MAINCHAIN_RPCURL);
                if (tryTime % configParam.NODE_INTERRUPTTIME_MAX == 0) {
                    switchNode();
                    tryTime++;
                    continue;
                } else {
                    tryTime++;
                    Thread.sleep(3000);
                    continue;
                }
            } catch (IOException e) {
                logger.error("get blockheight thread can't work,error {} ", e);
                throw new Exception(e);
            }
        }

        return remoteHeight;
    }

    private void switchNode() {
        ConstantParam.MAINNODE_INDEX++;
        if (ConstantParam.MAINNODE_INDEX >= configParam.NODE_AMOUNT) {
            ConstantParam.MAINNODE_INDEX = 0;
        }
        ConstantParam.MAINCHAIN_RPCURL = ConstantParam.MAINCHAIN_RPCLIST.get(ConstantParam.MAINNODE_INDEX);
        logger.warn("####switch node rpc to {}####", ConstantParam.MAINCHAIN_RPCURL);

        ConstantParam.ONT_SDKSERVICE.setRpc(ConstantParam.MAINCHAIN_RPCURL);
    }
}
