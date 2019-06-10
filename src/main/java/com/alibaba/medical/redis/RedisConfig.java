package com.alibaba.medical.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName RedisConfig
 * @Description Redis配置文件
 * @Author panjing
 * @Date 2019/6/10 17:34
 * @Version 1.0
 **/
@Data
@Component
// 读取配置文件信息
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {
    private String host;
    private int port;
    private int timeout;//秒
    private String password;
    private int poolMaxTotal;
    private int poolMaxIdle;
    private int poolMaxWait;//秒
}
