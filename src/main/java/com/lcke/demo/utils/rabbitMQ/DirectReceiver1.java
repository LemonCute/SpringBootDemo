package com.lcke.demo.utils.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: sadsa <br/>
 * Description: <br/>
 * date: 2020/1/9 20:40<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@RabbitListener(queues = {DirectConfig.DIRECT_QUEUE_NAME_1})
@Component("direct-receiver1")
public class DirectReceiver1 {
    @RabbitHandler
    public void handler(String content){
        System.out.println("Direct.Receiver1接收到：" + content);
    }
}