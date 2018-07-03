package com.sound.haolei.model;

public class HlUserExt extends BaseModel{
  
	private static final long serialVersionUID = -1703057693816950813L;

	private Integer id;

    private Integer userId;

    private Integer provinceId;

    private Integer cityId;

    private Integer countyId;

    private String address;

    private String interest;

    private String source;

    private Integer hsRole;

    private Integer hsBottleAll;

    private Integer hsClothesAll;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest == null ? null : interest.trim();
    }

    public Integer getHsRole() {
        return hsRole;
    }

    public void setHsRole(Integer hsRole) {
        this.hsRole = hsRole;
    }

    public Integer getHsBottleAll() {
        return hsBottleAll;
    }

    public void setHsBottleAll(Integer hsBottleAll) {
        this.hsBottleAll = hsBottleAll;
    }

    public Integer getHsClothesAll() {
        return hsClothesAll;
    }

    public void setHsClothesAll(Integer hsClothesAll) {
        this.hsClothesAll = hsClothesAll;
    }

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
    
}