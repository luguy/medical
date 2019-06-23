package com.alibaba.medical.service.impl;

import com.alibaba.medical.common.ResponseCode;
import com.alibaba.medical.common.ServerResponse;
import com.alibaba.medical.dao.RoleMapper;
import com.alibaba.medical.pojo.Role;
import com.alibaba.medical.service.IRoleService;
import com.alibaba.medical.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author panjing
 * @Date 2019/6/22 12:16
 * @Version 1.0
 **/
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    RoleMapper roleMapper;

    /**
     * 用户登录相关逻辑
     * @param username
     * @param password
     * @return
     */
    public ServerResponse login(String username, String password){
        if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
            Role role = roleMapper.selectRoleByUsernameAndPassword(username, MD5Util.inputPassToDBPass(password));
            if(role != null){
                return ServerResponse.createBySuccess(role);
            }
            return ServerResponse.createByErrorMessage(ResponseCode.NOT_FOUND.getDesc());
        }
        return ServerResponse.createByErrorMessage(ResponseCode.ILLEGAL_ARGUMENT.getDesc());
    }


    /**
     * 查询是否此用户名对应的用户是否存在
     * @param username
     * @return
     */
    public ServerResponse selectRoleByUsername(String username){
        if(StringUtils.isNotBlank(username)){
            Role role = roleMapper.selectRoleByUsername(username);
            if(role != null){
                return ServerResponse.createBySuccess(role);
            }
            return ServerResponse.createByErrorMessage(ResponseCode.NOT_FOUND.getDesc());
        }
        return ServerResponse.createByErrorMessage(ResponseCode.ILLEGAL_ARGUMENT.getDesc());
    }
}
