package com.alibaba.medical.enums;

import lombok.Getter;

/**
 * @author luguy
 * @date 2019/7/13 - 16:09
 */
@Getter
public enum PackingUnitEnum implements CodeEnum{


    BOX(0, "盒"),
    BOTTLE(1, "瓶"),
    ;

    private Integer code;

    private String message;

    PackingUnitEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }




}
