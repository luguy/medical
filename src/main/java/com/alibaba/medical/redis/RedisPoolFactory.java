package com.alibaba.medical.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName RedisPoolFactory
 * @Description Jedis工厂
 * @Author panjing
 * @Date 2019/6/10 17:35
 * @Version 1.0
 **/
@Component
public class RedisPoolFactory {
    @Autowired
    RedisConfig redisConfig;

    @Bean
    public JedisPool JedisPoolFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        jedisPoolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        jedisPoolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait()*1000);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,
                redisConfig.getHost(),
                redisConfig.getPort(),
                redisConfig.getTimeout()*1000,
                redisConfig.getPassword(), 0);
        return jedisPool;
    }
}
