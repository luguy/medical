package com.alibaba.medical.service;

import com.alibaba.medical.common.ServerResponse;

/**
 * @ClassName IRoleService
 * @Description TODO
 * @Author panjing
 * @Date 2019/6/22 12:16
 * @Version 1.0
 **/
public interface IRoleService {

    /**
     * 用户登录相关逻辑
     * @param username
     * @param password
     * @return
     */
    ServerResponse login(String username, String password);

    /**
     * 查询是否此用户名对应的用户是否存在
     * @param username
     * @return
     */
    ServerResponse selectRoleByUsername(String username);

    /**
     * 添加角色
     * @param opType
     * @param username
     * @param password
     * @param type
     * @return
     */
    ServerResponse addRole(int opType, String username, String password, int type);

    /**
     * 登录状态下修改密码
     * @param username
     * @param oldPassword
     * @param newPassword
     * @return
     */
    ServerResponse resetPassword(String username, String oldPassword, String newPassword);

    /**
     * 删除角色
     * @param opType
     * @param username
     * @return
     */
    ServerResponse removeRole(int opType, String username);

    /**
     * 根据权限级别查看用户列表
     * @param opType
     * @return
     */
    ServerResponse getRoleListByType(int opType);
}
