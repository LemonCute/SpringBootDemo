package com.lcke.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.time.Duration;

/**
 * ClassName: sdsadas <br/>
 * Description: <br/>
 * date: 2019/12/27 0:10<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
public class MyRedisConnectionFactory {
    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Value("${spring.redis.timeout}")
    private int redisTimeout;

    @Value("${spring.redis.password}")
    private String redisAuth;

    @Value("${spring.redis.database}")
    private int redisDb;

    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private int maxWait;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;

//    @Bean
    public RedisConnectionFactory connectionFactory() {
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        poolConfig.setMaxTotal(maxActive);
//        poolConfig.setMaxIdle(maxIdle);
//        poolConfig.setMaxWaitMillis(maxWait);
//        poolConfig.setMinIdle(minIdle);
//        poolConfig.setTestOnBorrow(true);
//        poolConfig.setTestOnReturn(false);
//        poolConfig.setTestWhileIdle(true);
//        JedisClientConfiguration clientConfig =
//                JedisClientConfiguration.builder().usePooling().poolConfig(poolConfig).and().readTimeout(Duration.ofMillis(redisTimeout)).build();
//        // 单点redis
//        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
//        // 哨兵redis
//        // RedisSentinelConfiguration redisConfig = new RedisSentinelConfiguration();
//        // 集群redis
//        // RedisClusterConfiguration redisConfig = new RedisClusterConfiguration();
//        redisConfig.setHostName(redisHost);
//        redisConfig.setPassword(RedisPassword.of(redisAuth));
//        redisConfig.setPort(redisPort);
//        redisConfig.setDatabase(redisDb);
//        return new JedisConnectionFactory(redisConfig, clientConfig);
        return null;
    }

}
