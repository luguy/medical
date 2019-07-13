package com.alibaba.medical.redis;

import com.alibaba.medical.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @ClassName RedisService
 * @Description Redis服务类
 * @Author panjing
 * @Date 2019/6/10 17:36
 * @Version 1.0
 **/
@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    /**
     * 从缓存中取对象
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            String str = jedis.get(realKey);
            T t = JsonUtil.stringToBean(str, clazz);
            return t;
        }finally {
            returnToPool(jedis);
        }
    }

    /**
     * 向缓存中放入对象
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(KeyPrefix prefix, String key, T value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = JsonUtil.beanToString(value);
            if(str == null || str.length() <= 0){
                return false;
            }
            //生成真正的key
            String realKey = prefix.getPrefix() + key;
            int expireSeconds = prefix.expireSeconds();
            if(expireSeconds <= 0){
                jedis.set(realKey, str);
            }else{
                jedis.setex(realKey, expireSeconds, str);
            }
            return true;
        }finally {
            returnToPool(jedis);
        }
    }

    /**
     * 删除缓存对象
     * @param prefix
     * @param key
     * @return
     */
    public  boolean delete(KeyPrefix prefix, String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            long resultCount = jedis.del(realKey);
            return resultCount > 0;
        }finally {
            returnToPool(jedis);
        }
    }

    /**
     * 判断对象是否存在
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> boolean exists(KeyPrefix prefix, String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            boolean exists = jedis.exists(realKey);
            return exists;
        }finally {
            returnToPool(jedis);
        }
    }

    /**
     * 增加一个值
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> long incr(KeyPrefix prefix, String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.incr(realKey);
        }finally {
            returnToPool(jedis);
        }
    }

    /**
     * 减少一个值
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> long decr(KeyPrefix prefix, String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.decr(realKey);
        }finally {
            returnToPool(jedis);
        }
    }

    /**
     * 将jedis连接返回到连接池里
     * @param jedis
     */
    private void returnToPool(Jedis jedis) {
        if(jedis != null){
            jedis.close();
        }
    }

}
