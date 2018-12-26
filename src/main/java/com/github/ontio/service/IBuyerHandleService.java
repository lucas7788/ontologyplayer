package com.github.ontio.service;

import com.github.ontio.model.BuyRecordInfo;
import com.github.ontio.paramBean.Result;

public interface IBuyerHandleService {
    Result getBuyRecordByPage(Integer pageSize, Integer pageNumber);
    Result getMyBuyRecordByPage(String buyer, Integer pageSize, Integer pageNumber);

    Result getMyWithdrawRecordByPage(String buyer, Integer pageSize, Integer pageNumber);

    Result getWinnerByPage(Integer pageSize, Integer pageNumber);
}
