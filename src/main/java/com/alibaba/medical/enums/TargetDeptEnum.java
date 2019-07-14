package com.alibaba.medical.enums;

import lombok.Getter;

/**
 * @author luguy
 * @date 2019/7/13 - 16:13
 */
@Getter
public enum TargetDeptEnum implements CodeEnum{

    PHARMACY(0, "药房"),
    INPATIENT(1, "住院部"),
    ;

    private Integer code;

    private String message;

    TargetDeptEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
