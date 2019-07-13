package com.alibaba.medical.dao;

import com.alibaba.medical.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    Role selectRoleByUsername(@Param("username") String username);

    Role selectRoleByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    List<Role> selectRoleByType(@Param("type") int type);
}