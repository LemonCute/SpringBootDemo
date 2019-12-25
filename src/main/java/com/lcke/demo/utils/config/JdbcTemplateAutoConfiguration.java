package com.lcke.demo.utils.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

/**
 * ClassName: jdbc <br/>
 * Description: <br/>
 * date: 2019/12/25 14:34<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@Configuration
@ConditionalOnClass({ DataSource.class, JdbcTemplate.class })
@ConditionalOnSingleCandidate(DataSource.class)
//在DataSourceAutoConfiguration自动配置类完成后再进行自动配置该类JdbcTemplateAutoConfiguration
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
public class JdbcTemplateAutoConfiguration {
    private final DataSource dataSource;
    public JdbcTemplateAutoConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    //创建一个JdbcTemplate的Bean,在使用的时候可以直接注入。
    @Bean
    @Primary
    @ConditionalOnMissingBean(JdbcOperations.class)
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(this.dataSource);
    }

    /**
     * 获得NamedParameterJdbcTemplate实例，在NamedParameterJdbcTemplate 构造器中直接传入JdbcTemplate的实例即可
     * NamedParameterJdbcTemplate nameJdbc = new NamedParameterJdbcTemplate(jdbcTemplate);
     * @return
     */
    @Bean
    @Primary
    @ConditionalOnMissingBean(NamedParameterJdbcOperations.class)
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(this.dataSource);
    }
}
