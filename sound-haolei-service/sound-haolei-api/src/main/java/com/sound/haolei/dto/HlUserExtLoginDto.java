package com.sound.haolei.dto;

import com.sound.haolei.model.HlUserExt;

public class HlUserExtLoginDto extends HlUserExt {

	private String provinceName;
	
	private String cityName;
	
	private String countyName;

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	
	
}
