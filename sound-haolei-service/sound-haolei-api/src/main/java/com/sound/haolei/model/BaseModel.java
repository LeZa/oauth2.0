package com.sound.haolei.model;

import java.io.Serializable;

public class BaseModel implements Serializable{

	/** 
	* @Fields serialVersionUID : 序列化 
	*/ 
	
	private static final long serialVersionUID = 1375587575423105320L;
	
	public String substationNameSpell;

	public String getSubstationNameSpell() {
		return substationNameSpell;
	}

	public void setSubstationNameSpell(String substationNameSpell) {
		this.substationNameSpell = substationNameSpell;
	}

	
}
