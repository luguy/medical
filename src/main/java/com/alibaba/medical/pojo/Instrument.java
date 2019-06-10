package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instrument {
    private Long id;

    private Long insNumber;

    private String insName;

    private Integer insStock;

    private Integer insUsed;

    private String insLocation;

    private Boolean insStatus;

    private Date buyDate;

    private Date destroyDate;

    private String destroyReason;

    private Long deptId;

    private String remark;

}