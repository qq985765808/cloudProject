package com.wupeng.cloud.eureka.feign.service;

import com.wupeng.cloud.eureka.feign.service.impl.FeignServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SPRING-CLOUD-RUREKA-CLIENT",fallback = FeignServiceHystrixImpl.class)
public interface FeignService {

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message);

}
