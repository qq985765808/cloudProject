package com.wupeng.cloud.rabbitmq.server5673;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * rabbirmq服务
 * */
@SpringBootApplication
@EnableDiscoveryClient
public class RabbitMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQApplication.class,args);
    }
}
