package com.sound.haolei.facade;


import java.util.Map;


import com.sound.haolei.model.HlPointsChannelType;

public interface HlPointsChannelTypeFacade extends BaseFacade<HlPointsChannelType>{
	/**
	 * 
	* @Title: findRecyclePrice 
    * @Description: 微信公众号ID回收价格查询
	* @param @param publicnumberid
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月12日 下午6:35:48
	 */
	Map<String, Object> findRecyclePrice(String publicnumberid);
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
	Map<String, Object> selectSubAllspellAndId(String publicnumberid);
	/**
	 * 
	* @Title: selectByChannel 
	* @Description: 通过渠道名称查询社区积分类型
	* @param @param pointsChannelClothe
	* @param @param sid
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月12日 下午7:00:12
	 */
	Map<String, Object> selectByChannel(String pointsChannelClothe, int sid, String publicnumberid);

    /**
     * @Description  分页价格价格
     * @author sushile
     * @date 20180312
     * @return
     */
    String findByPage(int pageNo,int pageSize);


    /**
     * @Description 编辑回收价格提供给php
     * @author sushile
     * @date 20180312
     */
    String recyPriceEdit(String id,String price,String openId);
    /**
     * @Description: 通过channel和分站id来找到积分(乐豆)数量
     * @author wangruwei
     * @date 2017年8月1日上午10:25:53
     * @param channel
     * @param substationId
     * @return
     */
    public int getPointByChannel(String channel,Integer substationId);

} 
