package com.alibaba.medical.vo;

import lombok.Data;

/**
 * @ClassName RoleVO
 * @Description TODO
 * @Author panjing
 * @Date 2019/6/22 21:25
 * @Version 1.0
 **/
@Data
public class RoleVO {
    private Long id;

    private String username;

    private String password;

    private int type;

}
