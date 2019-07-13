package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentBill {
    private Long id;

    private Long insBillNumber;

    private String applyTitle;

    private String applicant;

    private Date applyDate;

    private String applyCause;

    private String approver;

    private Date approveDate;

    private String applyContent;

    private String approveResult;

    private Boolean status;

    private String remark;

}