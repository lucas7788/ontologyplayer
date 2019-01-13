package com.github.ontio.service;

import com.github.ontio.model.ontbet.BetInfo;
import com.github.ontio.paramBean.Result;

public interface IBetsHandleService {
    Result getBetsByPage(Integer pageSize, Integer pageNumber);
    Result getMyBetsByBettor(String bettor);
    Result getMyBetsByPage(String bettor, Integer pageSize, Integer pageNumber);
    Result insertBetInfo(BetInfo betInfo);

    Result getHugeWinsTopByNum(Integer num);
    Result insertHugeWin(BetInfo betInfo);

}
