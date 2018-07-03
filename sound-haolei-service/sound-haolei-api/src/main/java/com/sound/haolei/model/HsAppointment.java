package com.sound.haolei.model;

import java.math.BigDecimal;
import java.util.Date;

public class HsAppointment extends BaseModel{
    private Integer id;

    private Integer substationId;

    private String appointmentName;

    private String appointmentMobile;

    private String type;

    private String description;

    private Integer provinceId;

    private Integer cityId;

    private Integer countyId;

    private Integer areaId;

    private String address;

    private Byte status;

    private String remark;

    private Integer houseId;

    private Integer houseAdminId;

    private Date starttime;

    private Date endtime;

    private Long type1;

    private Long type2;

    private Long type3;

    private Long type4;

    private Long type5;

    private Long type6;

    private Long type7;

    private Long type8;

    private Long type9;

    private Byte payType;

    private BigDecimal payNum;

    private Date buyTime;

    private Date sellTime;

    private Date ctime;

    private Integer cuser;

    private Date rtime;

    private Integer ruser;

    private Integer adminUser;

    private Date intime;
    
    /*
     *house_admin_id关联hl_house_admin表的Id，当hs_appointment表的status=1（已接单）时，
     *返回 hl_house_admin表的nickname
     */
    private String houseAdminName;
    
    /*
     *house_admin_id关联hl_house_admin表的Id，当hs_appointment表的status=1（已接单）时，
     *返回 hl_house_admin表的mobile
     */
    private String houseAdminMobile;
    
    /*
     * 服务亭名称
     */
    private String houseName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubstationId() {
        return substationId;
    }

    public void setSubstationId(Integer substationId) {
        this.substationId = substationId;
    }

    public String getAppointmentName() {
        return appointmentName;
    }

    public void setAppointmentName(String appointmentName) {
        this.appointmentName = appointmentName == null ? null : appointmentName.trim();
    }

    public String getAppointmentMobile() {
        return appointmentMobile;
    }

    public void setAppointmentMobile(String appointmentMobile) {
        this.appointmentMobile = appointmentMobile == null ? null : appointmentMobile.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getHouseAdminId() {
        return houseAdminId;
    }

    public void setHouseAdminId(Integer houseAdminId) {
        this.houseAdminId = houseAdminId;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Long getType1() {
        return type1;
    }

    public void setType1(Long type1) {
        this.type1 = type1;
    }

    public Long getType2() {
        return type2;
    }

    public void setType2(Long type2) {
        this.type2 = type2;
    }

    public Long getType3() {
        return type3;
    }

    public void setType3(Long type3) {
        this.type3 = type3;
    }

    public Long getType4() {
        return type4;
    }

    public void setType4(Long type4) {
        this.type4 = type4;
    }

    public Long getType5() {
        return type5;
    }

    public void setType5(Long type5) {
        this.type5 = type5;
    }

    public Long getType6() {
        return type6;
    }

    public void setType6(Long type6) {
        this.type6 = type6;
    }

    public Long getType7() {
        return type7;
    }

    public void setType7(Long type7) {
        this.type7 = type7;
    }

    public Long getType8() {
        return type8;
    }

    public void setType8(Long type8) {
        this.type8 = type8;
    }

    public Long getType9() {
        return type9;
    }

    public void setType9(Long type9) {
        this.type9 = type9;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public BigDecimal getPayNum() {
        return payNum;
    }

    public void setPayNum(BigDecimal payNum) {
        this.payNum = payNum;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public Date getSellTime() {
        return sellTime;
    }

    public void setSellTime(Date sellTime) {
        this.sellTime = sellTime;
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

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public Integer getRuser() {
        return ruser;
    }

    public void setRuser(Integer ruser) {
        this.ruser = ruser;
    }

    public Integer getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(Integer adminUser) {
        this.adminUser = adminUser;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

	public String getHouseAdminName() {
		return houseAdminName;
	}

	public void setHouseAdminName(String houseAdminName) {
		this.houseAdminName = houseAdminName;
	}

	public String getHouseAdminMobile() {
		return houseAdminMobile;
	}

	public void setHouseAdminMobile(String houseAdminMobile) {
		this.houseAdminMobile = houseAdminMobile;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
    
}