package com.alibaba.medical.enums;

import lombok.Getter;

/**
 * @EnumName RoleEnum
 * @Description 角色权限的枚举
 * @Author panjing
 * @Date 19-7-12 下午9:11
 * @Version 1.0
 **/
@Getter
public enum RoleEnum {
    ADMINISTRATOR(1, "系统管理员"),
    LEADER(2, "院领导"),
    DOCTOR(3, "医生"),
    DEPARTMENT(4, "职能科室"),
    POLICEMEN(5, "狱区干警"),
    SUPPERTSTAFF(6, "辅助人员");

    private Integer code;
    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
