package com.lcke.demo;

/**
 * ClassName: DemoTest <br/>
 * Description: <br/>
 * date: 2019/12/25 15:15<br/>
 *
 * @author smk<br   />
 * @since JDK 1.8
 */


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class DemoApplicationTests {
    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads1() {
    }

    @Test
    public void contextLoads() {
        //日志的级别：
        //由低到高：trace < debug < info < warn < error
        //可以调整输出的日志级别，日志就只会输出大于或等于当前设置的日志级别的所有日志信息
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");

        //Spring Boot默认的日志级别是info
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");

        System.out.println("jdbcTemplate = " + jdbcTemplate);
    }

}


