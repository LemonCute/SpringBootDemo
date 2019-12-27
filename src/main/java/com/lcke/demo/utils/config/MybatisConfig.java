package com.lcke.demo.utils.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: sdasdas <br/>
 * Description: <br/>
 * date: 2019/12/26 22:51<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@Configuration
public class MybatisConfig{
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){

        return configuration -> {
                configuration.setMapUnderscoreToCamelCase(true);
                configuration.setCacheEnabled(true);

        };
    }
}