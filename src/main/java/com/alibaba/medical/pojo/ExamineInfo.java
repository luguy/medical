package com.alibaba.medical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamineInfo {
    private Long id;

    private String type;

    private String name;

    private String symptom;

    private String flow;

    private String attention;

    private String meaning;

    private String remark;

}