package com.cqgcxy.authsys.service.impl;

import com.cqgcxy.authsys.dao.SysMenuDao;
import com.cqgcxy.authsys.domain.SysMenuDO;
import com.cqgcxy.authsys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author icechen1219
 * @date 2018/10/29
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public List<SysMenuDO> findAll() {
        return sysMenuDao.findAll();
    }

    @Override
    public SysMenuDO findById(Integer menuId) {
        return sysMenuDao.findById(menuId);
    }
}
