package com.github.ontio.thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.ontio.common.Address;
import com.github.ontio.common.Helper;
import com.github.ontio.dao.BuyRecordInfoMapper;
import com.github.ontio.model.BuyRecordInfo;
import com.github.ontio.model.WinnerInfo;
import com.github.ontio.model.WithdrawRecordInfo;
import com.github.ontio.utils.ConstantParam;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.Future;


@Component
public class TxnHandlerThread {

    private static final Logger logger = LoggerFactory.getLogger(TxnHandlerThread.class);

    @Autowired
    private BuyRecordInfoMapper buyRecordInfoMapper;

    @Async
    public Future<String> asyncHandleTxn(SqlSession session, Object stateObj, String txHash, String contractAddress) throws Exception {

        String threadName = Thread.currentThread().getName();
        logger.info("{} run--------txHash:{}", threadName, txHash);
        int num3 = buyRecordInfoMapper.selectBuyRecordByTxHash(txHash);
        if(num3 ==0) {
            handleFunc(session, stateObj, txHash);
        }
        logger.info("{} end-------txHash:{}", threadName, txHash);
        return new AsyncResult<String>("success");

    }

    @Transactional
    public void handleFunc(SqlSession session, Object obj, String txHash){
        String funcName = new String(com.github.ontio.common.Helper.hexToBytes(((JSONArray)obj).getString(0)));
        if (funcName.equals("buyKey")) {
            System.out.println(JSON.toJSONString(obj));
            String buyer = Address.parse(((JSONArray)obj).getString(1)).toBase58();
            Double priceL = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(2)), 16).doubleValue()/ConstantParam.ONG_DECIMAL;
            int round = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(3)), 16).intValue();
            long txTime = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(4)), 16);
            BuyRecordInfo buyRecordInfo = new BuyRecordInfo();
            buyRecordInfo.setTxTime((int)txTime);
            buyRecordInfo.setBuyer(buyer);
            buyRecordInfo.setTxHash(txHash);
            buyRecordInfo.setPrice(priceL);
            buyRecordInfo.setRound(round);
            session.insert("com.github.ontio.dao.BuyRecordInfoMapper.insertBuyRecordInfo", buyRecordInfo);

        } else if (funcName.equals("withdrawDividend")) {
            String address = Address.parse(((JSONArray)obj).getString(1)).toBase58();
            double dividend = Long.valueOf(Helper.reverse(((JSONArray)obj).getString(2)),16).doubleValue();
            BigDecimal dividendBalance = BigDecimal.valueOf(dividend/ConstantParam.ONG_DECIMAL);
            double inviteDividend = Long.valueOf(Helper.reverse(((JSONArray)obj).getString(3)),16).doubleValue();
            BigDecimal inviteDividendBalance = BigDecimal.valueOf(inviteDividend/ConstantParam.ONG_DECIMAL);
            int round = Long.valueOf(Helper.reverse(((JSONArray)obj).getString(4)),16).intValue();
            WithdrawRecordInfo withdrawRecordInfo = new WithdrawRecordInfo();
            withdrawRecordInfo.setAddress(address);
            withdrawRecordInfo.setDividend(dividendBalance);
            withdrawRecordInfo.setInviteDividend(inviteDividendBalance);
            withdrawRecordInfo.setRound(round);
            withdrawRecordInfo.setTxHash(txHash);
            session.insert("com.github.ontio.dao.WithdrawRecordInfoMapper.insertWithdrawRecordInfo", withdrawRecordInfo);
        } else if(funcName.equals("endCurrentRound")) {
            String lastBuyer = Address.parse(((JSONArray)obj).getString(1)).toBase58();
            double lastBuyerDividend = Long.valueOf(Helper.reverse(((JSONArray)obj).getString(2)),16).doubleValue();
            String holdKeyMost = "";
            if(((JSONArray)obj).getString(3) != null && !((JSONArray)obj).getString(3).equals("")){
                holdKeyMost = Address.parse(((JSONArray)obj).getString(3)).toBase58();
            }
            double holdKeyMostDividend = Long.valueOf(Helper.reverse(((JSONArray)obj).getString(4)),16).doubleValue();
            String mostActive = "";
            if(((JSONArray)obj).getString(5) !=null && !((JSONArray)obj).getString(5).equals("")){
                mostActive = Address.parse(((JSONArray)obj).getString(5)).toBase58();
            }
            double mostActiveDividend = Long.valueOf(Helper.reverse(((JSONArray)obj).getString(6)),16).doubleValue();
            int round = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(7)),16).intValue();
            WinnerInfo winnerInfo = new WinnerInfo();
            winnerInfo.setRound(round);
            winnerInfo.setHoldKeyMost(holdKeyMost);
            winnerInfo.setHoldKeyMostDividend(BigDecimal.valueOf(holdKeyMostDividend/ConstantParam.ONG_DECIMAL));
            winnerInfo.setLastBuyer(lastBuyer);
            winnerInfo.setLastBuyerDividend(BigDecimal.valueOf(lastBuyerDividend/ConstantParam.ONG_DECIMAL));
            winnerInfo.setMostActive(mostActive);
            winnerInfo.setMostActiveDividend(BigDecimal.valueOf(mostActiveDividend/ConstantParam.ONG_DECIMAL));
            session.insert("com.github.ontio.dao.WinnerInfoMapper.insertWinnerInfo", winnerInfo);
        }
    }
}
