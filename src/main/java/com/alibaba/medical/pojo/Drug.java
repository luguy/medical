package com.alibaba.medical.pojo;

import com.alibaba.medical.enums.PackingUnitEnum;
import com.alibaba.medical.enums.RecipeTypeEnum;
import com.alibaba.medical.enums.TargetDeptEnum;
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

    private Integer recipeType= RecipeTypeEnum.ONESELF.getCode();

    private Integer packingUnit= PackingUnitEnum.BOX.getCode();

    private String drugSpec;

    private String drugPrice;

    private String drugValidity;

    private String drugVender;

    private Integer drugStock;

    private String drugUsage;

    private String remark;

    private Integer targetDept= TargetDeptEnum.PHARMACY.getCode();

    private Date createDate;

    private Date updateDate;
}