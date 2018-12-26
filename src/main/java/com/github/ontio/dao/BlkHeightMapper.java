package com.github.ontio.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "BlkHeightMapper")
public interface BlkHeightMapper {
    int update(Integer height);
    int selectDBHeight();
}
