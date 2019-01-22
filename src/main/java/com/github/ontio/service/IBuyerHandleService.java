package com.github.ontio.service;

import com.github.ontio.model.fomo3d.ActivityInfo;
import com.github.ontio.model.fomo3d.ActivityIsShow;
import com.github.ontio.model.fomo3d.InvitorInfo;
import com.github.ontio.paramBean.Result;

public interface IBuyerHandleService {
    Result getBuyRecordByPage(Integer pageSize, Integer pageNumber);
    Result getMyBuyRecordByPage(String buyer, Integer pageSize, Integer pageNumber);

    Result getMyWithdrawRecordByPage(String buyer, Integer pageSize, Integer pageNumber);

    Result getWinnerByPage(Integer pageSize, Integer pageNumber);

    Result saveInvitor(InvitorInfo invitorInfo);

    Result getInvitorByAddress(String address);

    Result getTotalByInvitor(String invitor);

    Result getActivity();
    Result addActivity(ActivityInfo activityInfo);
    Result updateActivityIsShow(ActivityIsShow activityIsShow);


    Result getMyInvestRecordByPage(String banker, Integer pageSize, Integer pageNumber);
    Result getMyBankerWithdrawByPage(String banker, Integer pageSize, Integer pageNumber);
}
