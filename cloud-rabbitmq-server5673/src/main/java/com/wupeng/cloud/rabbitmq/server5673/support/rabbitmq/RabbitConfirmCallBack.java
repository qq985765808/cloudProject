package com.wupeng.cloud.rabbitmq.server5673.support.rabbitmq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.stereotype.Component;

/**
 * 消息发送成功的回调
 * 需要开启
 * #开启发送确认
 * spring.rabbitmq.publisher-confirm-type=CORRELATED
 **/

@Component
public class RabbitConfirmCallBack implements ConfirmCallback {

    private static final Logger log = LoggerFactory.getLogger(RabbitConfirmCallBack.class);

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        //correlationData必须在发送的时候设置，否则将会使null，如下：
        //CorrelationData correlationData = new CorrelationData("1");
        //rabbitTemplate.convertAndSend("OrderDispathExchange","kk",
        //       "{\"msgId\":1,\"data\":\"测试\"}",correlationData);
        if (ack){
               log.info("ack-->消息到达交换机:{}",correlationData);
        }else{
               log.debug("ack-->消息没有到达交换机，cause造成的原因:{}",cause);
        }
        log.info("消息唯一标识: {}", correlationData);
        log.info("确认状态: {}", ack);
        log.info("造成原因: {}", cause);

    }
}
