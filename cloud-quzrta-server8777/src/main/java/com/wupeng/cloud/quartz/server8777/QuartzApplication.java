package com.wupeng.cloud.quartz.server8777;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * quartz服务
 * */
@SpringBootApplication
@EnableDiscoveryClient
public class QuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class,args);
    }

}
