package com.lcke.demo.utils.config;

/**
 * ClassName: sadsasadsadsadsadas <br/>
 * Description: <br/>
 * date: 2020/1/9 22:10<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */

import com.lcke.demo.utils.MVC3Com.MyFilter;
import com.lcke.demo.utils.MVC3Com.MyListener;
import com.lcke.demo.utils.MVC3Com.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 在这里注册Servlet Filter Listener 或者使用 @ServletComponentScan
 *
 * @Author niujinpeng
 * @Date 2019/1/24 16:30
 */
@Configuration
public class WebCoreConfig {
//     可以使用配置类，注入 Bean
//    @Bean
//    public ServletRegistrationBean myServlet() {
//        return new ServletRegistrationBean<>(new MyServlet());
//    }
//
//    @Bean
//    public FilterRegistrationBean myFitler() {
//        return new FilterRegistrationBean<>(new MyFilter());
//    }
//
//    @Bean
//    public ServletListenerRegistrationBean myListener() {
//        return new ServletListenerRegistrationBean(new MyListener());
//    }

}