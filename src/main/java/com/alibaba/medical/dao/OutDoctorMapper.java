package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.OutDoctor;

public interface OutDoctorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OutDoctor record);

    int insertSelective(OutDoctor record);

    OutDoctor selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutDoctor record);

    int updateByPrimaryKey(OutDoctor record);
}