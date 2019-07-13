package com.alibaba.medical.util;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName JsonUtil
 * @Description JSON工具类
 * @Author panjing
 * @Date 2019/6/10 17:39
 * @Version 1.0
 **/
public class JsonUtil {

    /**
     * 将Bean转换为String
     * @param value
     * @param <T>
     * @return
     */
    public static <T> String beanToString(T value) {
        if(value == null){
            return null;
        }
        Class<?> clazz = value.getClass();
        if(clazz == int.class || clazz == Integer.class){
            return String.valueOf(value);
        }else if(clazz == String.class){
            return (String) value;
        }else if(clazz == long.class || clazz == Long.class){
            return String.valueOf(value);
        }else {
            return JSON.toJSONString(value);
        }
    }

    /**
     * 将String转换为Bean
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T stringToBean(String str, Class<T> clazz) {
        if(str == null || str.length() <= 0 || clazz == null){
            return null;
        }
        if(clazz == int.class || clazz == Integer.class){
            return (T) Integer.valueOf(str);
        }else if(clazz == String.class){
            return (T) str;
        }else if(clazz == long.class || clazz == Long.class){
            return (T) Long.valueOf(str);
        }else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

}
