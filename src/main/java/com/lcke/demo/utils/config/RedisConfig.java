package com.lcke.demo.utils.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * redis配置类
 *
 * @author shenmingkai
 * @date 2019年12月27日
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    /**
     * 自定义生成key的规则
     */
    @Override
    public KeyGenerator keyGenerator() {
        return (obj, method, objects) -> {
            //格式化缓存key字符串
            StringBuilder sb = new StringBuilder();
            //追加类名
            sb.append(obj.getClass().getName());
            //追加方法名
            sb.append(method.getName());
            //遍历参数并且追加
            for (Object object : objects) {
                sb.append(object.toString());
            }
            System.out.println("调用Redis缓存Key : " + sb.toString());
            return sb.toString();
        };
    }

    /**
     * 采用RedisCacheManager作为缓存管理器
     * @param connectionFactory
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheManager redisCacheManager = RedisCacheManager.create(connectionFactory);
        return  redisCacheManager;
    }

    /**
     * 增强  RedisTemplate
     * 如果要在代码中使用RedisTemplate，那么配完上面的就已经可以用了，
     * 不过RedisTemplate默认只能支持RedisTemplate<String,String>形式的，
     * 也就是key-value只能是字符串，不能是其他对象。
     * @param factory
     * @return
     */

//    @Bean({"redisTemplate","stringRedisTemplate"})
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//        template.setConnectionFactory(factory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        // key采用String的序列化方式
//        template.setKeySerializer(stringRedisSerializer);
//        // hash的key也采用String的序列化方式
//        template.setHashKeySerializer(stringRedisSerializer);
//        // value序列化方式采用jackson
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        // hash的value序列化方式采用jackson
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//
//        template.afterPropertiesSet();
//        return template;
//    }

    @Bean({"redisTemplate","stringRedisTemplate"})
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);

        //JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        // 设置值（value）的序列化采用FastJsonRedisSerializer。
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
        // 设置键（key）的序列化采用StringRedisSerializer。
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();

        template.afterPropertiesSet();
        return template;
    }
}
