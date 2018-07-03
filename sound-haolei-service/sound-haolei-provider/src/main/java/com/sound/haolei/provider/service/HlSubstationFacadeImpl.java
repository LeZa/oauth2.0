package com.sound.haolei.provider.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sound.haolei.utils.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.sound.haolei.facade.HlSubstationFacade;
import com.sound.haolei.model.HlSubstation;
import com.sound.haolei.provider.dao.HlSubstationMapper;
import com.sound.haolei.provider.util.ResultDataMap;

@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class HlSubstationFacadeImpl implements HlSubstationFacade {
			
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
	public List<HlSubstation> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HlSubstation selectById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(HlSubstation obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(HlSubstation obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchDelete(List<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HlSubstation> selectByCondition(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	* @Title: selectProvinceCityByPublicNumberId 
    * @Description: 注册页面-根据公众号ID查询省市接口
	* @param publicnumberid
	* @return 参数说明
	* @author Lvshiyang
	* @date 2018年3月5日
	 */
	@Override
	public Map<String, Object> selectProvinceCityByPublicNumberId(String publicnumberid) {
		if(CheckUtil.isEmpty(publicnumberid)){
			return ResultDataMap.getRtnCode("", "公众号ID不能为空！", 1013);
		}
		publicnumberid = publicnumberid.trim();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String,String> typemid = selectTypeByPublicNumberId(publicnumberid);
		if(CheckUtil.isEmpty(typemid)){
			return ResultDataMap.getRtnCode("", "公众号ID不存在！", 1014);
		}
		Integer type = Integer.parseInt(String.valueOf(typemid.get("type")));
		Integer mid = Integer.parseInt(String.valueOf(typemid.get("mid")));
		if(type.equals(0)){
			resultMap = hlSubstationMapper.selectProvinceCityByPublicNumberId1(publicnumberid,mid);
			return ResultDataMap.getRtnCode(resultMap, "", 0);
		}
		if(type.equals(1)){
			Map<String, Object> cityInfomap = hlSubstationMapper.selectCityInfo(String.valueOf(typemid.get("mid")));
			String cid = String.valueOf(cityInfomap.get("id"));
			String city = cityInfomap.get("name").toString();
			Map<String,Object> pmap = hlSubstationMapper.selectProvinceCityByPublicNumberId2(cid);
			resultMap.put("pid", pmap.get("pid"));
			resultMap.put("province", pmap.get("province"));
			resultMap.put("cid", cid);
			resultMap.put("city", city);
			return ResultDataMap.getRtnCode(resultMap, "", 0);
		}
//		if(type.equals(-1)){
//			resultMap = hlSubstationMapper.selectProvinceCityByPublicNumberId3(publicnumberid,mid);
//		}
		return ResultDataMap.getRtnCode(resultMap, "请求异常！", -1);
	}
	/**
	 * 通过微信公众号id查询分站id和分站全拼
	 * @param wechatOfficialAccountsId 公众号id
	 * @return
	 * @author liuyang
	 */
	@Override
	public Map<String, Object> getHsIdAndHsSpellByWechatOfficialAccountsId(String wechatOfficialAccountsId) {
		return hlSubstationMapper.getHsIdAndHsSpellByWechatOfficialAccountsId(wechatOfficialAccountsId);
	}

	/**
	 * 
	* @Title: selectTypeByPublicNumberId 
	* @Description: 根据公众号ID查询所在站是什么分站？[县级:1市级:0默认站:-1]
	* @param @param publicnumberid
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月6日 下午12:11:10
	 */
	public Map<String, String> selectTypeByPublicNumberId(String publicnumberid) {
		return hlSubstationMapper.selectTypeByPublicNumberId(publicnumberid);
	}
	
}
