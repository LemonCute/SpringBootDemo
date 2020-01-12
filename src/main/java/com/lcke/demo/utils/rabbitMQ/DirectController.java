package com.lcke.demo.utils.rabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: sdsadas <br/>
 * Description: <br/>
 * date: 2020/1/9 20:41<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@RestController
public class DirectController {
    private static final Logger logger = LoggerFactory.getLogger(DirectController.class);
    @Autowired
    @Qualifier("direct-sender")
    private DirectSender sender;

    @RequestMapping("/direct")
    public String hello(@RequestParam(defaultValue = "1") int selector){
        logger.info("参数selector：" + selector);
        sender.send(selector);
        return "success";
    }
}