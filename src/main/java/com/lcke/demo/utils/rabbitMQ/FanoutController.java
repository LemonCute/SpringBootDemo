package com.lcke.demo.utils.rabbitMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: asdasdas <br/>
 * Description: <br/>
 * date: 2020/1/9 20:22<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@RestController
public class FanoutController {
    @Autowired
    @Qualifier("fanout-sender")
    private Sender sender;

    @RequestMapping("/fanout")
    public String hello(String name){
        sender.send(name);
        return "success";
    }
}