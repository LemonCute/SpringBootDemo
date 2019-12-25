package com.lcke.demo.utils.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Description:编写一个配置类，是WebMvcConfigurerAdapter类的子类，但是不能标注@EnableWebMvc注解。
 * 这样它既保留了所有的自动配置，也能使用自定义的扩展配置。 <br/>
 *
 * @author: smk<br   />
 * @date: 2019/12/25 14:04<br/>
 * © 2019 柠檬不萌香蕉不娇. All Rights Reserved. 版权所有.
 */

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * 在java8以后，接口中可以添加使用default或者static修饰的方法，
     * 在这里我们只讨论default方法，default修饰方法只能在接口中使用，
     * 在接口种被default标记的方法为普通方法，可以直接写方法体。
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
        //浏览器发送/cay请求，会直接跳到success页面。
        registry.addViewController("/cay").setViewName("success");
    }
}