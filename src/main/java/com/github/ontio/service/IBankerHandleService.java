package com.github.ontio.service;

import com.github.ontio.model.ontbet.BankerInfo;
import com.github.ontio.paramBean.Result;

public interface IBankerHandleService {
    Result getBankerInvestByPage(String banker,Integer pageSize, Integer pageNumber);
    Result getBankerWithdrawByPage(String banker,Integer pageSize, Integer pageNumber);
    Result insertBankerInvest(BankerInfo bankerInfo);
    Result insertBankerWithdraw(BankerInfo bankerInfo);
}
