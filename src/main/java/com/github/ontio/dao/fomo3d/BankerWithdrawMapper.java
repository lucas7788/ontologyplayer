package com.github.ontio.dao.fomo3d;

import com.github.ontio.model.fomo3d.BankerWithdrawRecord;

import java.util.List;

public interface BankerWithdrawMapper {
    List<BankerWithdrawRecord> selectMyBankerWithdrawByPage(String banker, int start, int pageSize);
    int insertBankerWithdraw(BankerWithdrawRecord bankerWithdrawRecord);
}
