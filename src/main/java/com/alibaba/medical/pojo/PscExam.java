package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PscExam {
    private Long id;

    private Long pscNumber;

    private Long prisonerNumber;

    private String anamnesis;

    private String immediateMedical;

    private String objExam;

    private String preliminaryConclusion;

    private String mainDoctor;

    private Date createDate;

    private String remake;

    private Long doctorNumber;

    private Date examDate;

    private String examProject;

    private String examResult;

}