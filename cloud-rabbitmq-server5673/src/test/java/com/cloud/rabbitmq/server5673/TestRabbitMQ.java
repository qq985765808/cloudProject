package com.cloud.rabbitmq.server5673;

import com.wupeng.cloud.rabbitmq.server5673.RabbitMQApplication;
import com.wupeng.cloud.rabbitmq.server5673.support.rabbitmq.RabbitMQSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitMQApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitMQ {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Test
    public void testRabbit(){
        rabbitMQSender.sendTopic();
    }

}
