package com.github.ontio.service;

import com.github.ontio.model.dice.InvestRecord;
import com.github.ontio.model.dice.OpenRecord;
import com.github.ontio.model.dice.QuitRecord;
import com.github.ontio.paramBean.Result;

import java.util.List;

public interface IDiceHandleService {
    Result getMyBetRecord(String address, Integer pageSize, Integer pageNumber);
    Result getMyInvestRecord(String address,Integer pageSize, Integer pageNumber);
    Result getMyOpenRecord(String address,Integer pageSize, Integer pageNumber);
    Result getMyQuitRecord(String address,Integer pageSize, Integer pageNumber);

    Result insertBetRecord(List<Object> betList);
    Result insertInvestRecord(InvestRecord investRecord);
    Result insertOpenRecord(OpenRecord openRecord);
    Result insertQuitRecord(QuitRecord quitRecord);
}
