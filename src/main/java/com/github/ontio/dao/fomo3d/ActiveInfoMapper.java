package com.github.ontio.dao.fomo3d;

import com.github.ontio.model.fomo3d.ActivityInfo;

public interface ActiveInfoMapper {

    ActivityInfo selectRecentActiveInfo();
    int updateIsShowById(int isShow, int id);
    int insertActivityInfo(ActivityInfo activityInfo);
}
