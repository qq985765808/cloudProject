package com.wupeng.cloud.provider.payment8001.utils;

import java.io.Serializable;
import java.util.Date;

/**
 * 时间工具类
 * */
public class DateUtils implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 计算两个时间差(秒)
     * @param endTime
     * @return
     * */
    public Long  calculationTimeDifferenceSecond(Date endTime){
      /*  Long startTime = new Date().getTime();
        Long endTime = endTime.getTime();
        Long difference = (new Date().getTime() - endTime.getTime()) / 1000;*/
        return (new Date().getTime() - endTime.getTime()) / 1000;
    }
}
