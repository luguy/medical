package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private Long id;

    private String deptName;

    private Boolean deptStatus;

    private Long deptNumber;

    private String deptFunction;

    private String remark;

    private Date createDate;

    private Date updateDate;

}