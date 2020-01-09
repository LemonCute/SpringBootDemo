package com.lcke.demo.utils.config;




import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: dvdsfdsfd <br/>
 * Description: <br/>
 * date: 2020/1/7 23:53<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello", true); //队列持久
    }
}