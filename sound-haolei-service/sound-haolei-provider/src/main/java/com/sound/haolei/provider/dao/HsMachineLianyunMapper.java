package com.sound.haolei.provider.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sound.haolei.model.HsMachineLianyun;
import org.apache.ibatis.annotations.Param;

public interface HsMachineLianyunMapper extends IBaseMapper<HsMachineLianyun>{

	/**
	 * 
	 * @Title: selectByMchid 
	 * @Description: 根据机器码查询
	 * @param mchid
	 * @return    设定文件 
	 * HsMachineLianyun    返回类型 
	 * @throws 
	 * @author tianyunyun
	 * @date 2017年5月4日 上午11:18:33
	 */
	//public HsMachineLianyun selectByMchid(@Param("mchid") String mchid, @Param(ConstantsSubstation.SUBSTATION_NAME_SPELL) String spell);
	
	/**
	 * 批量删除回收机
	* @Title: batchDelMachines 
	* @param @param list
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws 
	* @author wanghancheng
	* @date 2017年5月5日 下午12:11:02
	 */
	public int batchDelMachines(Map<String, Object> param);

	//查询当天已更新的数据
	public List<HsMachineLianyun> selectTodayUpdateData(@Param("substationNameSpell") String spell);

	//查询机器推送云平台
	public List<Map<String, Object>> selectMachineToCloud(List<String> failIds, @Param("substationNameSpell") String hSSpell);

	//查询当天新增的机器
	public List<Map<String, Object>> selectNewMachineToCloud(@Param("substationNameSpell") String hSSpell);

	//查询发送失败的更新数据列表到云平台
	public List<Map<String, Object>> selectUpdateMachineToCloud(List<String> failIds, @Param("substationId") int substationId, @Param("substationNameSpell") String hSSpell);

	//查询当天更新了的机器到云平台推送
	public List<Map<String, Object>> selectUpdatedMachineToCloud(@Param("endtime") Date param, @Param("substationId") int substationId, @Param("substationNameSpell") String hSSpell);

	public int selectByMchidOrNickName(Map<String, Object> nickmap);
}