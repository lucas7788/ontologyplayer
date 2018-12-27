package com.github.ontio.dao;

import com.github.ontio.model.WithdrawRecordInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component(value = "WithdrawRecordInfoMapper")
public interface WithdrawRecordInfoMapper {
    int insertWithdrawRecordInfo(WithdrawRecordInfo withdrawRecordInfo);
    List<WithdrawRecordInfo> selectMyWithdrawRecordByPage(String address, Integer start, Integer pageSize);
}
