package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentOutRepository {
    private Long id;

    private Long outrepId;

    private Date createDate;

    private String outType;

    private String outPeople;

    private String deptName;

    private String recipient;

    private Boolean status;

    private String remark;

}