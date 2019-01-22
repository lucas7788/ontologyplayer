package com.github.ontio.dao.dice;

import com.github.ontio.model.dice.OpenRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "OpenRecordMapper")
public interface OpenRecordMapper {
    List<OpenRecord> selectMyOpenRecordByPage(String address, Integer start, Integer pageSize);
    int insertOpenRecord(OpenRecord openRecord);
}
