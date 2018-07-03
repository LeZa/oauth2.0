package com.sound.haolei.provider.dao;


import com.sound.haolei.model.HlUser;
import org.apache.ibatis.annotations.Param;

public interface HlUserMapper extends IBaseMapper<HlUser>{

    HlUser selectByPrimaryKey(int id);


    /**
     * @Description 根据手要机号查询
     * @param mobile
     * @return
     */
    HlUser selectByMobile(String mobile);
    /**
     * 查询用户所在小区名称
     * @Title: selectUserHouseName
     * @param substationNameSpell 分站名称全拼
     * @param houseId 小区id，即服务亭id
     * @return
     * @author wangyonghui
     * @date 2017年9月1日 下午3:22:05
     */
    String selectUserHouseName(@Param("substationNameSpell")String substationNameSpell, @Param("houseId")Integer houseId);
    /**
     * 查询用户所在小区分站名称全拼
     * @Title: selectUserHouseSubstationNameSpell
     * @param houseId 小区id，即服务亭id
     * @return
     * @author wangyonghui
     * @date 2017年9月1日 下午3:16:12
     */
    String selectUserHouseSubstationNameSpell(@Param("houseId")Integer houseId);
}