package com.wupeng.cloud.zipkin.admin.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * admin 服务端
 * */
@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
public class CloudZipkinAdminServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudZipkinAdminServerApplication.class, args);
    }
}
