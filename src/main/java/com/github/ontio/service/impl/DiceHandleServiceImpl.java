package com.github.ontio.service.impl;

import com.github.ontio.dao.dice.BetRecordMapper;
import com.github.ontio.dao.dice.InvestRecordMapper;
import com.github.ontio.dao.dice.OpenRecordMapper;
import com.github.ontio.dao.dice.QuitRecordMapper;
import com.github.ontio.dao.ontbet.BetsInfoMapper;
import com.github.ontio.model.dice.BetRecord;
import com.github.ontio.model.dice.InvestRecord;
import com.github.ontio.model.dice.OpenRecord;
import com.github.ontio.model.dice.QuitRecord;
import com.github.ontio.paramBean.Result;
import com.github.ontio.service.IDiceHandleService;
import com.github.ontio.utils.ErrorInfo;
import com.github.ontio.utils.Helper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("DiceHandleService")
@MapperScan("com.github.ontio.dao.dice")
public class DiceHandleServiceImpl implements IDiceHandleService {
    private static final String VERSION = "1.0";

    @Autowired
    private BetRecordMapper betRecordMapper;

    @Autowired
    private InvestRecordMapper investRecordMapper;

    @Autowired
    private OpenRecordMapper openRecordMapper;

    @Autowired
    private QuitRecordMapper quitRecordMapper;


    @Override
    public Result getMyBetRecord(String address, Integer pageSize, Integer pageNumber) {
        int start = pageSize * (pageNumber - 1) < 0 ? 0 : pageSize * (pageNumber - 1);
        List<BetRecord> betRecordList = betRecordMapper.selectMyBetRecordByPage(address, start, pageSize);
        return Helper.result("getmybetrecord", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,betRecordList);
    }

    @Override
    public Result getMyInvestRecord(String address, Integer pageSize, Integer pageNumber) {
        int start = pageSize * (pageNumber - 1) < 0 ? 0 : pageSize * (pageNumber - 1);
        List<InvestRecord> betRecordList = investRecordMapper.selectMyInvestRecordByPage(address, start, pageSize);
        return Helper.result("getmyinvestrecord", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,betRecordList);
    }

    @Override
    public Result getMyOpenRecord(String address, Integer pageSize, Integer pageNumber) {
        int start = pageSize * (pageNumber - 1) < 0 ? 0 : pageSize * (pageNumber - 1);
        List<OpenRecord> res = openRecordMapper.selectMyOpenRecordByPage(address, start, pageSize);
        return Helper.result("getmyopenrecord", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,res);
    }

    @Override
    public Result getMyQuitRecord(String address, Integer pageSize, Integer pageNumber) {
        int start = pageSize * (pageNumber - 1) < 0 ? 0 : pageSize * (pageNumber - 1);
        List<QuitRecord> res = quitRecordMapper.selectMyQuitRecordByPage(address, start, pageSize);
        return Helper.result("getmyquitrecord", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,res);
    }

    @Override
    public Result insertBetRecord(List<Object> betList) {
        String address = (String) betList.get(0);
        int res = 1;
        for(int i=1; i< betList.size(); i++){
            if((int)betList.get(i) != 0) {
                BetRecord betRecord = new BetRecord();
                betRecord.setAddress(address);
                Object temp = betList.get(i);
                betRecord.setBetAmount( (int)betList.get(i));
                betRecord.setBetType(i);
                res = betRecordMapper.insertBetRecord(betRecord);
            }
        }
        return Helper.result("insertbetrecord", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,res);
    }

    @Override
    public Result insertInvestRecord(InvestRecord investRecord) {
        int res = investRecordMapper.insertInvestRecord(investRecord);
        return Helper.result("insertinvestrecord", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,res);
    }

    @Override
    public Result insertOpenRecord(OpenRecord openRecord) {
        int res = openRecordMapper.insertOpenRecord(openRecord);
        return Helper.result("insertopenrecord", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,res);
    }

    @Override
    public Result insertQuitRecord(QuitRecord quitRecord) {
        int res = quitRecordMapper.insertQuitRecord(quitRecord);
        return Helper.result("insertquitrecord", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,res);
    }
}
