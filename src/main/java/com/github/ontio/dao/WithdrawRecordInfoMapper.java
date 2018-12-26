package com.github.ontio.dao;

import com.github.ontio.model.WithdrawRecordInfo;

import java.util.List;

public interface WithdrawRecordInfoMapper {
    int insertWithdrawRecordInfo(WithdrawRecordInfo withdrawRecordInfo);
    List<WithdrawRecordInfo> selectMyWithdrawRecordByPage(String address, Integer start, Integer pageSize);
}
