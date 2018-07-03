package com.sound.haolei.model;

import java.util.Date;

public class HlHouse extends BaseModel{
	
	private static final long serialVersionUID = 5454155825314635342L;
	
	

	//columns START
    /**
     * id  
     */ 	
	private Integer id;
    /**
     * 昵称  
     */ 	
	private String nickname;
    /**
     * 所在省份id  
     */ 	
	private Integer provinceId;
    /**
     * 所在城市id  
     */ 	
	private Integer cityId;
    /**
     * 所在县id  
     */ 	
	private Integer countyId;
    /**
     * 所在小区  
     */ 	
	private String area;
    /**
     * 详细地址  
     */ 	
	private String address;
    /**
     * 设备安置点经度  
     */ 	
	private String potX;
    /**
     * 设备安置点纬度  
     */ 	
	private String potY;
    /**
     * 首字母  
     */ 	
	private String letter;
    /**
     * 描述信息  
     */ 	
	private String description;
    /**
     * 状态：0 删除，1 正常  
     */ 	
	private Integer status;
    /**
     * 开始营业时间  
     */ 	
	private Date startTime;
    /**
     * 结束营业时间  
     */ 	
	private Date endTime;
    /**
     * 创建时间  
     */ 	
	private Date ctime;
    /**
     * 最后修改时间  
     */ 	
	private Date ltime;
    /**
     * 创建人id，即 admin_user 表 id  
     */ 	
	private Integer cuid;
    /**
     * 最后修改人id，admin_user 表 id  
     */ 	
	private Integer luid;
	//columns END

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}

	public String getNickname() {
		return this.nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getProvinceId() {
		return this.provinceId;
	}
	
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public Integer getCityId() {
		return this.cityId;
	}
	
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getCountyId() {
		return this.countyId;
	}
	
	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}
	public String getArea() {
		return this.area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPotX() {
		return this.potX;
	}
	
	public void setPotX(String potX) {
		this.potX = potX;
	}
	public String getPotY() {
		return this.potY;
	}
	
	public void setPotY(String potY) {
		this.potY = potY;
	}
	public String getLetter() {
		return this.letter;
	}
	
	public void setLetter(String letter) {
		this.letter = letter;
	}
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getStartTime() {
		return this.startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return this.endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getCtime() {
		return this.ctime;
	}
	
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public Date getLtime() {
		return this.ltime;
	}
	
	public void setLtime(Date ltime) {
		this.ltime = ltime;
	}
	public Integer getCuid() {
		return this.cuid;
	}
	
	public void setCuid(Integer cuid) {
		this.cuid = cuid;
	}
	public Integer getLuid() {
		return this.luid;
	}
	
	public void setLuid(Integer luid) {
		this.luid = luid;
	}

}

