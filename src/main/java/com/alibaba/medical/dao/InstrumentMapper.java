package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.Instrument;

public interface InstrumentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Instrument record);

    int insertSelective(Instrument record);

    Instrument selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Instrument record);

    int updateByPrimaryKey(Instrument record);
}