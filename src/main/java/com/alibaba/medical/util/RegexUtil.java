package com.alibaba.medical.util;

import java.util.regex.Pattern;

/**
 * @ClassName RegexUtil
 * @Description 正则表达式工具类
 * @Author panjing
 * @Date 19-7-12 下午9:40
 * @Version 1.0
 **/
public class RegexUtil {

    /**
     * 判断类型是否是2-6之间的数字
     * @param type
     * @return
     */
    public static boolean is2To6Number(String type){
        String regex = "^[2-6]$";
        return Pattern.matches(regex, type);
    }

    /**
     * 判断类型是否是3-6之间的数字
     * @param type
     * @return
     */
    public static boolean is3To6Number(String type){
        String regex = "^[3-6]$";
        return Pattern.matches(regex, type);
    }

}
