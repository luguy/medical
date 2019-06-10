package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private Long id;

    private Long recipeNumber;

    private Long sickNumber;

    private String diagnose;

    private Long diagnoseNumber;

    private Boolean status;

    private String doctorName;

    private String remark;

    private Date createDate;

    private Date recipeSubmitDate;

    private Date doctorDealDate;

}