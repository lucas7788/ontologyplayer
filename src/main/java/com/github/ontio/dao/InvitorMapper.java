package com.github.ontio.dao;

import com.github.ontio.model.InvitorInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "InvitorMapper")
public interface InvitorMapper {

    InvitorInfo selectInvitorByAddress(String address);
    int insertInvitor(InvitorInfo invitorInfo);

    int selectTotalByInvitor(String invitor);

}
