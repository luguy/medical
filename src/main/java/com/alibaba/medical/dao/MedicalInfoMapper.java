package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.MedicalInfo;

public interface MedicalInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MedicalInfo record);

    int insertSelective(MedicalInfo record);

    MedicalInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MedicalInfo record);

    int updateByPrimaryKey(MedicalInfo record);
}