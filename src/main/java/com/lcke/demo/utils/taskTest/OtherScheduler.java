package com.lcke.demo.utils.taskTest;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ClassName: asdasdasda <br/>
 * Description: <br/>
 * date: 2019/12/26 23:21<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@Component
public class OtherScheduler{
    @Scheduled(cron="0/40 0/5 * * * ?")
    public void show(){
        System.out.println("OtherScheduler：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
    }
}
