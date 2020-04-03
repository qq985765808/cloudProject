package com.wupeng.cloud.rabbitmq.server5673.service;

/**
 * 订单消费服务接口
 * */
public interface RabbitOrderReceiverService {

     void  OrderConsumption(String order);

}
