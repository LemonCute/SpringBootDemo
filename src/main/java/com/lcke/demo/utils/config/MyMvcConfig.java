package com.lcke.demo.utils.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:编写一个配置类，是WebMvcConfigurerAdapter类的子类，但是不能标注@EnableWebMvc注解。
 * 这样它既保留了所有的自动配置，也能使用自定义的扩展配置。 <br/>
 *官方文档告诉我们 Spring Boot 对于静态资源的映射目录是 /static , /public , /resources 以及 /META-INF/resource。
 * 除此之外其实还映射了 /webjars/** 到 classpath:/META-INF/resources/webjars
 * @author: smk<br       />
 * @date: 2019/12/25 14:04<br/>
 * © 2019 柠檬不萌香蕉不娇. All Rights Reserved. 版权所有.
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        logger.info("配置主页面跳转");
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        WebMvcConfigurer.super.addViewControllers(registry);
    }

    /**
     * 自定义JSON转换器
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //日期格式化
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        //处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON);
        // fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(fastMediaTypes);
        converter.setFastJsonConfig(fastJsonConfig);
        converters.add(converter);
    }

    /**
     * 添加自定义拦截器
     * .addPathPatterns("/**")  拦截的请求路径
     * .excludePathPatterns("/user"); 排除的请求路径
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user");
    }
}
////使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
//@Configuration
//public class MyMvcConfig implements WebMvcConfigurer {
//    /**
//     * 在java8以后，接口中可以添加使用default或者static修饰的方法，
//     * 在这里我们只讨论default方法，default修饰方法只能在接口中使用，
//     * 在接口种被default标记的方法为普通方法，可以直接写方法体。
//     */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        WebMvcConfigurer.super.addViewControllers(registry);
//        //浏览器发送/cay请求，会直接跳到success页面。
//        registry.addViewController("/").setViewName("/boot");
//    }
//}