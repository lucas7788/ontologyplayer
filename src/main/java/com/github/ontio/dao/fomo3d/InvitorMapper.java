package com.github.ontio.dao.fomo3d;

import com.github.ontio.model.fomo3d.InvitorInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "InvitorMapper")
public interface InvitorMapper {
//  ong
    InvitorInfo selectInvitorByAddress(String address);
    int insertInvitor(InvitorInfo invitorInfo);
    int selectTotalByInvitor(String invitor);

//  ont
    InvitorInfo selectInvitorByAddressONT(String address);
    int insertInvitorONT(InvitorInfo invitorInfo);
    int selectTotalByInvitorONT(String invitor);
}
