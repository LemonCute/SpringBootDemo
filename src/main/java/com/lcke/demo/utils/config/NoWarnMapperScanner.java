package com.lcke.demo.utils.config;

import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Set;

/**
 * ClassName: sasadsadsa <br/>
 * Description: <br/>
 * date: 2020/1/13 17:37<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@Configuration
public class NoWarnMapperScanner{ //extends ClassPathMapperScanner {

//
//    public NoWarnMapperScanner(BeanDefinitionRegistry registry) {
//        super(registry);
//    }
//
//    @Override
//    public Set<BeanDefinitionHolder> doScan(String... basePackages) {
//        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
//
//        if (beanDefinitions.isEmpty()) {
//
//        } else {
//            processBeanDefinitions(beanDefinitions);
//        }
//
//        return beanDefinitions;
//    }
}
