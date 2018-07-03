package com.sound.haolei.provider.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sound.haolei.model.HlPointsTrack;

public interface HlPointsTrackMapper extends IBaseMapper<HlPointsTrack>{

	/**
	 * 
	 * @Title: selectByUserIdAndType 
	 * @Description: 根据类型查询用户积分
	 * @param userId
	 * @param type
	 * @return    设定文件 
	 * List<HlPointsTrack>    返回类型 
	 * @throws 
	 * @author tianyunyun
	 * @date 2017年5月2日 下午7:30:14
	 */
	public List<HlPointsTrack> selectByUserIdAndType(@Param("userId") Integer userId, @Param("type") Integer type, @Param("which") String which, @Param("size") Integer size, @Param("currentId") Integer lastId);

	/**
	 * 用户乐豆明细
	 * @author wangruwei
	 * @date2017年7月4日10:42:03
	 * @param userId
	 * @param type	乐豆还是等级积分 0是乐豆 1是等级积分
	 * @param srzc	收入还是支出    1是收入，0是支出
	 * @param which 默认下拉 1 上拉-1
	 * @param size 每页条数
	 * @param lastId 最大id 默认为0
	 * @return
	 */
	public List<Map<String, Object>> selectUserPointsDetail(@Param("userId") Integer userId, @Param("type") String type, @Param("srzc") String srzc, @Param("which") String which, @Param("size") Integer size, @Param("currentId") Integer lastId);
}