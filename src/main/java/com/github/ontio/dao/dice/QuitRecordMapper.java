package com.github.ontio.dao.dice;

import com.github.ontio.model.dice.QuitRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "QuitRecordMapper")
public interface QuitRecordMapper {
    List<QuitRecord> selectMyQuitRecordByPage(String address, Integer start, Integer pageSize);
    int insertQuitRecord(QuitRecord quitRecord);
}
