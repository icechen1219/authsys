package com.cqgcxy.authsys.service.impl;

import com.cqgcxy.authsys.dao.SysUserDao;
import com.cqgcxy.authsys.domain.SysUserDO;
import com.cqgcxy.authsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author icechen1219
 * @date 2018/10/25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUserDO login(SysUserDO userDO) {
        SysUserDO resultVo = sysUserDao.findByUserNameAndPwd(userDO);
        if (resultVo != null) {
            // 登录成功，更新登录时间
            resultVo.setLoginTime(new Date());
            sysUserDao.updateLoginTime(resultVo.getUserId());
        }
        return resultVo;
    }

    @Override
    public SysUserDO add(SysUserDO userDO) {
        int rows = sysUserDao.insertSelective(userDO);
        if (rows == 1) {
            return userDO;
        }
        return null;
    }
}
