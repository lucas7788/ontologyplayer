package com.github.ontio.service;

import com.github.ontio.model.InvitorInfo;
import com.github.ontio.paramBean.Result;

public interface IBuyerHandleONTService {
    Result getBuyRecordByPage(Integer pageSize, Integer pageNumber);
    Result getMyBuyRecordByPage(String buyer, Integer pageSize, Integer pageNumber);

    Result getMyWithdrawRecordByPage(String buyer, Integer pageSize, Integer pageNumber);

    Result getWinnerByPage(Integer pageSize, Integer pageNumber);

    Result saveInvitor(InvitorInfo invitorInfo);

    Result getInvitorByAddress(String address);

    Result getTotalByInvitor(String invitor);
}
