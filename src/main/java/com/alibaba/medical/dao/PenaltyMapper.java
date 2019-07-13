package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.Penalty;

public interface PenaltyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Penalty record);

    int insertSelective(Penalty record);

    Penalty selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Penalty record);

    int updateByPrimaryKey(Penalty record);
}