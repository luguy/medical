package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.Prison;

public interface PrisonMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Prison record);

    int insertSelective(Prison record);

    Prison selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Prison record);

    int updateByPrimaryKey(Prison record);
}