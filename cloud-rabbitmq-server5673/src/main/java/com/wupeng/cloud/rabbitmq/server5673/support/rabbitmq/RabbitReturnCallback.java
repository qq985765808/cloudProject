package com.wupeng.cloud.rabbitmq.server5673.support.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.stereotype.Component;


/**
 * 发生异常时的消息返回提醒
 * 需要开启
 * # 开启发送失败退回
 * spring.rabbitmq.publisher-returns=true
 **/

@Component
public class RabbitReturnCallback implements ReturnCallback {

    private static final Logger log  = LoggerFactory.getLogger(RabbitReturnCallback.class);

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {

        log.info("消息主体: {}", message);
        log.info("回复编码: {}", replyCode);
        log.info("回复内容: {}", replyText);
        log.info("交换器: {}", exchange);
        log.info("路由键: {}", routingKey);

    }
}
