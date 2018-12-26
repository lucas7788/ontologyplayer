package com.github.ontio.dao;

import com.github.ontio.model.WinnerInfo;

import java.util.List;

public interface WinnerInfoMapper {
    int insertWinnerInfo(WinnerInfo winnerInfo);
    List<WinnerInfo> selectWinnerInfoByPage(Integer start, Integer pageSize);
}
