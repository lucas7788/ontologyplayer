package com.github.ontio.dao.dice;

import com.github.ontio.model.dice.InvestRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "InvestRecordMapper")
public interface InvestRecordMapper {
    List<InvestRecord> selectMyInvestRecordByPage(String address, Integer start, Integer pageSize);
    int insertInvestRecord(InvestRecord investRecord);
}
