package com.lcke.demo;

/**
 * ClassName: DemoTest <br/>
 * Description: <br/>
 * date: 2019/12/25 15:15<br/>
 *
 * @author smk<br   />
 * @since JDK 1.8
 */


import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    private URL base;
    @Test
    void contextLoads1() {
    }
    @Before("")
    public void setup() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }
    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        assert (response.getBody().equals("Greetings from Spring Boot!"));
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


