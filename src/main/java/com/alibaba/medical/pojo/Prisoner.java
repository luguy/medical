package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prisoner {
    private Long id;

    private Long prisonerNumber;

    private String prisonerPrison;

    private Long fileNumber;

    private String prisonerName;

    private Boolean prisonerGender;

    private String prisonerBirthday;

    private String prisonAddress;

    private String contacts;

    private String contactsRelation;

    private String contactsPhone;

    private Date createDate;

    private String recentPerformance;

    private String familyStatus;

    private String attention;

    private String characterStatus;

}