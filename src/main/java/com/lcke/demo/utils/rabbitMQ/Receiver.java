package com.lcke.demo.utils.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: sadasdasdas <br/>
 * Description: <br/>
 * date: 2020/1/7 23:52<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
//通过@RabbitListener注解定义该类对hello队列的监听，
@RabbitListener(queues = {"hello"})
@Component
public class Receiver {

    // 并用@RabbitHandler注解来指定对消息的处理方法。
    // 所以，该消费者实现了对hello队列的消费，消费操作为输出消息的字符串内容。
    @RabbitHandler
    public void handler(String content){
        System.out.println("接收到：" + content);
    }
}