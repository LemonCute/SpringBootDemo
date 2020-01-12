package com.lcke.demo.utils.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: dfdsfsdsdfsd <br/>
 * Description: <br/>
 * date: 2020/1/9 20:22<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@RabbitListener(queues = {FanoutConfig.FANOUT_QUEUE_NAME_2})
@Component("fanout-receiver2")
public class FanoutReceiver2 {
    @RabbitHandler
    public void handler(String content){
        System.out.println("Fanout.Receiver2接收到：" + content);
    }
}