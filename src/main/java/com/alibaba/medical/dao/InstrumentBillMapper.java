package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.InstrumentBill;

public interface InstrumentBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InstrumentBill record);

    int insertSelective(InstrumentBill record);

    InstrumentBill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InstrumentBill record);

    int updateByPrimaryKey(InstrumentBill record);
}