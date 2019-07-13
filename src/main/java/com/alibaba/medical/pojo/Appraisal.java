package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appraisal {
    private Long id;

    private Long appraisalNumber;

    private Long prisonerNumber;

    private String appraisalType;

    private String submitter;

    private String confirmer;

    private Date submitDate;

    private Date confiremDate;

    private String appraisalResult;

    private String remake;

}