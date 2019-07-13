package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyDoctor {
    private Long id;

    private Long dailyNumber;

    private Long prisonerNumber;

    private String dailyProject;

    private String dailyResult;

    private String dailyDoctor;

    private Date createDate;

    private String dailyDescribe;

    private String remake;

}