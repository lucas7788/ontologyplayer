package com.github.ontio;


import com.github.ontio.thread.ScheduleTaskThread;
import com.github.ontio.utils.ConfigParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TaskWareScheduleTask {

    @Autowired
    private ApplicationContextProvider applicationContextProvider;

    @Autowired
    private ConfigParam configParam;


    @PostConstruct
    public void init() {
        ScheduleTaskThread scheduleTaskThread = applicationContextProvider.getBean("ScheduleTaskThread", ScheduleTaskThread.class);
        scheduleTaskThread.start();
    }
}
