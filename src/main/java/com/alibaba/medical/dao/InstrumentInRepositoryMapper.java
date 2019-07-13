package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.InstrumentInRepository;

public interface InstrumentInRepositoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InstrumentInRepository record);

    int insertSelective(InstrumentInRepository record);

    InstrumentInRepository selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InstrumentInRepository record);

    int updateByPrimaryKey(InstrumentInRepository record);
}