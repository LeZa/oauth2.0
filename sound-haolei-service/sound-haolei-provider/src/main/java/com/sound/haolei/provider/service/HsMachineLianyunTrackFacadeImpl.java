package com.sound.haolei.provider.service;

import com.sound.haolei.facade.HsMachineLianyunTrackFacade;
import com.sound.haolei.model.HsMachineLianyunTrack;
import com.sound.haolei.provider.dao.HsMachineLianyunTrackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;

import java.util.List;
import java.util.Map;

@com.alibaba.dubbo.config.annotation.Service(
		version = "1.0.0",
		application = "${dubbo.application.id}",
		protocol = "${dubbo.protocol.id}",
		registry = "${dubbo.registry.id}"
)
public class HsMachineLianyunTrackFacadeImpl extends
		BaseFacadeImpl<HsMachineLianyunTrack, HsMachineLianyunTrackMapper>
		implements HsMachineLianyunTrackFacade {

	final static Logger logger = LoggerFactory.getLogger(HsMachineLianyunTrackFacadeImpl.class);
	@Autowired
	private HsMachineLianyunTrackMapper hsMachineLianyunTrackMapper;
	/*@Override
	public HsMachineLianyunTrackMapper getMapper() throws Exception {
		return this.hsMachineLianyunTrackMapper;
	}*/


	@Override
	public HsMachineLianyunTrackMapper getMapper() throws Exception {
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
	public List<HsMachineLianyunTrack> selectAll() throws Exception {
		return null;
	}

	@Override
	public HsMachineLianyunTrack selectById(Integer id) throws Exception {
		return null;
	}

	@Override
	public void update(HsMachineLianyunTrack obj) throws Exception {

	}

	@Override
	public void save(HsMachineLianyunTrack obj) throws Exception {

	}

	@Override
	public void batchDelete(List<Integer> ids) throws Exception {

	}

	@Override
	public List<HsMachineLianyunTrack> selectByCondition(Map<String, Object> map) throws Exception {
		return null;
	}
}
