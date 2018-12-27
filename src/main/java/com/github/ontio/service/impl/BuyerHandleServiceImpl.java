package com.github.ontio.service.impl;

import com.github.ontio.dao.BuyRecordInfoMapper;
import com.github.ontio.dao.InvitorMapper;
import com.github.ontio.dao.WinnerInfoMapper;
import com.github.ontio.model.BuyRecordInfo;
import com.github.ontio.model.InvitorInfo;
import com.github.ontio.model.WinnerInfo;
import com.github.ontio.paramBean.Result;
import com.github.ontio.service.IBuyerHandleService;
import com.github.ontio.utils.ConstantParam;
import com.github.ontio.utils.ErrorInfo;
import com.github.ontio.utils.Helper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("BetsHandleService")
@MapperScan("com.github.ontio.dao")
public class BuyerHandleServiceImpl implements IBuyerHandleService {

    private static final String VERSION = "1.0";

    @Autowired
    private BuyRecordInfoMapper buyRecordInfoMapper;

    @Autowired
    private WinnerInfoMapper winnerInfoMapper;

    @Autowired
    private InvitorMapper invitorMapper;

    @Override
    public Result getInvitorByAddress(String address) {
        InvitorInfo invitorInfo = invitorMapper.selectInvitorByAddress(address);
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", invitorInfo);
        return Helper.result("getinvitorbyaddress", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getTotalByInvitor(String invitor) {
        int total = invitorMapper.selectTotalByInvitor(invitor);
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", total);
        return Helper.result("gettotalbyinvitor", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result saveInvitor(InvitorInfo invitorInfo) {
        int res = invitorMapper.insertInvitor(invitorInfo);
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", res);
        return Helper.result("saveinvitor", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getBuyRecordByPage(Integer pageSize, Integer pageNumber) {
        int start = pageSize * (pageNumber - 1) < 0 ? 0 : pageSize * (pageNumber - 1);
        List<BuyRecordInfo> buyRecordInfoList =  buyRecordInfoMapper.selectBuyRecordByPage(start, pageSize);
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", buyRecordInfoList);
        return Helper.result("getbuyrecordbypage", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getMyBuyRecordByPage(String buyer, Integer pageSize, Integer pageNumber) {

        int start = pageSize * (pageNumber - 1) < 0 ? 0 : pageSize * (pageNumber - 1);
        List<BuyRecordInfo> buyRecordInfoList =  buyRecordInfoMapper.selectMyBuyRecordByPage(buyer, start, pageSize);
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", buyRecordInfoList);
        return Helper.result("getmybuyrecordbypage", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }


    @Override
    public Result getMyWithdrawRecordByPage(String buyer, Integer pageSize, Integer pageNumber) {
        int start = pageSize * (pageNumber - 1) < 0 ? 0 : pageSize * (pageNumber - 1);
        List<BuyRecordInfo> buyRecordInfoList =  buyRecordInfoMapper.selectMyBuyRecordByPage(buyer, start, pageSize);
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", buyRecordInfoList);
        return Helper.result("getmywithdrawrecordbypage", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getWinnerByPage(Integer pageSize, Integer pageNumber) {
        int start = pageSize * (pageNumber - 1) < 0 ? 0 : pageSize * (pageNumber - 1);
        List<WinnerInfo> winnerInfoList =  winnerInfoMapper.selectWinnerInfoByPage(start, pageSize);
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", winnerInfoList);
        return Helper.result("getwinnerbypage", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }
}
