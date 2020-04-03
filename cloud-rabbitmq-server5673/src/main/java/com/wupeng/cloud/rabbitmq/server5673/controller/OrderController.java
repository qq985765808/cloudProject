package com.wupeng.cloud.rabbitmq.server5673.controller;

import com.wupeng.cloud.rabbitmq.server5673.jsonObject.OrderJsonObject;
import com.wupeng.cloud.rabbitmq.server5673.support.rabbitmq.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "orderQueue")
public class OrderController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "/saveOrder")
    public Object saveOrderQueueInfo(){
        Map map = new HashMap();
        OrderJsonObject orderJsonObject = new OrderJsonObject();
        if(orderJsonObject!=null){
             amqpTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, "topic.key2", orderJsonObject.toString());
            map.put("msg","ok");
            map.put("status",true);
        }else{
            map.put("msg","no");
            map.put("status",false);
        }
        log.info("order:{}",orderJsonObject);
        return  map;
    }


}
