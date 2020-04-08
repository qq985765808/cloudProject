package com.wupeng.cloud.quartz.server8777.support.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 活动任务作业
 * @Date 2020-04-08
 * */
public class ActivityQuartz extends QuartzJobBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ActivityQuartz.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("ActivityQuartzTime:{}",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }



}
