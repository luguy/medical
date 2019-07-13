package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.PscExam;

public interface PscExamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PscExam record);

    int insertSelective(PscExam record);

    PscExam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PscExam record);

    int updateByPrimaryKey(PscExam record);
}