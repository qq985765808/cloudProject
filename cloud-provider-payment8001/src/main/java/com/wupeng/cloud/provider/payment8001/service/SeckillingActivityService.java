package com.wupeng.cloud.provider.payment8001.service;

import com.wupeng.cloud.provider.payment8001.pojo.SeckillingActivity;

import java.util.List;

/**
 * 限时活动服务类
 * */
public interface SeckillingActivityService  {


    public  int updateSeckillingActivityProductsNumSubOneById(Long seckillingActivityId);

    void save(SeckillingActivity seckillingActivity);

    SeckillingActivity getSeckillingActivityById(Long seckillingActivityId);

    List<SeckillingActivity> findAll();

}
