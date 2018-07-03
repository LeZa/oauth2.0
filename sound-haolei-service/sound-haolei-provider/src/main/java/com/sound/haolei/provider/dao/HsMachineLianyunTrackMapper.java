package com.sound.haolei.provider.dao;

import java.util.List;
import java.util.Map;

import com.sound.haolei.model.HsMachineLianyunTrack;
import org.apache.ibatis.annotations.Param;

public interface HsMachineLianyunTrackMapper extends IBaseMapper<HsMachineLianyunTrack>{
	
	/**
	 * 查询联运卡对应的用户操作轨迹
	* @Title: selectByCardId 
	* @param cardId
	* @return    设定文件 
	* @return List<HsMachineLianyunTrack>    返回类型 
	* @throws 
	* @author wanghancheng
	* @date 2017年6月1日 下午4:18:29
	 */
	List<HsMachineLianyunTrack> selectByCardId(String cardId);
   
	/**
	 * 
	 * @Description 添加联运回收机时 同步轨迹表里的回收数据
	 * @author sushile
	 * @Date 2017年8月8日下午5:42:06
	 * @return
	 */
	String selectTrackByUserId(@Param("userId") String userId,
                                @Param("substationId") String substationId,
                                    @Param("startTime") String startTime,@Param("endTime") String endTime);


    /**
     *
     * @Description 添加联运回收机时 同步轨迹表里的回收数据
     * @author sushile
     * @Date 2017年8月8日下午5:42:06
     * @param mchId
     * @return
     */
    List<Map<String,Object>> selectTrackByMchId(@Param("mchId")String mchId,@Param("substationId")String substationId);
	
	/**
	 * 
	 * @Description 根据回收机id更新轨迹表里的分站id
	 * @author sushile
	 * @Date 2017年8月8日下午5:46:05
	 * @param substationId
	 * @param mchId
	 * @return
	 */
	int updateTrackBySubId(@Param("substationId") String substationId, @Param("mchId") String mchId);

    /**
     *@Description  根据卡号查询回收记录
     *@author sushile
     *@date 2010309
     *@return
     */
    List<Map<String,Object>> selectTrackByCardId(Map<String,Object> paramMap);
}