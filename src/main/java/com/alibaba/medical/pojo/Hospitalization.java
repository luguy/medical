package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospitalization {
    private Long id;

    private Long hospitalNumber;

    private Long prisonerNumber;

    private String hospitalResult;

    private Date startDate;

    private Date endDate;

    private String mainDoctor;

    private String wardType;

    private String finalConclusion;

    private String remake;

}