package com.github.ontio;

import com.github.ontio.thread.BlockSyncThread;
import com.github.ontio.utils.ConfigParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TaskWareSync {

    @Autowired
    private ApplicationContextProvider applicationContextProvider;

    @Autowired
    private ConfigParam configParam;

    @PostConstruct
    public void init() {
        BlockSyncThread mainChainThread = applicationContextProvider.getBean("BlockSyncThread", BlockSyncThread.class);
        mainChainThread.start();
    }
}
