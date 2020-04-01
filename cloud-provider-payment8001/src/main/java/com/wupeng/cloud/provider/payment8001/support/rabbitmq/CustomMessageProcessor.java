package com.wupeng.cloud.provider.payment8001.support.rabbitmq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Correlation;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 自定义amqp消息处理类
 * */
@Component
public class CustomMessageProcessor implements MessagePostProcessor {

    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        message.getMessageProperties().getHeaders().put("uuid", UUID.randomUUID().toString());
        return message;
    }
    @Override
    public Message postProcessMessage(Message message,Correlation correlation) throws AmqpException {

        return message;
    }
}
