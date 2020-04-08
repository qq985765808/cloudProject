package com.wupeng.cloud.quartz.server8777.support.quartz;

import com.wupeng.cloud.quartz.server8777.service.ActivityService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.Serializable;


/**
 * 活动任务作业
 * @Date 2020-04-08
 * */
public class ActivityQuartz extends QuartzJobBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ActivityQuartz.class);

    @Autowired
    private ActivityService activityService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        /**
         * 后续更新,用来存放秒杀活动信息到缓存的任务,只要更新triggerTime即可!
         * */
        activityService.getActivityInfo();
    }



}
