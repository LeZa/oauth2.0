package com.sound.haolei.facade;

import java.util.List;
import java.util.Map;

import com.sound.haolei.model.MapCity;
import com.sound.haolei.model.MapProvince;

public interface MapProvinceFacade extends BaseFacade<MapProvince> {

    Map<String, Object> selectByLikeName(String name);
    /**
     * 根据省名称查找市列表，传中文回显专用
     * @author wangruwei
     * @date2017年6月22日14:26:02
     * @param province
     * @return
     */
    List<MapCity> selectCityListByProvinceName(String province);

}

