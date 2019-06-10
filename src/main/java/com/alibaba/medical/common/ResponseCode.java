package com.alibaba.medical.common;

/**
 * @ClassName ResponseCode
 * @Description 服务器响应状态码类
 * @Author panjing
 * @Date 2019/6/10 17:31
 * @Version 1.0
 **/
public enum ResponseCode {
    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROR"),
    NEED_LOGIN(10, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }
}
