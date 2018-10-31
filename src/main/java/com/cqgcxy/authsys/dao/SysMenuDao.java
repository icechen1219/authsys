package com.cqgcxy.authsys.dao;

import com.cqgcxy.authsys.domain.SysMenuDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysMenuMapper继承基类
 */
@Repository
public interface SysMenuDao extends MyBatisBaseDao<SysMenuDO, Integer> {
    List<SysMenuDO> findAll();
    List<SysMenuDO> findByParentId(Integer parentId);
    SysMenuDO findById(Integer menuId);
}