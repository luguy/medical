package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InRepository {
    private Long id;

    private Long inrepId;

    private Date createDate;

    private String applicant;

    private Date applyDate;

    private String applyTitle;

    private String applyType;

    private String applyCause;

    private String applyContent;

    private String approver;

    private Date approveDate;

    private String approveResult;

    private String remark;

    private Boolean status;

    private Boolean clearing;

}