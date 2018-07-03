package com.sound.haolei.facade;

import java.util.List;
import java.util.Map;
import com.sound.haolei.model.MapCity;
import com.sound.haolei.model.MapCountry;

public interface MapCityFacade extends BaseFacade<MapCity> {


    /**
     * @author sushile
     * @Description 根据城市名称模糊查询城市id
     * @param name
     * @return
     */
    Map<String,Object> selectByLikeName( String name );

    /**
     * 根据市的名称找出对应县的列表，传中文回显专用
     * @author wangruwei
     * @date2017年6月22日14:29:58
     * @param city
     * @return
     */
    List<MapCountry> selectCountryListByCityName(String city);
}

