package com.sound.haolei.facade;

import java.util.Map;

import com.sound.haolei.model.HlHouse;


public interface HlHouseFacade extends BaseFacade<HlHouse> {
	/**
	 * 
	* @Title: selectAreaByPCC 
	* @Description: 根据公众号ID查找小区列表
	* @param @param publicnumberid
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月7日 下午6:09:40
	 */
	Map<String, Object> selectAreaByPCC(String publicnumberid);
	/**
	 * 
	* @Title: selectCanAppointmentHouse 
	* @Description: 预约上门回收服务亭查询接口
	* @param @param publicnumberid
	* @param @param countyId
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月8日 下午8:43:24
	 */
	Map<String, Object> selectCanAppointmentHouse(String publicnumberid, String countyId);

	
}

