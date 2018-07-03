package com.sound.haolei.facade;

import com.sound.haolei.model.HsMachineLianyun;

import java.util.List;
import java.util.Map;



public interface HsMachineLianyunFacade extends BaseFacade<HsMachineLianyun> {



    /**
     *
     * @Title: getIsValid
     * @Description: 验证是否为有效的机器
     * @param mchid
     * @return    设定文件
     * boolean    返回类型
     * @throws
     * @author tianyunyun
     * @date 2017年5月4日 下午3:06:01
     */
    public boolean getIsValid(String mchid);

    /**
     *
     * @Title: setMachineInToRedis
     * @Description: 将回收机加入到redis中去
     * @param machine    设定文件
     * void    返回类型
     * @throws
     * @author tianyunyun
     * @date 2017年5月4日 下午3:26:04
     */
    public void setMachineInToRedis(HsMachineLianyun machine);

    /**
     * 批量删除回收机
     * @Title: batchDelMachines
     * @param @param list
     * @param @return    设定文件
     * @return Map<String,Object>    返回类型
     * @throws
     * @author wanghancheng
     * @date 2017年5月5日11:47:24
     */
    Map<String,Object> batchDelMachines(Map<String,Object> param)throws Exception ;

    /**
     *
     * @Title: saveBeat
     * @Description: 处理心跳方法
     * @param mchid
     * @param nickname
     * @param province
     * @param city
     * @param county
     * @param address
     * @param potX
     * @param potY
     * @return    设定文件
     * Map<String,Object>    返回类型
     * @throws
     * @author tianyunyun
     * @date 2017年5月5日 下午5:20:06
     */
    public Map<String, Object> saveBeat(String mchid, String nickname, String province, String city, String county, String potX, String potY,String description,String area,String address);

    /**
     *
     * @Title: saveUserTrack
     * @Description: 保存用户轨迹
     * @param cardid
     * @param mchid
     * @param type
     * @param weight
     * @return    设定文件
     * Map<String,Object>    返回类型
     * @throws
     * @author tianyunyun
     * @date 2017年5月5日 下午5:29:08
     */
    public Map<String, Object> saveUserTrack(String cardid, String mchid, Integer type, Integer weight);

    /**
     *
     * @Title: saveUser
     * @Description: 同步用户数据
     * @param realname
     * @param province
     * @param city
     * @param county
     * @param area
     * @param address
     * @param phone
     * @return    设定文件
     * Map<String,Object>    返回类型
     * @throws
     * @author tianyunyun
     * @date 2017年5月5日 下午6:26:46
     */
	/*public Map<String, Object> saveUser(String realname, String province, String city, String county, String area,
			String address, String phone);*/
    public Map<String, Object> saveUser(String cardid);

    /**
     *
     * @Title: sendNewMachineToCloud
     * @Description:发送新增回收机到云平台
     * @param string
     * @param header    设定文件
     * void    返回类型
     * @throws
     * @author tianyunyun
     * @date 2017年5月11日 下午4:06:34
     */
    public void sendNewMachineToCloud(String string, Map<String, String> header);

    /**
     *
     * @Title: sendUpdateMachineToCloud
     * @Description: 推送新增的数据到云平台
     * @param url
     * @param header    设定文件
     * void    返回类型
     * @throws
     * @author tianyunyun
     * @date 2017年5月11日 下午4:32:04
     */
    public void sendUpdateMachineToCloud(String url, Map<String, String> header);

    /**
     *
     * @Title: selectTodayUpdateData
     * @Description: 查询当天更新的机器数据列表
     * @return    设定文件
     * List<HsMachineLianyun>    返回类型
     * @throws
     * @author tianyunyun
     * @date 2017年5月14日 下午5:48:18
     */
    public List<HsMachineLianyun> selectTodayUpdateData();

    public int selectByMchidOrNickName(Map<String, Object> nickmap);

    /**
     *  保存或更新数据
     * @author liuyang
     * @Date 2018年3月7日
     * @param lym 联运回收机实体
     * @param paramMap 参数
     * @return Map<String,String>
     * @throws Exception
     */
    Map<String,String> saveOrUpdate(HsMachineLianyun lym,Map<String,Object> paramMap) throws Exception;

    /**
     * 根据id和分站全拼获取联运回收机信息
     * @param id 联运回收机id
     * @param substationNameSpell 分站全拼
     * @return
     * @author liuyang
     */
    HsMachineLianyun selectByIdAndSubstationNameSpell(Integer id, String substationNameSpell);
}

