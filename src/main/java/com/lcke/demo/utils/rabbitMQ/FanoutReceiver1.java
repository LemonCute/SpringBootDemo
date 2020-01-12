package com.lcke.demo.utils.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: sdsadsada <br/>
 * Description: <br/>
 * date: 2020/1/9 20:21<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@RabbitListener(queues = {FanoutConfig.FANOUT_QUEUE_NAME_1})
@Component("fanout-receiver1")
public class FanoutReceiver1 {
    @RabbitHandler
    public void handler(String content){
        System.out.println("Fanout.Receiver1接收到：" + content);
    }
}