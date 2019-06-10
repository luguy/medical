package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Long id;

    private String username;

    private String password;

    private Boolean type;

    private Date createDate;

    private Date lastLoginDate;

}