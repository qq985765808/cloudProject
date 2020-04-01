package com.wupeng.cloud.rabbitmq.server5673.support.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig  implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RabbitMQConfig.class);

    // 四种模式：Direct，Topic，Fanout，Header

    public static final String DIRECT_QUEUE = "direct_queue";

    public static final String TOPIC_QUEUE_1 = "topic_queue_1";
    public static final String TOPIC_QUEUE_2 = "topic_queue_2";
    public static final String TOPIC_EXCHANGE = "topic_exchange";
    public static final String ROUTINE_KEY_1 = "topic.key1";
    // 可以使用通配符
    public static final String ROUTINE_KEY_2 = "topic.*";
    public static final String ROUTINE_KEY_3 = "topic.#";

    public static final String FANOUT_QUEUE_1 = "fanout_queue_1";
    public static final String FANOUT_QUEUE_2 = "fanout_queue_2";
    public static final String FANOUT_EXCHANGE = "fanout_exchange";

    public static final String HEADERS_QUEUE = "headers_queue";
    public static final String HEADERS_EXCHANGE = "headers_exchange";


    /**
     * 配置rabbit信息(已经用yml配置了)
     * */
/*    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("127.0.0.1:5672");
        connectionFactory.setUsername("wupeng");
        connectionFactory.setPassword("wupeng1314");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true);//消息确认
        connectionFactory.setPublisherReturns(true);
        return connectionFactory;
    }*/


    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        CachingConnectionFactory factory = (CachingConnectionFactory) connectionFactory;
        factory.addConnectionListener(new ConnectionListener() {
            @Override
            public void onCreate(Connection connection) {
                log.error("端口:{}", connection.getLocalPort());
            }
        });

        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setConfirmCallback(new RabbitConfirmCallBack());
        // 触发setReturnCallback回调必须设置mandatory=true, 否则Exchange没有找到Queue就会丢弃掉消息, 而不会触发回调
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(new RabbitReturnCallback());
        return rabbitTemplate;
    }


    // Direct模式
    @Bean
    public Queue directQueue() {
        return new Queue(DIRECT_QUEUE, true);
    }

    // Topic模式：根据RoutineKey去绑定接收的消息
    @Bean
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE_1, true);
    }
    @Bean
    public Queue topicQueue2() {
        return new Queue(TOPIC_QUEUE_2, true);
    }
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }
    @Bean
    public Binding topicBinding1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(ROUTINE_KEY_1);
    }
    @Bean
    public Binding topicBinding2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with(ROUTINE_KEY_2);
    }

    // Fanout模式：广播
    @Bean
    public Queue fanoutQueue1() {
        return new Queue(FANOUT_QUEUE_1, true);
    }
    @Bean
    public Queue fanoutQueue2() {
        return new Queue(FANOUT_QUEUE_2, true);
    }
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }
    @Bean
    public Binding fanoutBinding1() {
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }
    @Bean
    public Binding fanoutBinding2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

    // Headers模式：只有检验头部的KV是一致的才会接收到消息
    @Bean
    public HeadersExchange headersExchage(){
        return new HeadersExchange(HEADERS_EXCHANGE);
    }
    @Bean
    public Queue headerQueue() {
        return new Queue(HEADERS_QUEUE, true);
    }
    @Bean
    public Binding headerBinding() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1", "v1");
        map.put("key2", "v2");
        return BindingBuilder.bind(headerQueue()).to(headersExchage()).whereAll(map).match();
    }

}
