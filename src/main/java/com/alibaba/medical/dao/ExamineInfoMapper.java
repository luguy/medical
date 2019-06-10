package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.ExamineInfo;

public interface ExamineInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExamineInfo record);

    int insertSelective(ExamineInfo record);

    ExamineInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExamineInfo record);

    int updateByPrimaryKey(ExamineInfo record);
}