package com.sound.haolei.dto;

import java.util.Date;

import com.sound.haolei.model.BaseModel;

public class HlSubstationDto extends BaseModel{
	
	private static final long serialVersionUID = 5454155825314635342L;
	
	

	//columns START
    /**
     * id  
     */ 	
	private Integer id;
    /**
     * 名称  
     */ 	
	private String name;
    /**
     * 首字母  
     */ 	
	private String letter;
    /**
     * 拼音简称  
     */ 	
	private String spell;
    /**
     * 分站类型：-1: 默认站，0：市级分站，1：县级分站  
     */ 	
	private Integer type;
    /**
     * map表中的id，市级分站为 map_city 表id，县级分站为 map_county 表id  
     */ 	
	private Integer mid;
    /**
     * 分站状态：0：未开通，1：已开通  
     */ 	
	private Integer status;
    /**
     * 是否自定义功能模块,0:否,1:是  
     */ 	
	private Integer isCustomModule;
    /**
     * 热门站点，0：非热门，1：热门  
     */ 	
	private Integer hotSite;
    /**
     * 创建时间  
     */ 	
	private Date ctime;
    /**
     * 分站微信公众号id  
     */ 	
	private String wechatOfficialAccountsId;
    /**
     * 分站客服电话  
     */ 	
	private String substationPhone;
	//columns END

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getLetter() {
		return this.letter;
	}
	
	public void setLetter(String letter) {
		this.letter = letter;
	}
	public String getSpell() {
		return this.spell;
	}
	
	public void setSpell(String spell) {
		this.spell = spell;
	}
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getMid() {
		return this.mid;
	}
	
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIsCustomModule() {
		return this.isCustomModule;
	}
	
	public void setIsCustomModule(Integer isCustomModule) {
		this.isCustomModule = isCustomModule;
	}
	public Integer getHotSite() {
		return this.hotSite;
	}
	
	public void setHotSite(Integer hotSite) {
		this.hotSite = hotSite;
	}
	public Date getCtime() {
		return this.ctime;
	}
	
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public String getWechatOfficialAccountsId() {
		return this.wechatOfficialAccountsId;
	}
	
	public void setWechatOfficialAccountsId(String wechatOfficialAccountsId) {
		this.wechatOfficialAccountsId = wechatOfficialAccountsId;
	}
	public String getSubstationPhone() {
		return this.substationPhone;
	}
	
	public void setSubstationPhone(String substationPhone) {
		this.substationPhone = substationPhone;
	}

}

