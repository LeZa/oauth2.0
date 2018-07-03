package com.sound.haolei.provider.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sound.haolei.utils.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.sound.haolei.facade.HlHouseFacade;
import com.sound.haolei.model.HlHouse;
import com.sound.haolei.provider.dao.HlHouseMapper;
import com.sound.haolei.provider.dao.HlSubstationMapper;
import com.sound.haolei.provider.util.ResultDataMap;
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class HlHouseFacadeImpl extends BaseFacadeImpl<HlHouse,HlHouseMapper> implements HlHouseFacade {
			
	@Autowired
	private HlHouseMapper hlHouseMapper;
	@Autowired
	private HlSubstationMapper hlSubstationMapper;

	@Override
	public Long queryCount(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> queryPageResult(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HlHouse> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HlHouse selectById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(HlHouse obj) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void save(HlHouse obj) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void batchDelete(List<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public List<HlHouse> selectByCondition(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	* @Title: selectAreaByPCC 
	* @Description: 预约上门回收小区查询接口
	* @return 参数说明
	* @author Lvshiyang
	* @date 2018年3月7日
	 */
	@Override
	public Map<String, Object> selectAreaByPCC(String publicnumberid){
		Map<String, Object> readyMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(CheckUtil.isEmpty(publicnumberid)){
			return ResultDataMap.getRtnCode("", "公众号ID不能为空", 1013);
		}
		publicnumberid = publicnumberid.trim();
		Map<String,String> typemid = hlSubstationMapper.selectTypeByPublicNumberId(publicnumberid);
		if(CheckUtil.isEmpty(typemid)){
			return ResultDataMap.getRtnCode("", "公众号ID不存在！", 1014);
		}
		Integer type = Integer.parseInt(String.valueOf(typemid.get("type")));
		Integer mid = Integer.parseInt(String.valueOf(typemid.get("mid")));
		if(type.equals(0)){
			readyMap = hlSubstationMapper.selectProvinceCityByPublicNumberId1(publicnumberid,mid);
			Integer cid = Integer.parseInt(String.valueOf(readyMap.get("cid")));
			List<Map<String,Object>> countyList = hlSubstationMapper.selectCountyList(cid);
			resultMap.put("pid", readyMap.get("pid"));
			resultMap.put("province", readyMap.get("province"));
			resultMap.put("cid", readyMap.get("cid"));
			resultMap.put("city", readyMap.get("city"));
			resultMap.put("countyList", countyList);
			return ResultDataMap.getRtnCode(resultMap, "", 0);
		}
		if(type.equals(1)){
			Map<String, Object> cityInfomap = hlSubstationMapper.selectCityInfo(String.valueOf(typemid.get("mid")));
			String citymid = String.valueOf(cityInfomap.get("id"));
			String city = cityInfomap.get("name").toString();
			Map<String,Object> pmap = hlSubstationMapper.selectProvinceCityByPublicNumberId2(citymid);
			readyMap.put("pid", pmap.get("pid"));
			readyMap.put("province", pmap.get("province"));
			readyMap.put("cid", citymid);
			readyMap.put("city", city);
			List<Map<String,Object>> countyList = hlSubstationMapper.selectCountyList(Integer.parseInt(citymid));
			readyMap.put("countyList", countyList);
			return ResultDataMap.getRtnCode(readyMap, "", 0);
		}
		return ResultDataMap.getRtnCode(readyMap, "请求异常！", -1);
	}

	@Override
	public HlHouseMapper getMapper() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	* @Title: selectCanAppointmentHouse 
	* @Description: TODO(预约上门回收服务亭查询接口) 
	* @param publicnumberid
	* @param countyId
	* @return 参数说明
	* @author Lvshiyang
	* @date 2018年3月8日 下午8:49:09
	 */
	@Override
	public Map<String, Object> selectCanAppointmentHouse(String publicnumberid, String countyId) {
		if(CheckUtil.isEmpty(publicnumberid)){
			return getRtnCode("公众号ID不能为空",1013);
		}
		if(CheckUtil.isEmpty(countyId)){
			return getRtnCode("所在区或县的ID不能为空",1013);
		}
		String allSpell = hlHouseMapper.selectSubstationAllspell(publicnumberid);
		List<Map<String,Object>> houseList = hlHouseMapper.selectCanAppointmentHouse(allSpell,countyId);
		return getSussRtn(houseList);
	}

}
