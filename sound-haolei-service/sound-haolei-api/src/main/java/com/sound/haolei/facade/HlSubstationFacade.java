package com.sound.haolei.facade;

import java.util.Map;

import com.sound.haolei.model.HlSubstation;

public interface HlSubstationFacade extends BaseFacade<HlSubstation> {
	/**
	 * 
	* @Title: selectProvinceCityByPublicNumberId 
    * @Description: TODO(注册页面-根据公众号ID查询省市接口) 
	* @param @param publicnumberid
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月5日 下午8:25:45
	 */
	Map<String, Object> selectProvinceCityByPublicNumberId(String publicnumberid);

	/**
	 * 通过微信公众号id查询分站id和分站全拼
	 * @param wechatOfficialAccountsId 公众号id
	 * @return
	 * @author liuyang
	 */
	Map<String,Object> getHsIdAndHsSpellByWechatOfficialAccountsId(String wechatOfficialAccountsId);
	/**
	 * 
	* @Title: selectTypeByPublicNumberId 
	* @Description: 查询公众号ID是否存在
	* @param @param publicnumberid
	* @param @return    设定文件 
	* @return Map<String,String>    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月14日 下午2:42:47
	 */
	Map<String, String> selectTypeByPublicNumberId(String publicnumberid);
}

