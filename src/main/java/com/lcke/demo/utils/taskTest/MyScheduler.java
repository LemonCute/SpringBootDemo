package com.lcke.demo.utils.taskTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ClassName: fsdas <br/>
 * Description: <br/>
 * date: 2019/12/26 23:07<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
public class MyScheduler{
    public void print(){
        System.out.println("MyScheduler：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
    }
}
