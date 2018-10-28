package com.cqgcxy.authsys.web;

import com.cqgcxy.authsys.domain.SysRoleDO;
import com.cqgcxy.authsys.domain.SysUserDO;
import com.cqgcxy.authsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author icechen1219
 * @date 2018/10/28
 */
@Controller
public class UserManagerController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpSession session, SysUserDO userDO){
        System.err.println(userDO);
        SysUserDO loginVo = userService.login(userDO);
        System.err.println(loginVo);
        if(loginVo!=null) {
            session.setAttribute("loginUser", loginVo);
            System.err.println("你拥有以下角色：");
            for (SysRoleDO tmpRole : loginVo.getRoleList()) {
                System.err.println(tmpRole);
            }
            return "admin";
        }else{
            return "error";
        }
    }

    @RequestMapping("/register")
    public String register(ModelMap modelMap, SysUserDO userDO){
        System.err.println(userDO);
        SysUserDO successVo = userService.add(userDO);
        System.err.println(successVo);
        if(successVo!=null) {
            modelMap.addAttribute("loginUser", successVo);
            return "admin";
        }else{
            return "error";
        }
    }
}
