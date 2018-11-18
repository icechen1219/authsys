package com.cqgcxy.authsys.web;

import com.cqgcxy.authsys.common.ViewTree;
import com.cqgcxy.authsys.domain.SysMenuDO;
import com.cqgcxy.authsys.service.MenuService;
import com.cqgcxy.authsys.util.EasyUiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author icechen1219
 * @date 2018/10/29
 */
@Controller
public class MenuManagerController {
    private Logger logger = LoggerFactory.getLogger(MenuManagerController.class);

    @Autowired
    private MenuService menuService;

    @ResponseBody
    @RequestMapping("/menuTree")
    public List<ViewTree> buildMenuTree(@RequestParam(required = false) Integer id) {
        List<SysMenuDO> allMenuList;
        if (id == null) {
            allMenuList = menuService.findAll();
        } else {
            allMenuList = menuService.findByParentId(id);
        }
        logger.debug(allMenuList.toString());
        List<ViewTree> viewTrees = EasyUiUtil.buildTreeData(allMenuList, id);
        logger.debug(viewTrees.toString());
        return viewTrees;
    }
}
