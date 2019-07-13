package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prison {
    private Long id;

    private Long prisonId;

    private Long prisonNumber;

    private String prisonType;

    private String prisonName;

    private Long doctorNumber;

    private Long number;

    private Boolean status;

    private Date createDate;

    private String remark;

}