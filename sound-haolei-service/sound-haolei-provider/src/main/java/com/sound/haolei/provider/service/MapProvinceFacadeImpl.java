package com.sound.haolei.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.sound.haolei.facade.MapProvinceFacade;
import com.sound.haolei.model.MapCity;
import com.sound.haolei.model.MapProvince;
import com.sound.haolei.provider.dao.MapProvinceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class MapProvinceFacadeImpl implements MapProvinceFacade{
    @Autowired
    private MapProvinceMapper mapProvinceMapper;

    @Override
    public Map<String, Object> selectByLikeName(String name) {
        return null;
    }

    @Override
    public List<MapCity> selectCityListByProvinceName(String province) {
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
    public List<MapProvince> selectAll() throws Exception {

        return mapProvinceMapper.selectAll();
    }

    @Override
    public MapProvince selectById(Integer id) throws Exception {
        return null;
    }

    @Override
    public void update(MapProvince obj) throws Exception {

    }

    @Override
    public void save(MapProvince obj) throws Exception {

    }

    @Override
    public void batchDelete(List<Integer> ids) throws Exception {

    }

    @Override
    public List<MapProvince> selectByCondition(Map<String, Object> map) throws Exception {
        return null;
    }
}
