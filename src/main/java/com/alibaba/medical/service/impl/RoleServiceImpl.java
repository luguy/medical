package com.alibaba.medical.service.impl;

import com.alibaba.medical.common.ResponseCode;
import com.alibaba.medical.common.ServerResponse;
import com.alibaba.medical.dao.RoleMapper;
import com.alibaba.medical.enums.RoleEnum;
import com.alibaba.medical.pojo.Role;
import com.alibaba.medical.service.IRoleService;
import com.alibaba.medical.util.MD5Util;
import com.alibaba.medical.util.RegexUtil;
import com.alibaba.medical.util.TimeStampUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
     *
     * @param username
     * @param password
     * @return
     */
    public ServerResponse login(String username, String password) {
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            Role role = roleMapper.selectRoleByUsernameAndPassword(username, MD5Util.inputPassToDBPass(password));
            if (role != null) {
                role.setLastLoginDate(new Date());
                roleMapper.updateByPrimaryKeySelective(role);
                return ServerResponse.createBySuccess(role);
            }
            return ServerResponse.createByErrorMessage("密码输入错误");
        }
        return ServerResponse.createByErrorMessage("参数不合法");
    }


    /**
     * 查询是否此用户名对应的用户是否存在
     *
     * @param username
     * @return
     */
    public ServerResponse selectRoleByUsername(String username) {
        if (StringUtils.isNotBlank(username)) {
            Role role = roleMapper.selectRoleByUsername(username);
            if (role != null) {
                return ServerResponse.createBySuccess(role);
            }
            return ServerResponse.createByErrorMessage("相关用户不存在");
        }
        return ServerResponse.createByErrorMessage("参数不合法");
    }

    /**
     * 添加角色
     * 仅有管理员和院领导可以增加角色
     *
     * @param opType
     * @param username
     * @param password
     * @param type
     * @return
     */
    public ServerResponse addRole(int opType, String username, String password, int type) {
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            // 首先判断操作者的权限级别,仅有系统管理员和院领导可以添加其他角色
            if (opType == RoleEnum.ADMINISTRATOR.getCode() && RegexUtil.is2To6Number(String.valueOf(type))) {
                // 系统管理员
                ServerResponse response = insertRole(username, password, type);
                return response;
            } else if (opType == RoleEnum.LEADER.getCode() && RegexUtil.is3To6Number(String.valueOf(type))) {
                // 院领导
                ServerResponse response = insertRole(username, password, type);
                return response;
            } else {
                return ServerResponse.createByErrorMessage("没有相关权限");
            }
        }
        return ServerResponse.createByErrorMessage("参数不合法");
    }


    /**
     * 向数据库中插入角色
     *
     * @param username
     * @param password
     * @param type
     * @return
     */
    private ServerResponse insertRole(String username, String password, int type) {
        ServerResponse response = this.selectRoleByUsername(username);
        if (!response.isSuccess()) {
            Role role = new Role();
            role.setId(TimeStampUtil.timeStamp());
            role.setUsername(username);
            role.setPassword(MD5Util.inputPassToDBPass(password));
            role.setType(type);
            role.setCreateDate(new Date());
            int resultCount = roleMapper.insert(role);
            if (resultCount > 0) {
                return ServerResponse.createBySuccessMessage("添加角色成功");
            }
            return ServerResponse.createBySuccessMessage("添加角色失败");
        }
        return response;
    }

    /**
     * 登录状态下修改密码
     *
     * @param username
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public ServerResponse resetPassword(String username, String oldPassword, String newPassword) {
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(oldPassword) && StringUtils.isNotBlank(newPassword)) {
            ServerResponse response = this.selectRoleByUsername(username);
            if (response.isSuccess()) {
                // 如果当前用户存在，则做修改密码操作
                Role role = (Role) response.getData();
                if (oldPassword.equals(role.getPassword())) {
                    // 如果旧密码输入正确
                    Role newRole = new Role();
                    BeanUtils.copyProperties(role, newRole);
                    newRole.setPassword(MD5Util.inputPassToDBPass(newPassword));
                    int resultCount = roleMapper.updateByPrimaryKeySelective(newRole);
                    if (resultCount > 0) {
                        return ServerResponse.createBySuccessMessage("密码修改成功，请重新登录");
                    } else {
                        return ServerResponse.createByErrorMessage("密码修改失败，请稍后重试");
                    }
                } else {
                    return ServerResponse.createByErrorMessage("旧密码错误，请重试");
                }

            }
            return response;
        }
        return ServerResponse.createByErrorMessage("参数不合法");
    }

    /**
     * 删除角色
     * 仅有管理员和院领导可以删除角色
     *
     * @param opType
     * @param username
     * @return
     */
    public ServerResponse removeRole(int opType, String username) {
        if (StringUtils.isNotBlank(username)) {
            ServerResponse response1 = this.selectRoleByUsername(username);
            if (!response1.isSuccess()) {
                return response1;
            }
            Role role = (Role) response1.getData();
            // 判断操作者的权限级别,仅有系统管理员和院领导可以删除角色
            if (opType == RoleEnum.ADMINISTRATOR.getCode() && RegexUtil.is2To6Number(String.valueOf(role.getType()))) {
                // 系统管理员
                ServerResponse response = this.deleteRole(role);
                return response;
            } else if (opType == RoleEnum.LEADER.getCode() && RegexUtil.is3To6Number(String.valueOf(role.getType()))) {
                // 院领导
                ServerResponse response = this.deleteRole(role);
                return response;
            } else {
                return ServerResponse.createByErrorMessage("没有相关权限");
            }
        }
        return ServerResponse.createByErrorMessage("参数不合法");
    }

    /**
     * 从数据库中删除角色
     *
     * @param role
     * @return
     */
    private ServerResponse deleteRole(Role role) {
        if (role != null) {
            int resultCount = roleMapper.deleteByPrimaryKey(role.getId());
            if (resultCount > 0) {
                return ServerResponse.createBySuccessMessage("删除角色成功");
            } else {
                return ServerResponse.createByErrorMessage("删除角色失败");
            }
        }
        return ServerResponse.createByErrorMessage("相关角色不存在");
    }

    /**
     * 获取角色列表
     * 管理员可以获取所有角色列表并进行操作
     * 院领导可以获取除管理员外的所有角色列表并进行操作
     * @param opType
     * @return
     */
    public ServerResponse getRoleListByType(int opType){
        List<Role> roleList = roleMapper.selectRoleByType(opType);
        return assembleRoleListByType(opType, roleList);
    }

    /**
     * 根据权限数组装角色列表
     * @param opType
     * @param roleList
     * @return
     */
    private ServerResponse assembleRoleListByType(int opType, List<Role> roleList){
        if(opType == RoleEnum.ADMINISTRATOR.getCode() || opType == RoleEnum.LEADER.getCode()){
            List<Role> roles = new ArrayList<>();
            for(Role role : roleList){
                if(role.getType() > opType){
                    roles.add(role);
                    System.out.println(role);
                }
            }
            return ServerResponse.createBySuccess(roles);
        }
        return ServerResponse.createByErrorMessage("无权限操作");
    }
}
