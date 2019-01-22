package com.github.ontio.dao.fomo3d;

import com.github.ontio.model.fomo3d.InvestRecord;

import java.util.List;

public interface InvestMapper {

    List<InvestRecord> selectMyInvestRecordByPage(String banker, int start, int pageSize);
    int insertInvestRecord(InvestRecord investRecord);
}
