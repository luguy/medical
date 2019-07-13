package com.alibaba.medical.vo;

import lombok.Data;

/**
 * @ClassName DeptVO
 * @Description TODO
 * @Author panjing
 * @Date 19-7-13 下午10:44
 * @Version 1.0
 **/
@Data
public class DeptVO {
    private Long id;

    private String deptName;

    private Boolean deptStatus;

    private Long deptNumber;

    private String deptFunction;

    private String remark;
}
