package com.github.ontio.asyncService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.ontio.common.Address;
import com.github.ontio.dao.BuyRecordInfoMapper;
import com.github.ontio.dao.WinnerInfoMapper;
import com.github.ontio.dao.WithdrawRecordInfoMapper;
import com.github.ontio.model.BuyRecordInfo;
import com.github.ontio.model.WinnerInfo;
import com.github.ontio.model.WithdrawRecordInfo;
import com.github.ontio.thread.TxnHandlerThread;
import com.github.ontio.utils.ConstantParam;
import com.github.ontio.utils.Helper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@Service
public class BlkSyncService {
    private static final Logger logger = LoggerFactory.getLogger(BlkSyncService.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private BuyRecordInfoMapper buyRecordInfoMapper;


    @Autowired
    private TxnHandlerThread txnHandlerThread;

    /**
     * handle the block and the transactions in this block
     *
     * @param
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void handleEventList(List<Object> eventList) throws Exception {

        //设置一个模式为BATCH，自动提交为false的session，最后统一提交，需防止内存溢出
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);


        logger.info("{} run-------", Helper.currentMethod());
        for(Object event: eventList){
            String txHash = ((JSONObject)event).getString("TxHash");
//            判断是否已经存在
            int num3 = buyRecordInfoMapper.selectBuyRecordByTxHash(txHash);
            if(num3 !=0) {
                continue;
            }
            for(Object notify : (JSONArray)((JSONObject) event).get("Notify")){
                if(((JSONObject)notify).getString("ContractAddress").equals(ConstantParam.ONT_PLAYER_CODEHASH)){
                    if(((JSONArray)((JSONObject)notify).get("States")).size() > 2){
                        Future future = txnHandlerThread.asyncHandleTxn(session,  ((JSONObject)notify).get("States"),txHash);
                        future.get();
                    }
                }
            }
        }
        session.commit();
    }
}
