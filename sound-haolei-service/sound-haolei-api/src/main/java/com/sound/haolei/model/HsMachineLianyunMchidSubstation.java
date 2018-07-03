package com.sound.haolei.model;

public class HsMachineLianyunMchidSubstation extends BaseModel {
    private Integer id;

    private String mchid;

    private Integer substationId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid == null ? null : mchid.trim();
    }

    public Integer getSubstationId() {
        return substationId;
    }

    public void setSubstationId(Integer substationId) {
        this.substationId = substationId;
    }
}