package com.wupeng.cloud.provider.payment8001.support.rabbitmq;

import java.io.Serializable;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSender implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RabbitMQSender.class);

    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendDirect() {
        String msg = "DirectMsg";
        log.info("send msg : " + msg);
        amqpTemplate.convertAndSend(RabbitMQConfig.DIRECT_QUEUE, msg);
    }

    public void sendTopic() {
        Message message = new Message("SS".getBytes(),new MessageProperties());
        String msg = "TopicMsg";
        log.info("send msg : " + msg);
        amqpTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, "topic.key1", msg + "_1");
        amqpTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, "topic.key2", msg + "_2");
        amqpTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, "topic.key2", msg + "_2");
    }

    public void sendFanout() {
        String msg = "FanoutMsg";
        log.info("send msg : " + msg);
        amqpTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE, "", msg);
    }

    public void sendHeaders() {
        String msg = "HeadersMsg";
        log.info("send msg : " + msg);
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("h1", "v1");
        messageProperties.setHeader("h2", "v2");
        Message message = new Message(msg.getBytes(), messageProperties);
        amqpTemplate.convertAndSend(RabbitMQConfig.HEADERS_EXCHANGE, "", message);
    }


}
