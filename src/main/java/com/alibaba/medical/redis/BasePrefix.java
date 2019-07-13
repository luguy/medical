package com.alibaba.medical.redis;

/**
 * @ClassName BasePrefix
 * @Description 缓存前缀基础类
 * @Author panjing
 * @Date 2019/6/10 17:38
 * @Version 1.0
 **/
public abstract class BasePrefix implements KeyPrefix {

    // 默认0代表永不过期
    private int expireSeconds;

    private String prefix;


    public BasePrefix(String prefix){
        this(0, prefix);
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }
}
