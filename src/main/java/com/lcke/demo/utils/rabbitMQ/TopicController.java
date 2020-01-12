package com.lcke.demo.utils.rabbitMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.listener.Topic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ssadsasa <br/>
 * Description: <br/>
 * date: 2020/1/9 20:59<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    @Qualifier("topic-sender")
    private TopicSender sender;

    @RequestMapping("/send")
    public String send(String routeKey){
        sender.send(routeKey);
        return "success";
    }
}
