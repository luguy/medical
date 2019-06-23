package com.alibaba.medical.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;

/**
 * @ClassName MD5Util
 * @Description MD5工具类
 * @Author panjing
 * @Date 2019/6/10 17:40
 * @Version 1.0
 **/
public class MD5Util {

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";

    /**
     * MD5+salt 防止数据库被脱库
     * //todo 可以将扩展为两次MD5
     * @param inputPass
     * @return
     */
    public static String inputPassToDBPass(String inputPass){
        String str = salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(3) + salt.charAt(5);
        return md5(str);
    }

    public static void main(String[] args) {
        String admin = inputPassToDBPass("admin");
        System.out.println(admin);
        System.out.println(new Date().getTime());
    }
}
