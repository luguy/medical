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
}
