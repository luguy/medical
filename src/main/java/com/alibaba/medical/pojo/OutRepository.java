package com.alibaba.medical.pojo;

import com.alibaba.medical.enums.AuditStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutRepository {
    private Long id;

    private Long outrepId;

    private Date createDate;

    private String outType;

    private String outPeople;

    private String deptName;

    private String recipient;

    private Integer status= AuditStatusEnum.AUDIT_NO.getCode();

    private String remark;

}