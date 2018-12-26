package com.github.ontio.dao;


import com.github.ontio.model.BuyRecordInfo;
import com.github.ontio.model.WithdrawRecordInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component(value = "BuyRecordInfoMapper")
public interface BuyRecordInfoMapper {
    List<BuyRecordInfo> selectBuyRecordByPage(Integer start, Integer pageSize);
    List<BuyRecordInfo> selectMyBuyRecordByPage(String buyer, Integer start, Integer pageSize);
    List<BuyRecordInfo> selectBuyRecordByAddressRound(String buyer, int round);
    int selectBuyRecordByTxHash(String txHash);
    int insertBuyRecordInfo(BuyRecordInfo buyRecordInfo);
}
