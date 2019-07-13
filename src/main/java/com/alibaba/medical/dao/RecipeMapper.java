package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.Recipe;

public interface RecipeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Recipe record);

    int insertSelective(Recipe record);

    Recipe selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Recipe record);

    int updateByPrimaryKey(Recipe record);
}