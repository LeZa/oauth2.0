package com.sound.haolei.provider.dao;

import com.sound.haolei.model.MapProvince;

import java.util.List;

public interface MapProvinceMapper extends IBaseMapper<MapProvince>{

    List<MapProvince> selectAll();
}
