package com.lcke.demo;

import com.lcke.demo.utils.rabbitMQ.Sender;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * ClassName: xaasaS <br/>
 * Description: <br/>
 * date: 2020/1/8 0:06<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRabbitmqTest {

    @Autowired
    private Sender sender;

    @Test
    public void test(){
        sender.send();
    }
}