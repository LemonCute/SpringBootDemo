package com.lcke.demo.utils.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ClassName: dsfdsfsd <br/>
 * Description: <br/>
 * date: 2020/1/9 20:18<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@Component(value = "sender")
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String content = "hello : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        amqpTemplate.convertAndSend("hello", content);
    }
}
