package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drug {
    private Long id;

    private Long drugNumber;

    private String drugName;

    private String drugCategory;

    private Boolean recipeType;

    private Boolean packingUnit;

    private String drugSpec;

    private String drugPrice;

    private String drugValidity;

    private String drugVender;

    private Integer drugStock;

    private String drugUsage;

    private String remark;

    private Boolean targetDept;

    private Date createDate;

    private Date updateDate;
}