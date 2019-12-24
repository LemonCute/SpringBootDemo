package com.lcke.demo.utils;

import com.alibaba.druid.support.http.StatViewServlet;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * springboot继承druid监控
 */
@Component
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.druid.druid")
public class DruidConfiguration{
    // 初始化大小，最小，最大
    private int initialSize = 5;
    private int minIdle = 1;
    private int maxActive = 50;
    // 配置获取连接等待超时的时间
    private int maxWait = 60000;
    // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    private int timeBetweenEvictionRunsMillis = 60000;
    // 配置一个连接在池中最小生存的时间，单位是毫秒
    private int minEvictableIdleTimeMillis = 300000;
    private String validationQuery = "SELECT 1 FROM DUAL";
    private Boolean testWhileIdle = true;
    private Boolean testOnBorrow = false;
    private Boolean testOnReturn = false;
    // 打开PSCache，并且指定每个连接上PSCache的大小
    private Boolean poolPreparedStatements = false;
    //private int maxPoolPreparedStatementPerConnectionSize=20
    // 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
    private String filters = "stat,wall,log4j";
    // 通过connectProperties属性来打开mergeSql功能；慢SQL记录
    private String connectionProperties = "druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000";
    // 请勿配置timeBetweenLogStatsMillis 会定时输出日志 并导致统计的sql清零
    //spring.datasource.druid.timeBetweenLogStatsMillis=20000
    // 合并多个DruidDataSource的监控数据
    private Boolean useGlobalDataSourceStat = true;

    // 配置数据库的基本链接信息
    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")    //可以在application.properties中直接导入
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
    }

    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //白名单：
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的即提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny", "192.168.1.100");
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("admin", "admin");
        servletRegistrationBean.addInitParameter("root", "123456");
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

//    @Bean
//    public FilterRegistrationBean statFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//        //添加过滤规则.
//        filterRegistrationBean.addUrlPatterns("/*");
//        //添加不需要忽略的格式信息.
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }

    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }



    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
        return bean;
    }
}
