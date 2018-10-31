package com.cqgcxy.authsys.common;

import java.util.List;

/**
 * @author icechen1219
 * @date 2018/10/29
 */
public class ViewTree {
    /**
     * id : 1
     * text : 指标管理
     * iconCls : icon-save
     * checked : true
     * state : open
     * attributes : {}
     * children : []
     */

    private int id;
    private String text;
    private String iconCls;
    private boolean checked;
    private String state;
    private Object attributes;
    private List<ViewTree> children;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public List<ViewTree> getChildren() {
        return children;
    }

    public void setChildren(List<ViewTree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ViewTree{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", checked=" + checked +
                ", state='" + state + '\'' +
                ", children=" + children +
                '}';
    }
}
