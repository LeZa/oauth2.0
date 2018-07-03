package com.sound.haolei.provider.dao;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.sound.haolei.constants.ConstantsSubstation;
import com.sound.haolei.model.HlPointsChannelType;

public interface HlPointsChannelTypeMapper extends IBaseMapper<HlPointsChannelType>{
	/**
	 * 
	* @Title: selectByChannel 
	* @Description: 通过渠道名称查询社区积分类型
	* @param @param channel
	* @param @param spell
	* @param @return    设定文件 
	* @return HlPointsChannelType    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月12日 下午7:16:50
	 */
	HlPointsChannelType selectByChannel(@Param("channel")String channel, 
			@Param(ConstantsSubstation.SUBSTATION_NAME_SPELL)String substationSpell);

    /**
     * @Description 分页查询回收价格
     * @author sushile
     * @date 20180313
     **/
    Page<HlPointsChannelType> searchByPage();

    /**
     * @Description 　更新回收价格
     * @author sushile
     * @date 20180313
     */
    void updateSupportPhp( HlPointsChannelType hlPointsChannelType);
}