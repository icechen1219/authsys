package com.cqgcxy.authsys.domain;

import org.apache.poi.hpsf.Decimal;

/**
 * @author icechen1219
 * @date 2018/11/04
 */
public class CourseWareDO {
    private Integer wareId;
    private String wareName;
    private double duration;
    private String warePath;
    private String remark;

    public Integer getWareId() {
        return wareId;
    }

    public void setWareId(Integer wareId) {
        this.wareId = wareId;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getWarePath() {
        return warePath;
    }

    public void setWarePath(String warePath) {
        this.warePath = warePath;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
