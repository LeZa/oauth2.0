package com.sound.haolei.model;

import java.util.Date;

public class HlUser extends BaseModel{
	private Integer id;

    private String mobile;

    private String passwd;
    
    private String passwdOrignal;

    private Integer type;
    
    private Integer loginId;

    private String wxOpenid;

    private String qqOpenid;

    private String wbOpenid;

    private Integer grade;
    
    private Integer houseId;

    private Integer cashPoints;

    private Integer levelPoints;

    private String imagePath;

    private String imagePathBig;

    private String nickName;

    private Long nickNameRtime;

    private String nickNameIndex;

    private String realname;

    private Long realnameRtime;

    private Integer sex;

    private Date birthday;

    private Long birthdayRtime;

    private Integer status;

    private String mcode;

    private Date ctime;
    
    private Integer curDaySmsLoginCount;

    private Date ltime;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid == null ? null : wxOpenid.trim();
    }

    public String getQqOpenid() {
        return qqOpenid;
    }

    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid == null ? null : qqOpenid.trim();
    }

    public String getWbOpenid() {
        return wbOpenid;
    }

    public void setWbOpenid(String wbOpenid) {
        this.wbOpenid = wbOpenid == null ? null : wbOpenid.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getCashPoints() {
        return cashPoints;
    }

    public void setCashPoints(Integer cashPoints) {
        this.cashPoints = cashPoints;
    }

    public Integer getLevelPoints() {
        return levelPoints;
    }

    public void setLevelPoints(Integer levelPoints) {
        this.levelPoints = levelPoints;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public String getImagePathBig() {
        return imagePathBig;
    }

    public void setImagePathBig(String imagePathBig) {
        this.imagePathBig = imagePathBig == null ? null : imagePathBig.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Long getNickNameRtime() {
        return nickNameRtime;
    }

    public void setNickNameRtime(Long nickNameRtime) {
        this.nickNameRtime = nickNameRtime;
    }

    public String getNickNameIndex() {
        return nickNameIndex;
    }

    public void setNickNameIndex(String nickNameIndex) {
        this.nickNameIndex = nickNameIndex == null ? null : nickNameIndex.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Long getRealnameRtime() {
        return realnameRtime;
    }

    public void setRealnameRtime(Long realnameRtime) {
        this.realnameRtime = realnameRtime;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getBirthdayRtime() {
        return birthdayRtime;
    }

    public void setBirthdayRtime(Long birthdayRtime) {
        this.birthdayRtime = birthdayRtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMcode() {
        return mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode == null ? null : mcode.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getLtime() {
        return ltime;
    }

    public void setLtime(Date ltime) {
        this.ltime = ltime;
    }

	public String getPasswdOrignal() {
		return passwdOrignal;
	}

	public void setPasswdOrignal(String passwdOrignal) {
		this.passwdOrignal = passwdOrignal;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getGradeName() {
		if(grade == 1){
			return "平民";
		}
		if(grade == 2){
			return "楼长";
		}
		if(grade == 3){
			return "经理";
		}
		if(grade == 4){
			return "主任";
		}
		if(grade == 5){
			return "区长";
    }
		return grade.toString();
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public Integer getCurDaySmsLoginCount() {
		return curDaySmsLoginCount;
	}

	public void setCurDaySmsLoginCount(Integer curDaySmsLoginCount) {
		this.curDaySmsLoginCount = curDaySmsLoginCount;
	}

}