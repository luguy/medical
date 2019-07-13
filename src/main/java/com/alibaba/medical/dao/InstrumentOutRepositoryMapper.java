package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.InstrumentOutRepository;

public interface InstrumentOutRepositoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InstrumentOutRepository record);

    int insertSelective(InstrumentOutRepository record);

    InstrumentOutRepository selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InstrumentOutRepository record);

    int updateByPrimaryKey(InstrumentOutRepository record);
}