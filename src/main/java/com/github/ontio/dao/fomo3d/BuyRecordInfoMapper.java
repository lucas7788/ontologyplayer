package com.github.ontio.dao.fomo3d;


import com.github.ontio.model.fomo3d.BuyRecordInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component(value = "BuyRecordInfoMapper")
public interface BuyRecordInfoMapper {
//    ong
    List<BuyRecordInfo> selectBuyRecordByPage(Integer start, Integer pageSize);
    List<BuyRecordInfo> selectMyBuyRecordByPage(String buyer, Integer start, Integer pageSize);
    List<BuyRecordInfo> selectBuyRecordByAddressRound(String buyer, int round);
    int selectBuyRecordByTxHash(String txHash);
    int insertBuyRecordInfo(BuyRecordInfo buyRecordInfo);

//    ont
    List<BuyRecordInfo> selectBuyRecordByPageONT(Integer start, Integer pageSize);
    List<BuyRecordInfo> selectMyBuyRecordByPageONT(String buyer, Integer start, Integer pageSize);
    List<BuyRecordInfo> selectBuyRecordByAddressRoundONT(String buyer, int round);
    int selectBuyRecordByTxHashONT(String txHash);
    int insertBuyRecordInfoONT(BuyRecordInfo buyRecordInfo);
}
