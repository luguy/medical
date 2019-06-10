package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutDoctor {
    private Long id;

    private Long outdtNumber;

    private Long prisonerNumber;

    private String outType;

    private Date outDate;

    private String outDoctor;

    private String implementStatus;

    private String remake;

}