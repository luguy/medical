package com.alibaba.medical.enums;

import lombok.Getter;

/**
 * @author luguy
 * @date 2019/7/13 - 16:03
 */
//'状态，0-待审核，1-已审核'
@Getter
public enum AuditStatusEnum implements CodeEnum{

    AUDIT_NO(0, "待审核"),
    AUDIT_YES(1, "已审核"),
    ;

    private Integer code;

    private String message;

    AuditStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
