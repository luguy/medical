package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Penalty {
    private Long id;

    private Long prisonerNumber;

    private String prisonerPrison;

    private String charge;

    private String originalSentence;

    private String remainingSentence;

    private String medicalParole;

    private Date createDate;

    private String remake;

}