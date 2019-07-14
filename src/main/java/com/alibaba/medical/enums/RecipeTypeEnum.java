package com.alibaba.medical.enums;

import lombok.Getter;

/**
 * @author luguy
 * @date 2019/6/12 - 22:21
 */

//'处方类型，0-自费，1-公费'
@Getter
public enum RecipeTypeEnum implements CodeEnum{

    ONESELF(0, "自费"),
    PUBLIC(1, "公费"),
    ;

    private Integer code;

    private String message;

    RecipeTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }



}
