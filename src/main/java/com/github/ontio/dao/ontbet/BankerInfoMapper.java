package com.github.ontio.dao.ontbet;


import com.github.ontio.model.ontbet.BankerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "BankerInfoMapper")
public interface BankerInfoMapper {
    List<BankerInfo> selectBankerInvestByPage(String banker, Integer start, Integer pageSize);
    List<BankerInfo> selectBankerWithdrawByPage(String banker, Integer start, Integer pageSize);
    int selectBankerWithdrawByTxHash(String txHash);
    int selectBankerInvestByTxHash(String txHash);
    int insertBankerInvest(BankerInfo bankerInvest);
    int insertBankerWithdraw(BankerInfo bankerWithdraw);
}
