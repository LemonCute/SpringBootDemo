package com.lcke.demo.utils.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: sdsdas <br/>
 * Description: <br/>
 * date: 2020/1/9 20:41<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@RabbitListener(queues = {DirectConfig.DIRECT_QUEUE_NAME_2})
@Component("direct-receiver2")
public class DirectReceiver2 {
    @RabbitHandler
    public void handler(String content){
        System.out.println("Direct.Receiver2接收到：" + content);
    }
}