package com.sound.haolei.provider.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sound.haolei.model.HlHouse;

public interface HlHouseMapper extends IBaseMapper<HlHouse>{

	/**
	 * 
	* @Title: selectSubstationAllspell 
	* @Description: 通过公众号ID查询分站全拼
	* @param @param publicnumberid
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月8日 下午9:00:11
	 */
	String selectSubstationAllspell(@Param("publicnumberid")String publicnumberid);
	/**
	 * 
	* @Title: selectCanAppointmentHouse 
	* @Description: 查询某分站的 ( 某区或某县或某县级市 ) 的所有服务亭 即：
	* @param @param allSpell
	* @param @param countyId
	* @param @return    设定文件 
	* @return List<Map<String,Object>>    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月8日 下午9:01:25
	 */
	List<Map<String, Object>> selectCanAppointmentHouse(@Param("allSpell")String allSpell, @Param("countyId")String countyId);
	/**
	 * 
	* @Title: selectSubAllspellAndId 
	* @Description: 根据公众号ID查询分站全拼以及分站ID
	* @param @param publicnumberid
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月12日 下午6:45:28
	 */
	Map<String, Object> selectSubAllspellAndId(@Param("publicnumberid")String publicnumberid);

}
