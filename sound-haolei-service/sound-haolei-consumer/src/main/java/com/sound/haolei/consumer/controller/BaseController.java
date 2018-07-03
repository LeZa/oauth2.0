package com.sound.haolei.consumer.controller;

import com.sound.haolei.constants.ServiceCodeConstants;
import com.sound.haolei.facade.BaseFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有controller的基类，用来写公用方法
 * 
 * @author liuyang
 *
 */
public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(BaseController.class);

	/**
	 * 根据service类返回列表显示的JSON数据； 包括第一次查询和分页查询
	 * 
	 * @param ibs
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getPageResult(BaseFacade ibs, Map map) throws Exception {
		return ibs.queryPageResult(map);
	}

	/**
	 * 获取失败的返回内容
	 * 
	 * @param msg
	 * @author chenrui
	 * @return
	 */
	protected Map<String, Object> getFailRtn(String msg) {
		Map<String, Object> rtn = new HashMap<String, Object>(16);
		rtn.put("code", ServiceCodeConstants.FAIL_RTN);
		rtn.put("msg", msg);
		rtn.put("data", null);
		return rtn;
	}

	/**
	 * 获取成功返回
	 * 
	 * @param data
	 * @return
	 * @author tianyunyun
	 * @date 2016年11月4日下午12:15:48
	 */
	protected Map<String, Object> getSuccessRtn(Object data) {
		Map<String, Object> rtn = new HashMap<String, Object>(16);
		rtn.put("code", ServiceCodeConstants.SUCCESS_RTN);
		rtn.put("msg", "");
		rtn.put("data", data);
		return rtn;
	}

	/**
	 * 获取成功返回
	 * 
	 * @param data
	 * @return
	 * @author tianyunyun
	 * @date 2016年11月4日下午12:15:48
	 */
	protected Map<String, Object> getSuccessRtn(Object data, String msg) {
		Map<String, Object> rtn = new HashMap<String, Object>(16);
		rtn.put("code", ServiceCodeConstants.SUCCESS_RTN);
		rtn.put("msg", msg);
		rtn.put("data", data);
		return rtn;
	}

	/**
	 * 具体业务状态码返回体封装方法
	 * 
	 * @return
	 * @date 2016年12月2日
	 * @author tianyunyn
	 */
	protected Map<String, Object> getRtnCode(Object data, String msg, Integer code) {
		Map<String, Object> rtn = new HashMap<String, Object>(16);
		rtn.put("code", code);
		rtn.put("msg", msg);
		rtn.put("data", data);
		return rtn;
	}

}
