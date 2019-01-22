package com.github.ontio.dao.dice;

import com.github.ontio.model.dice.BetRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "BetRecordMapper")
public interface BetRecordMapper {
    List<BetRecord> selectMyBetRecordByPage(String address, Integer start, Integer pageSize);
    int insertBetRecord(BetRecord betRecord);
}
