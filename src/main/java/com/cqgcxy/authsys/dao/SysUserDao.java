package com.cqgcxy.authsys.dao;

import com.cqgcxy.authsys.domain.SysUserDO;
import org.springframework.stereotype.Repository;

/**
 * SysUserMapper继承基类
 */
@Repository
public interface SysUserDao extends MyBatisBaseDao<SysUserDO, Integer> {
    SysUserDO findByUserNameAndPwd(SysUserDO userDO);
    void updateLoginTime(Integer userId);
}