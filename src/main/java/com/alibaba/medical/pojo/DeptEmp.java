package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptEmp {
    private Long id;

    private String empName;

    private Boolean empStatus;

    private String empAccount;

    private Boolean empGender;

    private String empBirthday;

    private Long empNumber;

    private String empPhone;

    private String officePhone;

    private String empEmail;

    private String empAddress;

    private String empFunction;

    private Boolean empIdentity;

    private String empArea;

    private String remark;

    private Long deptId;

    private Date createDate;

    private Date updateDate;

}