package com.sound.haolei.provider.dao;


import com.sound.haolei.dto.HlUserExtLoginDto;
import com.sound.haolei.model.HlUserExt;

public interface HlUserExtMapper extends IBaseMapper<HlUserExt>{
    /**
     * 根据用户id查询用户扩展信息
    * @Title: selectByUserId 
    * @param @param userId
    * @param @return    设定文件 
    * @return HlUserExt    返回类型 
    * @throws 
    * @author wanghancheng
    * @date 2017年4月25日 上午10:38:56
     */
    HlUserExt selectByUserId(Integer userId);
    
    /**
     * 
     * @Title: selectExtDtoByUserId 
     * @Description: 获取用户登陆拓展信息（增加省市区name字段）
     * @param userId
     * @return    设定文件 
     * HlUserExtLoginDto    返回类型 
     * @throws 
     * @author tianyunyun
     * @date 2017年6月27日 下午6:15:58
     */
    HlUserExtLoginDto selectExtDtoByUserId(Integer userId);

	/**
	 * 根据主键更新用户扩展
	* @Title: updateByPrimaryKey
	* @param userExt
	* @return
	* @author wangyonghui
	* @date 2017年9月5日 下午2:52:10
	 */
	int updateByPrimaryKey(HlUserExt userExt);


    /**
     * @Description 更新用户资料by php
     * @author sushile
     * @date 20180313
     * @param userExt
     */
    void updateSupportPhp(HlUserExt userExt);
}