package com.github.ontio.dao.fomo3d;

import com.github.ontio.model.fomo3d.WinnerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component(value = "WinnerInfoMapper")
public interface WinnerInfoMapper {
//  ong
    int insertWinnerInfo(WinnerInfo winnerInfo);
    List<WinnerInfo> selectWinnerInfoByPage(Integer start, Integer pageSize);

//  ont
    int insertWinnerInfoONT(WinnerInfo winnerInfo);
    List<WinnerInfo> selectWinnerInfoByPageONT(Integer start, Integer pageSize);
}
