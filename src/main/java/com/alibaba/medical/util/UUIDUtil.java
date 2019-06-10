package com.alibaba.medical.util;

import java.util.UUID;

/**
 * @ClassName UUIDUtil
 * @Description UUID工具类
 * @Author panjing
 * @Date 2019/6/10 17:43
 * @Version 1.0
 **/
public class UUIDUtil {
    public static String uuid(){
        // 原生的UUID中间带”-“
        return UUID.randomUUID().toString().replace("-", "");
    }
}
