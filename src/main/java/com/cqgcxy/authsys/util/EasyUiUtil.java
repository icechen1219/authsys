package com.cqgcxy.authsys.util;

import com.cqgcxy.authsys.common.MenuAttribute;
import com.cqgcxy.authsys.common.ViewTree;
import com.cqgcxy.authsys.domain.SysMenuDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author icechen1219
 * @date 2018/10/29
 */
public class EasyUiUtil {
    public static List<ViewTree> buildTreeData(List<SysMenuDO> menuList, Integer parentId) {
        List<ViewTree> list = new ArrayList<>();
        for (SysMenuDO tmp : menuList) {
            if (Objects.equals(tmp.getParentId(), parentId)) {
                ViewTree m1 = new ViewTree();
                convert2EasyUiTreeData(tmp, m1);
                list.add(m1);
            }
        }
        return list;
    }

    private static List<ViewTree> fechChildrenMenu(List<SysMenuDO> subMenus) {
        List<ViewTree> children = new ArrayList<>();
        for (SysMenuDO subMenu : subMenus) {
            ViewTree m2 = new ViewTree();
            convert2EasyUiTreeData(subMenu, m2);
            children.add(m2);
        }

        return children;
    }

    private static void convert2EasyUiTreeData(SysMenuDO sysMenu, ViewTree menu1) {
        menu1.setId(sysMenu.getMenuId());
        menu1.setText(sysMenu.getMenuName());
        menu1.setIconCls(sysMenu.getIcon());
        MenuAttribute attributes = new MenuAttribute();
        BeanUtilsEx.copyProperties(sysMenu,attributes);
        menu1.setAttributes(attributes);
        if (sysMenu.getSubMenuList().size() != 0) {
            menu1.setChildren(fechChildrenMenu(sysMenu.getSubMenuList()));
        }
    }
}
