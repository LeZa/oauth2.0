package com.sound.haolei.model;

import java.util.Date;

public class HlOldRecycleTrack extends BaseModel{
    private Integer id;

    private String orderNo;

    private Integer currStatus;

    private Integer nextStatus;

    private String remark;

    private Date ctime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getCurrStatus() {
        return currStatus;
    }

    public void setCurrStatus(Integer currStatus) {
        this.currStatus = currStatus;
    }

    public Integer getNextStatus() {
        return nextStatus;
    }

    public void setNextStatus(Integer nextStatus) {
        this.nextStatus = nextStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}