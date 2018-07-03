package com.sound.haolei.model;

import java.util.Date;

public class HlPointsChannelType extends BaseModel {
    private Integer id;

    private String channel;

    private Byte pointsType;

    private Integer points;

    private String description;

    private Date ctime;

    private Integer cuser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public Byte getPointsType() {
        return pointsType;
    }

    public void setPointsType(Byte pointsType) {
        this.pointsType = pointsType;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getCuser() {
        return cuser;
    }

    public void setCuser(Integer cuser) {
        this.cuser = cuser;
    }
}