package com.lcke.demo.utils.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ClassName: dasdas <br/>
 * Description: <br/>
 * date: 2020/1/9 20:39<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@Component("direct-sender")
public class DirectSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(Integer selector) {
        String content = "hello，我是%d号，当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String routeKey = "";
        if (selector.intValue() == 1) {
            content = String.format(content, 1);
            routeKey = DirectConfig.ROUTE_KEY_1;
        } else if (selector.intValue() == 2) {
            content = String.format(content, 2);
            routeKey = DirectConfig.ROUTE_KEY_2;
        }
        amqpTemplate.convertAndSend(DirectConfig.DIRECT_EXCHANGE_NAME, routeKey, content);
    }
}