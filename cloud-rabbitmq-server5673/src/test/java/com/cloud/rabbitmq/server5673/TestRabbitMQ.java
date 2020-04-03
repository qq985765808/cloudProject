package com.cloud.rabbitmq.server5673;

import com.wupeng.cloud.rabbitmq.server5673.RabbitMQApplication;
import com.wupeng.cloud.rabbitmq.server5673.jsonObject.OrderJsonObject;
import com.wupeng.cloud.rabbitmq.server5673.service.RabbitOrderReceiverService;
import com.wupeng.cloud.rabbitmq.server5673.support.rabbitmq.RabbitMQConfig;
import com.wupeng.cloud.rabbitmq.server5673.support.rabbitmq.RabbitMQSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
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

    @Autowired
    private RabbitOrderReceiverService receiverService;

    @Autowired
    private AmqpTemplate amqpTemplate;


    @Test
    public void testRabbit(){
        rabbitMQSender.sendTopic();
    }

    @Test
    public void testRabbitController(){
        OrderJsonObject orderJsonObject = new OrderJsonObject();
        //receiverService.OrderConsumption(orderJsonObject.toString());
        amqpTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, "topic.key2", orderJsonObject.toString());
    }

}
