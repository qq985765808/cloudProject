package com.wupeng.cloud.rabbitmq.server5673.service.impl;

import com.wupeng.cloud.rabbitmq.server5673.service.RabbitOrderReceiverService;
import com.wupeng.cloud.rabbitmq.server5673.support.rabbitmq.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 服务消费者
 * */
@Service
@Component
public class RabbitOrderReceiverServiceImpl implements RabbitOrderReceiverService,Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RabbitOrderReceiverServiceImpl.class);


    @Override
    @RabbitListener(queues = RabbitMQConfig.TOPIC_QUEUE_2)
    public void OrderConsumption(String order) {
        log.info("order:{}",order);
}
}
