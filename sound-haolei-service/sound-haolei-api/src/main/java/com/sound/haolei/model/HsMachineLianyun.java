package com.sound.haolei.model;


import java.util.Date;

/**
 * @author liuyang
 */
public class HsMachineLianyun extends BaseModel{
    private Integer id;

    private String mchid;

    private Integer houseId;

    private String nickname;

    private Integer provinceId;

    private Integer cityId;

    private Integer countyId;

    private String area;

    private String address;

    private String potX;

    private String potY;

    private Integer weight1;

    private Integer weight2;

    private Integer weight3;

    private Integer weight4;

    private Integer weight5;

    private Integer weight6;

    private Integer weight7;

    private Integer weight8;

    private Integer weight9;

    private String description;

    private Long useNumber;

    private Date ctime;

    private Date ltime;

    private Integer cuid;

    private Integer luid;

    private Date lastOnlineTime;

    private Date lastPosTime;

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

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPotX() {
        return potX;
    }

    public void setPotX(String potX) {
        this.potX = potX == null ? null : potX.trim();
    }

    public String getPotY() {
        return potY;
    }

    public void setPotY(String potY) {
        this.potY = potY == null ? null : potY.trim();
    }

    public Integer getWeight1() {
        return weight1;
    }

    public void setWeight1(Integer weight1) {
        this.weight1 = weight1;
    }

    public Integer getWeight2() {
        return weight2;
    }

    public void setWeight2(Integer weight2) {
        this.weight2 = weight2;
    }

    public Integer getWeight3() {
        return weight3;
    }

    public void setWeight3(Integer weight3) {
        this.weight3 = weight3;
    }

    public Integer getWeight4() {
        return weight4;
    }

    public void setWeight4(Integer weight4) {
        this.weight4 = weight4;
    }

    public Integer getWeight5() {
        return weight5;
    }

    public void setWeight5(Integer weight5) {
        this.weight5 = weight5;
    }

    public Integer getWeight6() {
        return weight6;
    }

    public void setWeight6(Integer weight6) {
        this.weight6 = weight6;
    }

    public Integer getWeight7() {
        return weight7;
    }

    public void setWeight7(Integer weight7) {
        this.weight7 = weight7;
    }

    public Integer getWeight8() {
        return weight8;
    }

    public void setWeight8(Integer weight8) {
        this.weight8 = weight8;
    }

    public Integer getWeight9() {
        return weight9;
    }

    public void setWeight9(Integer weight9) {
        this.weight9 = weight9;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getUseNumber() {
        return useNumber;
    }

    public void setUseNumber(Long useNumber) {
        this.useNumber = useNumber;
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

    public Integer getCuid() {
        return cuid;
    }

    public void setCuid(Integer cuid) {
        this.cuid = cuid;
    }

    public Integer getLuid() {
        return luid;
    }

    public void setLuid(Integer luid) {
        this.luid = luid;
    }

    public Date getLastOnlineTime() {
        return lastOnlineTime;
    }

    public void setLastOnlineTime(Date lastOnlineTime) {
        this.lastOnlineTime = lastOnlineTime;
    }

    public Date getLastPosTime() {
        return lastPosTime;
    }

    public void setLastPosTime(Date lastPosTime) {
        this.lastPosTime = lastPosTime;
    }
}