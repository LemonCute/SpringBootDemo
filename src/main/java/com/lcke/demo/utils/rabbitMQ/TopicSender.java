package com.lcke.demo.utils.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ClassName: dasdassa <br/>
 * Description: <br/>
 * date: 2020/1/9 20:57<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@Component("topic-sender")
public class TopicSender {
    private static final String TOPIC_PREFIX = "topic.";

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String selector){
        String content = "hello，当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        amqpTemplate.convertAndSend(TopicConfig.TOPIC_EXCHANGE_NAME, TOPIC_PREFIX + selector, content);
    }
}
