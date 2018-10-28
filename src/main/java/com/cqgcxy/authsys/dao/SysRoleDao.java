package com.cqgcxy.authsys.dao;

import com.cqgcxy.authsys.domain.SysRoleDO;
import org.springframework.stereotype.Repository;

/**
 * SysRoleMapper继承基类
 */
@Repository
public interface SysRoleDao extends MyBatisBaseDao<SysRoleDO, Integer> {
}