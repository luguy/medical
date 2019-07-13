package com.alibaba.medical.controller;

import com.alibaba.medical.common.Const;
import com.alibaba.medical.common.ServerResponse;
import com.alibaba.medical.pojo.Role;
import com.alibaba.medical.service.IRoleService;
import com.alibaba.medical.vo.RoleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @ClassName RoleController
 * @Description TODO
 * @Author panjing
 * @Date 2019/6/22 21:21
 * @Version 1.0
 **/
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    IRoleService iRoleService;

    /**
     * 用户登录
     * @param role
     * @return
     */
    @RequestMapping("/login")
    public ServerResponse login(Role role, HttpSession session){
        ServerResponse response = iRoleService.login(role.getUsername(), role.getPassword());
        if(response.isSuccess()){
            Role r = (Role) response.getData();
            RoleVO roleVO = new RoleVO();
            BeanUtils.copyProperties(r, roleVO);
            session.setAttribute(Const.CURRENT_ROLE, roleVO);
            return ServerResponse.createBySuccess(roleVO);
        }
        return response;
    }

    /**
     * 添加角色
     * 仅有系统管理员和院领导可以添加其他角色
     * 其中系统管理员具有最高权限，可以添加权限级别为2,3,4,5,6的角色
     * 院领导具有次高权限，可以添加权限级别为3,4,5,6的角色
     * @param role
     * @return
     */
    @RequestMapping("/addRole")
    public ServerResponse addRole(Role role, HttpSession session){
        RoleVO roleVO = (RoleVO) session.getAttribute(Const.CURRENT_ROLE);
        if(roleVO == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        if(role == null){
            return ServerResponse.createByErrorMessage("参数不合法");
        }
        ServerResponse response = iRoleService.addRole(roleVO.getType(), role.getUsername(), role.getPassword(), role.getType());
        return response;
    }


    /**
     * 登录状态下修改密码
     * @param session
     * @return
     */
    @RequestMapping("/resetPassword")
    public ServerResponse resetPassword(HttpSession session, String newPassword){
        RoleVO roleVO = (RoleVO) session.getAttribute(Const.CURRENT_ROLE);
        if(roleVO == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        ServerResponse response = iRoleService.resetPassword(roleVO.getUsername(), roleVO.getPassword(), newPassword);
        if(response.isSuccess()){
            // 如果密码修改成功，清除session中存有的角色信息
            session.removeAttribute(Const.CURRENT_ROLE);
            return response;
        }
        return response;
    }

    /**
     * 登出
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public ServerResponse logout(HttpSession session){
        RoleVO roleVO = (RoleVO) session.getAttribute(Const.CURRENT_ROLE);
        if(roleVO != null){
            // 登录状态
            session.removeAttribute(Const.CURRENT_ROLE);
            return ServerResponse.createBySuccessMessage("用户已成功登出");
        }else{
            return ServerResponse.createByErrorMessage("用户未登录，请先登录");
        }
    }

    /**
     * 删除角色
     * @param username
     * @param session
     * @return
     */
    @RequestMapping("/removeRole")
    public ServerResponse removeRole(String username, HttpSession session) {
        RoleVO roleVO = (RoleVO) session.getAttribute(Const.CURRENT_ROLE);
        if (roleVO != null) {
            ServerResponse response = iRoleService.removeRole(roleVO.getType(), username);
            return response;
        } else {
            return ServerResponse.createByErrorMessage("用户未登录，请先登录");
        }
    }

    /**
     * 根据权限级别获取权限列表
     * @param session
     * @return
     */
    @RequestMapping("/getRoleList")
    public ServerResponse getRoleList(HttpSession session){
        RoleVO roleVO = (RoleVO) session.getAttribute(Const.CURRENT_ROLE);
        if (roleVO != null) {
            ServerResponse response = iRoleService.getRoleListByType(roleVO.getType());
            return response;
        } else {
            return ServerResponse.createByErrorMessage("用户未登录，请先登录");
        }
    }
}
