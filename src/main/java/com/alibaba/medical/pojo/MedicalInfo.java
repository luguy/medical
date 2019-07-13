package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalInfo {
    private Long id;

    private String type;

    private String name;

    private String editor;

    private Date editorDate;

    private String remark;

}