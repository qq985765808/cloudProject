package com.wupeng.cloud.mongodb.server8668;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * mongodb
 * @author king
 * @date 2020-04-11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class,args);
    }
}
