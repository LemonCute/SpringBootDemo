package com.lcke.demo.utils.rabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: ssadsadas <br/>
 * Description: <br/>
 * date: 2020/1/9 20:17<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@Configuration
public class FanoutConfig {
    public static final String FANOUT_QUEUE_NAME_1 = "fanout-queue-1";
    public static final String FANOUT_QUEUE_NAME_2 = "fanout-queue-2";
    public static final String FANOUT_EXCHANGE_NAME = "fanout-exchange";

    public static final String ROUTE_KEY_1 = "direct.route.key.1";
    public static final String ROUTE_KEY_2 = "direct.route.key.2";

    @Bean
    public Queue fanoutQueue1() {
//        return new Queue(FANOUT_QUEUE_NAME_1);//默认情况，durable为true,exclusive为false,auto-delete为false
        return QueueBuilder.durable(FANOUT_QUEUE_NAME_1).build();
    }

    @Bean
    public Queue fanoutQueue2() {
//        return new Queue(FANOUT_QUEUE_NAME_1);//默认情况，durable为true,exclusive为false,auto-delete为false
        return QueueBuilder.durable(FANOUT_QUEUE_NAME_2).build();
    }

    @Bean
    public FanoutExchange fanoutExchange() {
//        return new FanoutExchange(FANOUT_EXCHANGE_NAME);//默认情况下，durable为true,auto-delete为false
        return (FanoutExchange) ExchangeBuilder.fanoutExchange(FANOUT_EXCHANGE_NAME).durable(true).build();
    }

    @Bean
    public Binding fanoutBinding1(FanoutExchange fanoutExchange, Queue fanoutQueue1) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    public Binding fanoutBinding2(FanoutExchange fanoutExchange, Queue fanoutQueue2) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }

}