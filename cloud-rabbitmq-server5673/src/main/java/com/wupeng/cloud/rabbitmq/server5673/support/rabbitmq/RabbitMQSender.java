package com.wupeng.cloud.rabbitmq.server5673.support.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

/**
 * rabbitmq发送者
 * */
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
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        String msg = "TopicMsg";
        log.info("send msg : " + msg);
        amqpTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, "topic.key1", msg + "_1");
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
