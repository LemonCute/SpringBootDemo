package com.lcke.demo.utils.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * classpath：只会到你的class路径中查找找文件;
 * classpath*：不仅包含class路径，还包括jar文件中(class路径)进行查找
 *
 * @Configuration 这个注解会在项目启动时加载下面这个类
 */
@Configuration
@ImportResource({"classpath*:config/applicationContext.xml","classpath:config/spring-task.xml"})
public class XmlConfigLoad {

    public XmlConfigLoad() {
        System.out.println("XmlConfigLoad容器启动初始化。。。");
    }

    /**
     *  @Bean 和  applicationContext.config
     *  <bean id="helloService" class="com.lcke.demo.SpringBootConfig"></bean>
     *  注解 应用法相同
     */
    @Bean
    public String helloSpringBean() {
        System.out.println("添加组件：helloSpringBean");
        return new String("helloSpringBean");
    }
}
