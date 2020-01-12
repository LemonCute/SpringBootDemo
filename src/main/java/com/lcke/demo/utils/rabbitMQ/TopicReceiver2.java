package com.lcke.demo.utils.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: dsfsdfds <br/>
 * Description: <br/>
 * date: 2020/1/9 20:58<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@RabbitListener(queues = {TopicConfig.TOPIC_QUEUE_NAME_2})
@Component("topic-receiver2")
public class TopicReceiver2 {
    @RabbitHandler
    public void handler(String content){
        System.out.println("Topic.Receiver2接收到：" + content);
    }
}

