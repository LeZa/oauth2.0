package com.sound.haolei.dto;

import com.sound.haolei.model.HsMachineLianyunCard;

public class HsMachineLianyunCardDto extends HsMachineLianyunCard {
    
	private String mobile;
	
	private String nickname;
	
	private String realname;
	
	private String ctimeStr;
	
	private String usermobile;
	
	private String userNickname;
	
	private String houseAdminMobile;
	
	private String houseAdminNickname;
	

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCtimeStr() {
		return ctimeStr;
	}

	public void setCtimeStr(String ctimeStr) {
		this.ctimeStr = ctimeStr;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUsermobile() {
		return usermobile;
	}

	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getHouseAdminMobile() {
		return houseAdminMobile;
	}

	public void setHouseAdminMobile(String houseAdminMobile) {
		this.houseAdminMobile = houseAdminMobile;
	}

	public String getHouseAdminNickname() {
		return houseAdminNickname;
	}

	public void setHouseAdminNickname(String houseAdminNickname) {
		this.houseAdminNickname = houseAdminNickname;
	}
	
	
	
}