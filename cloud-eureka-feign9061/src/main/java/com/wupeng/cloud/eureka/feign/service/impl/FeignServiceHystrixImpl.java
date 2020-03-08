package com.wupeng.cloud.eureka.feign.service.impl;

import com.wupeng.cloud.eureka.feign.service.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceHystrixImpl implements FeignService {

    @Override
    public String sayHi(String message) {
        return "Hi，your message is :\"" + message + "\" but request error.";
    }
}
