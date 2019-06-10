package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.DailyDoctor;

public interface DailyDoctorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DailyDoctor record);

    int insertSelective(DailyDoctor record);

    DailyDoctor selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DailyDoctor record);

    int updateByPrimaryKey(DailyDoctor record);
}