package com.wupeng.cloud.quartz.server8777.config;

import com.wupeng.cloud.quartz.server8777.support.quartz.ActivityQuartz;
import com.wupeng.cloud.quartz.server8777.support.quartz.OrderQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 任务调度配置中心
 * */
@Configuration
public class QuartzConfig {

    /**
     * 订单任务
     * */
    @Bean
    public JobDetail orderQuzrtz(){
        return JobBuilder.newJob(OrderQuartz.class)
                .withIdentity("orderQuartzTask","orderQuartzTaskGroup")//参数一:任务名称 参数二:任务分组名
                .usingJobData("orderQuartzTaskDataKey","orderQuartzTaskDataValue")//JobDataMap<key,value>类型
                .storeDurably().build();
    }

    /**
     * 订单任务触发器
     * */
    @Bean
    public Trigger orderQuzrtzTrigger() {
        //59秒执行一次
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(59) //这里设置秒数
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(orderQuzrtz())
                .withIdentity("orderQuartzTriggerTask","orderQuartzTaskTriggerGroup")//参数一:触发器名称 参数二:触发器分组名
                .usingJobData("orderQuartzTaskTriggerDataKey","orderQuartzTaskTriggerDateValue")//JobDataMap<key,value>类型
                .withSchedule(scheduleBuilder)
                .build();
    }

    /**
     * 活动任务
     * */
    @Bean
    public JobDetail activityQuartz(){
        return JobBuilder.newJob(ActivityQuartz.class).withIdentity("activityQuartzTask").storeDurably().build();
    }

    /**
     * 活动任务触发器
     * */
    @Bean
    public Trigger activityQuartzTrigger() {
        //cron方式，每隔0-59秒执行一次
        return TriggerBuilder.newTrigger().forJob(activityQuartz())
                .withIdentity("activityQuartzTask")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/59 * * * * ?"))
                .build();

    }

}
