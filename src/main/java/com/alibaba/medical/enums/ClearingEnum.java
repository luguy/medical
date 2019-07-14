package com.alibaba.medical.enums;

import lombok.Getter;

/**
 * @author luguy
 * @date 2019/7/13 - 16:20
 */
@Getter
public enum ClearingEnum implements CodeEnum {


    CLEARING_NO(0, "未结算"),
    CLEARING_YES(1, "已结算"),
    ;

    private Integer code;

    private String message;

    ClearingEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
