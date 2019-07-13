package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.DeptEmp;

public interface DeptEmpMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DeptEmp record);

    int insertSelective(DeptEmp record);

    DeptEmp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeptEmp record);

    int updateByPrimaryKey(DeptEmp record);
}