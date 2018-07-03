package com.sound.haolei.provider.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sound.haolei.model.HlSubstation;

public interface HlSubstationMapper extends IBaseMapper<HlSubstation>{
	/**
	 * 
	* @Title: selectProvinceCityByPublicNumberId 
    * @Description: TODO(注册页面-根据公众号ID查询省市接口) 
	* @param @param publicnumberid
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月5日 下午8:28:20
	 */
	Map<String, Object> selectProvinceCityByPublicNumberId1(@Param("publicnumberid")String publicnumberid,@Param("mid")Integer mid);
	Map<String, Object> selectProvinceCityByPublicNumberId2(@Param("mid")String mid);
	Map<String, Object> selectProvinceCityByPublicNumberId3(@Param("publicnumberid")String publicnumberid,@Param("mid")Integer mid);
	/**
	 * 
	* @Title: selectTypeByPublicNumberId 
	* @Description: TODO(根据公众号ID查询所在站是什么分站？[县级:1市级:0默认站:-1]) 
	* @param @param publicnumberid
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月6日 下午12:17:18
	 */
	Map<String, String> selectTypeByPublicNumberId(@Param("publicnumberid")String publicnumberid);
	/**
	 * 
	* @Title: selectCityInfo 
	* @Description: TODO(根据站点类型type和mid查询市级id和名称) 
	* @param @param publicnumberid
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月6日 下午7:22:35
	 */
	Map<String, Object> selectCityInfo(@Param("mid")String mid);
	/**
	 * 
	* @Title: selectCountyList 
	* @Description: TODO(根据市级id查询县级列表即：小区列表) 
	* @param @param cid
	* @param @return    设定文件 
	* @return List<Map<String,Object>>    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月8日 上午10:44:42
	 */
	List<Map<String, Object>> selectCountyList(@Param("cid")Integer cid);
	
	/**
	 * 通过微信公众号id查询分站id和分站全拼
	 * @param wechatOfficialAccountsId 公众号id
	 * @return
	 * @author liuyang
	 */
    Map<String,Object> getHsIdAndHsSpellByWechatOfficialAccountsId(String wechatOfficialAccountsId);

}
