package com.lcke.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Properties;

/**
 * @SpringBootApplication 来标注一个主程序类，说明这是一个SpringBoot应用
 * @SpringBootApplication 注解是一个便利的注解，它包含了以下几个注解。
 * @Configuration 定义配置类。
 * @EnableAutoConfiguration 开启自动配置。
 * @EnableWebMvc 标记为 web应用程序。
 * @ComponentScan 组件扫描。
 * <p>
 * https://docs.spring.io/spring-boot/docs/1.5.12.RELEASE/reference/htmlsingle/#boot-features-external-config
 * ##@SpringBootConfiguration
 * 读取配置文件，配置文件的路径是当前根目录(src/main/resources/application.yml等)
 * ##EnableAutoConfiguration
 * 开启自动配置，扫描当前的所有依赖的jar包，发现新的依赖出现将会将会根据依赖完各种自动配置（扫描start_web，自动配置内置tomcat默认路径、端口；依赖了rabbitmq，自动配置rabbitTemble）
 * ##ComponetScan
 * 属于Spring框架(@Component,@Service,@Controller,@Repository,@Entity)，扫描范围默认情况下是启动类坐在的同名包及其子孙包
 * @EnableAutoConfiguration
 * @ComponentScan
 * @SpringBootConfiguration </p>
 * @MapperScan({"com.kfit.*.mapper","org.kfit.*.mapper"})
 * @MapperScan({"com.kfit.demo","com.kfit.user"})
 * 在SpringBootApplication上使用@ServletComponentScan注解后，
 * //配置druid必须加的注解，如果不加，访问页面打不开，
 *  * Servlet、Filter、Listener可以直接通过@WebServlet、@WebFilter、@WebListener注解自动注册，无需其他代码。
 * // filter和servlet、listener之类的需要单独进行注册才能使用，spring boot里面提供了该注解起到注册作用
 * //必须加这个，不加报错，如果不加，也可以在每个mapper上添加@Mapper注释
 *
 * @MapperScan({"com.lcke.demo.dao"})
 * //开启spring缓存
 * @EnableCaching
 * @EnableCaching：在主入口类上添加该注解，用于开启缓存；
 * @CacheConfig：标注在类上，表示当前类使用的缓存组件中的key为该注解指定的cacheNames/value，当该注解指定了cacheNames/value之后，@Cacheable上就无需再使用cacheNames/value了；
 * @Cacheable：将方法的结果进行缓存；
 * cacheNames/value：缓存组件的名字；
 * @ServletComponentScan 扫描Servlet,Filter,Listener 添加到容器
 */
//@EnableAdminServer
@SpringBootApplication
@ServletComponentScan
@EnableCaching
//Dao层必须加这个，不加报错，如果不加，也可以在每个mapper上添加@Mapper注释
@MapperScan({"com.lcke.demo.dao"})
public class DemoApplication {
    //Spring应用启动
    public static void main(String[] args) {
        /**
         * 加载或修改配置启动
         */
        SpringApplication application = new SpringApplication(DemoApplication.class);
        //禁止通过命令行参数修改默认配置属性
        application.setAddCommandLineProperties(false);
        //加载指定的配置文件, getClassLoader() 读取到 class 路径下的文件
        InputStream is = DemoApplication.class.getClassLoader().getResourceAsStream("config/app.properties");
        Properties properties = new Properties();
        if (null == is) {
            System.err.println(LocalDateTime.now() + " [ SpringApplication ] 启动配置文件有误，请检查！！");
        } else {
            try {
                properties.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //设置属性
        application.setDefaultProperties(properties);
        //启动
        application.run(args);

        /**
         * 直接启动
         */
//        SpringApplication.run(DemoApplication.class, args);
    }

}
