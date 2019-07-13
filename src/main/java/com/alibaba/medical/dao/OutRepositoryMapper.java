package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.OutRepository;

public interface OutRepositoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OutRepository record);

    int insertSelective(OutRepository record);

    OutRepository selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutRepository record);

    int updateByPrimaryKey(OutRepository record);
}