package com.wupeng.cloud.provider.payment8001.test;

import com.wupeng.cloud.provider.payment8001.PaymentApplication;
import com.wupeng.cloud.provider.payment8001.support.rabbitmq.CustomMessageProcessor;
import com.wupeng.cloud.provider.payment8001.support.rabbitmq.RabbitMQConfig;
import com.wupeng.cloud.provider.payment8001.support.rabbitmq.RabbitMQSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@SpringBootTest(classes = PaymentApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitMQ {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Test
    public void  test(){

        /**
         * 测试：第一个参数交换机(exchage),第二个文参数路由key(topic fanout...),第三个参数
         *
         * */
        //rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE,RabbitMQConfig.ROUTINE_KEY_1,new Message("SS".getBytes(),new MessageProperties()),new CorrelationData(UUID.randomUUID().toString()));

        rabbitMQSender.sendTopic();

    }

}
