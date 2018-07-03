package com.sound.haolei.provider.dao;

import com.sound.haolei.model.HsMachineLianyunCard;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HsMachineLianyunCardMapper extends IBaseMapper<HsMachineLianyunCard>{
	
	/**
	 * @Description 根据卡号查询
	 * @author sushile
	 * @param cardId
	 * @return
	 */
	List<HsMachineLianyunCard> selectByCardId(@Param("cardId") String cardId);
	/**
	 * @Description 根据用户id查询
	 * @return
	 */
	HsMachineLianyunCard selectByUserId(@Param("userId") Integer userId);
	
	/**
	 * 
	* @Title: getList 
	* @Description: 获取寄件记录
	* @param which -1 上拉 1 下拉
	* @param size
	* @param lastId 
	* @return 参数说明
	* @author wanghancheng
	* @date 2017年6月1日18:22:41
	 */
	public List<HsMachineLianyunCard> getList(Map<String, Object> map);
	/**
	 * 批量删除联运card绑卡信息
	 * @param ids
	 * @return
	 */
	int batchDelMachines(List<Integer> ids);
}