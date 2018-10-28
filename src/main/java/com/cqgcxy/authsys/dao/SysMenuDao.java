package com.cqgcxy.authsys.dao;

import com.cqgcxy.authsys.domain.SysMenuDO;
import org.springframework.stereotype.Repository;

/**
 * SysMenuMapper继承基类
 */
@Repository
public interface SysMenuDao extends MyBatisBaseDao<SysMenuDO, Integer> {
}