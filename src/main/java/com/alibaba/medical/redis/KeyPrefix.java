package com.alibaba.medical.redis;

/**
 * @ClassName KeyPrefix
 * @Description 缓存前缀接口
 * @Author panjing
 * @Date 2019/6/10 17:37
 * @Version 1.0
 **/
public interface KeyPrefix {
    int expireSeconds();

    String getPrefix();
}
