package com.sound.haolei.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.sound.haolei.facade.MapCountryFacade;
import com.sound.haolei.model.MapCountry;

import java.util.List;
import java.util.Map;
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class MapCountryFacadeImpl implements MapCountryFacade{
    @Override
    public Map<String, Object> selectByLikeName(String countryname) {
        return null;
    }

    @Override
    public Long queryCount(Map<String, Object> map) throws Exception {
        return null;
    }

    @Override
    public Map<String, Object> queryPageResult(Map<String, Object> map) throws Exception {
        return null;
    }

    @Override
    public List<MapCountry> selectAll() throws Exception {
        return null;
    }

    @Override
    public MapCountry selectById(Integer id) throws Exception {
        return null;
    }

    @Override
    public void update(MapCountry obj) throws Exception {

    }

    @Override
    public void save(MapCountry obj) throws Exception {

    }

    @Override
    public void batchDelete(List<Integer> ids) throws Exception {

    }

    @Override
    public List<MapCountry> selectByCondition(Map<String, Object> map) throws Exception {
        return null;
    }
}
