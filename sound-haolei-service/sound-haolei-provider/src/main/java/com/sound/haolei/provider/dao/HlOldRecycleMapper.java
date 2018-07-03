package com.sound.haolei.provider.dao;

import java.util.List;
import java.util.Map;

import com.sound.haolei.model.HlOldRecycle;

public interface HlOldRecycleMapper extends IBaseMapper<HlOldRecycle>{
	/**
	 * @describe:根据订单号更新状态或其他字段
	 * @author wangruwei
	 * @date 2018年3月13日下午2:22:02
	 * @param hloldRecycle
	 */
	int updateByCondition(HlOldRecycle hloldRecycle);

	/**
	 * @describe:对php的分页接口
	 * @author wangruwei
	 * @date 2018年3月13日下午3:48:22
	 * @param csmap
	 * @return
	 */
	List<HlOldRecycle> queryOldRecyclePage(Map<String, Object> csmap);
	
	
	
}