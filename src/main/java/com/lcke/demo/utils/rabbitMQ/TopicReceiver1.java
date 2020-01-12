package com.lcke.demo.utils.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: sfdsfcasadsa <br/>
 * Description: <br/>
 * date: 2020/1/9 20:58<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@RabbitListener(queues = {TopicConfig.TOPIC_QUEUE_NAME_1})
@Component("topic-receiver1")
public class TopicReceiver1 {
    @RabbitHandler
    public void handler(String content){
        System.out.println("Topic.Receiver1接收到：" + content);
    }
}