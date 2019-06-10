package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.Hospitalization;

public interface HospitalizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Hospitalization record);

    int insertSelective(Hospitalization record);

    Hospitalization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Hospitalization record);

    int updateByPrimaryKey(Hospitalization record);
}