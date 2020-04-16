package com.wupeng.cloud.provider.payment8001.config;

import com.mongodb.MongoClientOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mongodb配置类
 * @author Administrator
 * @date 2020-04-16
 */
@Configuration
public class MongoDbConfig {

    @Bean
    public MongoClientOptions mongoClientOptions(){
        return  MongoClientOptions.builder().maxConnectionIdleTime(6000).build();
    }
}
