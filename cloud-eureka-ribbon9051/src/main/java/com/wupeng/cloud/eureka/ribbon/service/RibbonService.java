package com.wupeng.cloud.eureka.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String sayHi(String message) {
        return restTemplate.getForObject("http://SPRING-CLOUD-EUREKA-CLIENT/hi?message=" + message, String.class);
    }

    @HystrixCommand(fallbackMethod = "error")
    public String saveOrderQueuesInfo(String message) {
        return restTemplate.getForEntity("http://SPRING-CLOUD-RABBIITMQ/orderQueue/saveOrder" , JSONObject.class).getBody().toString();
}

    public String error(String message) { return "Hi，your message is :\"" + message + "\" but request error."; }
}
