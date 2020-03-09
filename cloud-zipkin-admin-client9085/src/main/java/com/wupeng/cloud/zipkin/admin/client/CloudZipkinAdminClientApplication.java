package com.wupeng.cloud.zipkin.admin.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * admin 客户端
 * */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudZipkinAdminClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudZipkinAdminClientApplication.class, args);
    }
}
