package com.wupeng.cloud.provider.payment8001.service.impl;

import com.wupeng.cloud.provider.payment8001.pojo.SeckillingActivity;
import com.wupeng.cloud.provider.payment8001.repository.SeckillingActivityRepository;
import com.wupeng.cloud.provider.payment8001.service.SeckillingActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 限时活动服务实现类
 * */
@Service
@Transactional
public class SeckillingActivityServiceImpl implements SeckillingActivityService {

    @Autowired
    private SeckillingActivityRepository seckillingActivityRepository;


    @Override
    public int updateSeckillingActivityProductsNumSubOneById(Long seckillingActivityId) {
        return seckillingActivityRepository.updateSeckillingActivityProductsNumSubOneById(seckillingActivityId);
    }

    @Override
    public void save(SeckillingActivity seckillingActivity) {
        seckillingActivityRepository.save(seckillingActivity);
    }

    @Override
    public SeckillingActivity getSeckillingActivityById(Long seckillingActivityId) {
        return seckillingActivityRepository.getOne(seckillingActivityId);
    }

    @Override
    public List<SeckillingActivity> findAll() {
        return seckillingActivityRepository.findAll();
    }
}
