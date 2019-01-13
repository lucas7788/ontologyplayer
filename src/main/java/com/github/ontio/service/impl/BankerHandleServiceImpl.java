package com.github.ontio.service.impl;

import com.github.ontio.dao.ontbet.BankerInfoMapper;
import com.github.ontio.model.ontbet.BankerInfo;
import com.github.ontio.paramBean.Result;
import com.github.ontio.service.IBankerHandleService;
import com.github.ontio.utils.ErrorInfo;
import com.github.ontio.utils.Helper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("BankerHandleService")
@MapperScan("com.github.ontio.dao.ontbet")
public class BankerHandleServiceImpl implements IBankerHandleService {

    private static final String VERSION = "1.0";

    @Autowired
    private BankerInfoMapper bankerInfoMapper;

    @Override
    public Result getBankerInvestByPage(String banker,Integer pageSize, Integer pageNumber) {
        int start = pageSize * (pageNumber - 1) < 0 ? 0 : pageSize * (pageNumber - 1);
        List<BankerInfo> bankerInfoList = bankerInfoMapper.selectBankerInvestByPage(banker, start, pageSize);
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", bankerInfoList);
        return Helper.result("getbankerinvestbypage", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getBankerWithdrawByPage(String banker, Integer pageSize, Integer pageNumber) {

        int start = pageSize * (pageNumber - 1) < 0 ? 0 : pageSize * (pageNumber - 1);
        List<BankerInfo> bankerInfoList = bankerInfoMapper.selectBankerWithdrawByPage(banker, start, pageSize);
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", bankerInfoList);
        return Helper.result("getbankerwithdrawbypage", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result insertBankerInvest(BankerInfo bankerInfo) {
        int result = bankerInfoMapper.insertBankerInvest(bankerInfo);
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", result);
        return Helper.result("savebankerinvest", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result insertBankerWithdraw(BankerInfo bankerInfo) {
        int result = bankerInfoMapper.insertBankerWithdraw(bankerInfo);
        Map<String, Object> rs = new HashMap<>();
        rs.put("Result", result);
        return Helper.result("savebankerwithdraw", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }
}
