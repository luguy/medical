package com.alibaba.medical.vo;

import lombok.Data;

/**
 * @author luguy
 * @date 2019/7/13 - 20:33
 */
@Data
public class DrugVO {

    private Long id;

    private Long drugNumber;

    private String drugName;

    private String drugCategory;

    private String recipeType;

    private String packingUnit;

    private String drugSpec;

    private String drugPrice;

    private String drugValidity;

    private String drugVender;

    private Integer drugStock;

    private String drugUsage;

    private String remark;

    private String targetDept;

    /*库存预警*/
    private String stockWarning="正常";

    /*有效期预警*/
    private String validityWarning="正常";


}
