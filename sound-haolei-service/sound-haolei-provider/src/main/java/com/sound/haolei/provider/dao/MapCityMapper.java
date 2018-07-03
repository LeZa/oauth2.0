package com.sound.haolei.provider.dao;


import com.sound.haolei.model.MapCity;
import org.apache.ibatis.annotations.Param;


public interface MapCityMapper extends IBaseMapper<MapCity>{

    /**
     * @author sushile
     * @Description 根据城市名称查询城市id
     * @param name
     * @return
     */
    MapCity selectByLikeName( @Param("name")String name);

    /**
     *
     * @Title: selectByProvinceNameAndCityName
     * @Description: 根据省份城市名查询当前的城市
     * @param receiverProvice
     * @param receiverCity
     * @return    设定文件
     * MapCity    返回类型
     * @throws
     * @author tianyunyun
     * @date 2017年7月5日 下午5:32:46
     */
    MapCity selectByProvinceNameAndCityName(@Param("provinceName")String receiverProvice, @Param("cityName")String receiverCity);
}
