package com.github.ontio.dao.fomo3d;

import com.github.ontio.model.fomo3d.ActivityInfo;
import com.github.ontio.model.fomo3d.ActivityIsShow;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "ActiveInfoMapper")
public interface ActiveInfoMapper {

    ActivityInfo selectRecentActiveInfo();
    int updateIsShowById(ActivityIsShow activityIsShow);
    int insertActivityInfo(ActivityInfo activityInfo);
}
