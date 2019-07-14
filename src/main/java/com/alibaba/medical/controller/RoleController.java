package com.alibaba.medical.controller;

import com.alibaba.medical.common.ServerResponse;
import com.alibaba.medical.pojo.Role;
import com.alibaba.medical.service.IRoleService;
import com.alibaba.medical.vo.RoleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public ServerResponse login(Role role){
        ServerResponse response = iRoleService.login(role.getUsername(), role.getPassword());
        if(response.isSuccess()){
            Role r = (Role) response.getData();
            RoleVO roleVO = new RoleVO();
            BeanUtils.copyProperties(r, roleVO);
            return ServerResponse.createBySuccess(roleVO);
        }
        return response;
    }

}
