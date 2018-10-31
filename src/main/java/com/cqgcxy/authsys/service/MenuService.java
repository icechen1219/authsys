package com.cqgcxy.authsys.service;

import com.cqgcxy.authsys.domain.SysMenuDO;

import java.util.List;

/**
 * @author icechen1219
 * @date 2018/10/29
 */
public interface MenuService {
    List<SysMenuDO> findAll();

    List<SysMenuDO> findByParentId(Integer id);

    SysMenuDO findById(Integer menuId);

}
