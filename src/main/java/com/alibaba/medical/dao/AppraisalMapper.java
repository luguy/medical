package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.Appraisal;

public interface AppraisalMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Appraisal record);

    int insertSelective(Appraisal record);

    Appraisal selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Appraisal record);

    int updateByPrimaryKey(Appraisal record);
}