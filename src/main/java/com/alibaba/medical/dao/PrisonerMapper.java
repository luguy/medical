package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.Prisoner;

public interface PrisonerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Prisoner record);

    int insertSelective(Prisoner record);

    Prisoner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Prisoner record);

    int updateByPrimaryKey(Prisoner record);
}