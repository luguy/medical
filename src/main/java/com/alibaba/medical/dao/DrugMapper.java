package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.Drug;

public interface DrugMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Drug record);

    int insertSelective(Drug record);

    Drug selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Drug record);

    int updateByPrimaryKey(Drug record);
}