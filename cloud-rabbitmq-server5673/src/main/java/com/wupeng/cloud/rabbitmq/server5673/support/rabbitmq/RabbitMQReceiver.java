package com.wupeng.cloud.rabbitmq.server5673.support.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * rabbitmq消费者
 * */
@Component
public class RabbitMQReceiver implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RabbitMQReceiver.class);

    @RabbitListener(queues = RabbitMQConfig.DIRECT_QUEUE)
    public void receiveDirect(String msg) {
        log.info("Direct Receive : " + msg);
    }

    @RabbitListener(queues = RabbitMQConfig.TOPIC_QUEUE_1)
    public void receiveTopic1(String msg) {
        log.info("Topic1 Receive : " + msg);
    }

    @RabbitListener(queues = RabbitMQConfig.TOPIC_QUEUE_2)
    public void receiveTopic2(String msg) {
        log.info("Topic2 Receive : " + msg);
    }

    @RabbitListener(queues = RabbitMQConfig.FANOUT_QUEUE_1)
    public void receiveFanout1(String msg) {
        log.info("Fanout1 Receive : " + msg);
    }

    @RabbitListener(queues = RabbitMQConfig.FANOUT_QUEUE_2)
    public void receiveFanout2(String msg) {
        log.info("Fanout2 Receive : " + msg);
    }

    @RabbitListener(queues = RabbitMQConfig.HEADERS_QUEUE)
    public void receiveHeaders(byte[] msg) {
        log.info("Headers Receive : " + new String(msg));
    }

}
