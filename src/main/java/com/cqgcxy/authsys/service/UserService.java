package com.cqgcxy.authsys.service;

import com.cqgcxy.authsys.domain.SysUserDO;

/**
 * @author icechen1219
 * @date 2018/10/25
 */
public interface UserService {
    /**
     * 登录
     * @param userDO
     * @return
     */
    SysUserDO login(SysUserDO userDO);

    /**
     * 注册
     * @param userDO
     * @return
     */
    SysUserDO add(SysUserDO userDO);
}
