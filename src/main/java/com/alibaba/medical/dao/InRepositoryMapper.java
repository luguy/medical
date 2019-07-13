package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.InRepository;

public interface InRepositoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InRepository record);

    int insertSelective(InRepository record);

    InRepository selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InRepository record);

    int updateByPrimaryKey(InRepository record);
}