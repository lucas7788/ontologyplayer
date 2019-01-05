package com.github.ontio.dao;

import com.github.ontio.model.BuyRecordInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "BuyRecordInfoMapperONT")
public interface BuyRecordInfoMapperONT {
    List<BuyRecordInfo> selectBuyRecordByPage(Integer start, Integer pageSize);
    List<BuyRecordInfo> selectMyBuyRecordByPage(String buyer, Integer start, Integer pageSize);
    List<BuyRecordInfo> selectBuyRecordByAddressRound(String buyer, int round);
    int selectBuyRecordByTxHash(String txHash);
    int insertBuyRecordInfo(BuyRecordInfo buyRecordInfo);
}
