package com.sound.haolei.model;

import java.util.Date;

public class HsMachineLianyunTrack extends BaseModel{
	private Integer id;

    private Integer substationId;

    private String mchid;

    private String cardId;

    private Integer userId;

    private Byte type;

    private Integer weight;

    private Date ctime;
    
    /**
     * 本次投递赠送乐豆数
     */
    private Integer cashPoint;
    
    /**
     * 本次投递赠送积分数量
     */
    private Integer levelPoint;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public Integer getSubstationId() {
		return substationId;
	}

	public void setSubstationId(Integer substationId) {
		this.substationId = substationId;
	}

	public Integer getCashPoint() {
		return cashPoint;
	}

	public void setCashPoint(Integer cashPoint) {
		this.cashPoint = cashPoint;
	}

	public Integer getLevelPoint() {
		return levelPoint;
	}

	public void setLevelPoint(Integer levelPoint) {
		this.levelPoint = levelPoint;
	}
    
	
    
}