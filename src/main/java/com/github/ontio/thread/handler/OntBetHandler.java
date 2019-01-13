package com.github.ontio.thread.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.ontio.asyncService.BlkSyncService;
import com.github.ontio.common.Address;
import com.github.ontio.dao.ontbet.BankerInfoMapper;
import com.github.ontio.dao.ontbet.BetsInfoMapper;
import com.github.ontio.model.ontbet.BankerInfo;
import com.github.ontio.model.ontbet.BetInfo;
import com.github.ontio.model.ontbet.BetInfoWithId;
import com.github.ontio.utils.ConstantParam;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Map;


@Component(value = "OntBetHandler")
public class OntBetHandler {

    private static final Logger logger = LoggerFactory.getLogger(BlkSyncService.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private BetsInfoMapper betsInfoMapper;

    @Autowired
    private BankerInfoMapper bankerInfoMapper;

    @Transactional
    public void handleFunc(SqlSession session, Object obj, String txHash, int blockTime){
        String funcName = new String(com.github.ontio.common.Helper.hexToBytes(((JSONArray)obj).getString(0)));
        if (funcName.equals("bet")) {
            System.out.println(JSON.toJSONString(obj));
            String bettor = Address.parse(((JSONArray)obj).getString(2)).toBase58();
            int rollUnder = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(3)), 16).intValue();
            double bet = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(5)),16).doubleValue();
            BigDecimal betBig = BigDecimal.valueOf(bet/ ConstantParam.ONG_DECIMAL);
            int roll = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(4)),16).intValue();
            Long payout = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(6)),16);
            BigDecimal payoutWin = BigDecimal.valueOf(payout.doubleValue()/ConstantParam.ONG_DECIMAL);

            BetInfo betInfo = new BetInfo();
            betInfo.setBlockTime(blockTime);
            betInfo.setTxHash(txHash);
            betInfo.setBettor(bettor);
            betInfo.setRollUnder(rollUnder);
            betInfo.setBet(betBig);
            betInfo.setPayout(payoutWin);
            betInfo.setRoll(roll);
            betsInfoMapper.insertBetInfo(betInfo);
            if(payoutWin.compareTo(BigDecimal.ZERO) != 0) {
                int total = betsInfoMapper.selectHugeWinTotalNum();
                if (total < ConstantParam.HUGE_WIN_SIZE){
                    betsInfoMapper.insertHugeWin(betInfo);
                } else {
                    Map betInfoMinMap = betsInfoMapper.selectHugeWinMinBetInfo();
                    BigDecimal minPayout = (BigDecimal) betInfoMinMap.get("payout");
                    if(betInfo.payout.compareTo(minPayout) > 0){
                        int id = (int)betInfoMinMap.get("id");
                        BetInfoWithId betInfoWithId = new BetInfoWithId();
                        betInfoWithId.id = id;
                        betInfoWithId.bettor = betInfo.bettor;
                        betInfoWithId.bet = betInfo.bet;
                        betInfoWithId.rollUnder = betInfo.rollUnder;
                        betInfoWithId.payout = betInfo.payout;
                        betInfoWithId.roll = betInfo.roll;
                        betInfoWithId.setBlockTime(blockTime);
                        betInfoWithId.setTxHash(txHash);
                        betsInfoMapper.updateHugeWinMinBetInfoById(betInfoWithId);
                    }
                }
            }
        } else if (funcName.equals("bankerInvest")) {
            String bettor = Address.parse(((JSONArray)obj).getString(2)).toBase58();
            double bet = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(3)),16).doubleValue();
            BigDecimal ongAmount = BigDecimal.valueOf(bet/ConstantParam.ONG_DECIMAL);
            BankerInfo bankerInfo = new BankerInfo();
            bankerInfo.setBlockTime(blockTime);
            bankerInfo.setTxHash(txHash);
            bankerInfo.setBanker(bettor);
            bankerInfo.setOngAmount(ongAmount);
            bankerInfoMapper.insertBankerInvest(bankerInfo);
        } else if (funcName.equals("bankerWithdrawDividend")) {
            String bettor = Address.parse(((JSONArray)obj).getString(2)).toBase58();
            double ongAmount = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(3)),16).doubleValue();
            BigDecimal ongAmt = BigDecimal.valueOf(ongAmount/ConstantParam.ONG_DECIMAL);
            BankerInfo bankerInfo = new BankerInfo();
            bankerInfo.setFuncName("bankerWithdrawDividend");
            bankerInfo.setBlockTime(blockTime);
            bankerInfo.setTxHash(txHash);
            bankerInfo.setBanker(bettor);
            bankerInfo.setOngAmount(ongAmt);
            bankerInfoMapper.insertBankerWithdraw(bankerInfo);
        } else if (funcName.equals("bankerWithdrawEarning")) {
            String bettor = Address.parse(((JSONArray)obj).getString(2)).toBase58();
            double ongAmount = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(3)),16).doubleValue();
            BigDecimal ongAmt = BigDecimal.valueOf(ongAmount/ConstantParam.ONG_DECIMAL);
            BankerInfo bankerInfo = new BankerInfo();
            bankerInfo.setFuncName("bankerWithdrawEarning");
            bankerInfo.setBlockTime(blockTime);
            bankerInfo.setTxHash(txHash);
            bankerInfo.setBanker(bettor);
            bankerInfo.setOngAmount(ongAmt);
            bankerInfoMapper.insertBankerWithdraw(bankerInfo);
        } else if (funcName.equals("bankerExit")) {
            String bettor = Address.parse(((JSONArray)obj).getString(2)).toBase58();
            double ongAmount = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(3)),16).doubleValue();
            BigDecimal ongAmt = BigDecimal.valueOf(ongAmount/ConstantParam.ONG_DECIMAL);
            BankerInfo bankerInfo = new BankerInfo();
            bankerInfo.setFuncName("bankerExit");
            bankerInfo.setBlockTime(blockTime);
            bankerInfo.setTxHash(txHash);
            bankerInfo.setBanker(bettor);
            bankerInfo.setOngAmount(ongAmt);
            bankerInfoMapper.insertBankerWithdraw(bankerInfo);
        } else if (funcName.equals("bankerWithdrawShare")) {
            String bettor = Address.parse(((JSONArray)obj).getString(2)).toBase58();
            double ongAmount = Long.valueOf(com.github.ontio.common.Helper.reverse(((JSONArray)obj).getString(3)),16).doubleValue();
            BigDecimal ongAmt = BigDecimal.valueOf(ongAmount/ConstantParam.ONG_DECIMAL);
            BankerInfo bankerInfo = new BankerInfo();
            bankerInfo.setFuncName("bankerWithdrawShare");
            bankerInfo.setBlockTime(blockTime);
            bankerInfo.setTxHash(txHash);
            bankerInfo.setBanker(bettor);
            bankerInfo.setOngAmount(ongAmt);
            bankerInfoMapper.insertBankerWithdraw(bankerInfo);
        }
    }
}
