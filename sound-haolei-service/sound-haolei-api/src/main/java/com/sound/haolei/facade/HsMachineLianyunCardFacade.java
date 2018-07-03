package com.sound.haolei.facade;

import java.util.List;
import java.util.Map;

import com.sound.haolei.model.HsMachineLianyunCard;

public interface HsMachineLianyunCardFacade  extends BaseFacade<HsMachineLianyunCard>{

	Map<String,Object> selectByCardId(String cardId);
	
	/**
	 * 联运卡绑定用户信息
	* @Title: addCardUserInfo
	* @param cardId 联运卡卡号
	* @param houseAdminId 回收亭管理员id
	* @param mobile 手机号
	* @param name 姓名
	* @param province 省
	* @param city 市
	* @param country 区
	* @param area 详细地址
	* @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	* @author wanghancheng
	* @date 2017年6月1日 下午2:09:31
	 */
	Map<String,Object> addCardUserInfo(String cardId, String houseAdminId, String mobile, String name, String province, String city, String country, String area);
	
	/**
	 * 通过联运卡号查询用户信息
	* @Title: selectUserByCardId 
	* @param cardId 联运卡号
	* @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	* @author wanghancheng
	* @date 2017年6月1日 下午3:25:31
	 */
	Map<String,Object> selectUserByCardId(String cardId);
	/**
	 * 查询管理员绑卡列表
	* @Title: selectByHouseAdminId 
	* @param houseAdminId 管理员id
	* @param lastId 最大id
	* @param size 每页条数
	* @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	* @author wanghancheng
	* @date 2017年6月1日 下午6:36:16
	 */
	Map<String,Object> selectByHouseAdminId(Integer houseAdminId, Integer lastId, Integer size);
	/**
	 * 查询回收亭管理员地址
	* @Title: getHouseAdminAddress 
	* @param houseAdminId 回收亭管理员id
	* @param isLast 0 管理员管辖所有回收亭地址列表按照创建时间倒序第一条  1 管理员管辖所有回收亭地址列表
	* @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	* @author wanghancheng
	* @date 2017年6月2日 上午11:12:24
	 */
	Map<String,Object> getHouseAdminAddress(Integer houseAdminId, Integer isLast);
	/**
	 * 批量删除联运卡
	 * @param ids
	 * @return
	 */
	Map<String, Object> batchDelMachines(List<Integer> ids);

	Map<String, Object> addCardUserInfoBack(String cardId, String string, String usermobile, String username, String province,
                                            String city, String county, String address, String adminid);

	/**
	 * 查询管理员绑卡列表v201
	* @Title: selectByHouseAdminIdv201 
	* @param houseAdminId 管理员id
	* @param lastId 最大id
	* @param size 每页条数
	* @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	* @author wanghancheng
	* @date 2017年6月1日 下午6:36:16
	 */
	Map<String, Object> selectByHouseAdminIdv201(Integer houseAdminId, Integer lastId, Integer size);


	/**
	 * @param userId
	 * @author zhaoming
	 * @return
	 */
    Map<String,Object> selectCardByUserId(Integer userId);

	/**
	 * @param communitycommunity
	 * @param street
	 * @return
	 * @author zhaoming
	 */
	Map<String,Object> saveUserToLianYun(Integer userId,Integer subId ,String province,
                                         String city,String country,String area);
}
