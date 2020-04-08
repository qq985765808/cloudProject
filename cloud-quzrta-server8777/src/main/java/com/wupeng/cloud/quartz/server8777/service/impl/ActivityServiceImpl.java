package com.wupeng.cloud.quartz.server8777.service.impl;

import com.wupeng.cloud.quartz.server8777.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 活动服务实现类
 * @author Administrator
 * @date 2020-04-08
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    private static Logger log = LoggerFactory.getLogger(ActivityServiceImpl.class);

    @Override
    public void getActivityInfo() {
        log.info("ActivityServiceImplTime:{}",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
