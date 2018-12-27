package com.github.ontio.dao;

import com.github.ontio.model.WinnerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component(value = "WinnerInfoMapper")
public interface WinnerInfoMapper {
    int insertWinnerInfo(WinnerInfo winnerInfo);
    List<WinnerInfo> selectWinnerInfoByPage(Integer start, Integer pageSize);
}
