package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentInRepository {
    private Long id;

    private Long inrepId;

    private Date createDate;

    private String applicant;

    private Date applyDate;

    private String applyTitle;

    private String applyCause;

    private String insName;

    private Integer quantity;

    private String approver;

    private Date approveDate;

    private String approveResult;

    private String remark;

    private Boolean status;

}