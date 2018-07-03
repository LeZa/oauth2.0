package com.sound.haolei.consumer.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.config.annotation.Reference;
import com.sound.haolei.facade.HlHouseFacade;

@RestController
@RequestMapping("house")
public class HlHouseController{
	
	private static Logger logger = LoggerFactory.getLogger(HlSubstationController.class);
	@Reference(version = "1.0.0",application = "${dubbo.application.id}",url = "dubbo://localhost:12345")
	private HlHouseFacade hlHouseFacade;
	/**
	 * 
	* @Title: selectareabypcc 
	* @Description:  预约上门回收小区查询接口
	* @param @param publicnumberid
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月7日 下午5:52:53
	 */
    @RequestMapping( value="/selectareabypcc")
	@ResponseBody
	public Map<String,Object> selectAreaByPCC(@RequestParam(required = true) String publicnumberid){
    	Map<String,Object> resultMap = null;
    	try {
    		resultMap = hlHouseFacade.selectAreaByPCC(publicnumberid);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("请求异常");
		}
		return resultMap;
	}
    /**
     * 
    * @Title: selectcanappointmenthouse 
    * @Description: 预约上门回收服务亭查询接口
    * @param @param cid
    * @param @return    设定文件 
    * @return Map<String,Object>    返回类型 
    * @throws 
    * @author Lvshiyang
    * @date 2018年3月8日 下午6:26:21
     */
    @RequestMapping( value="/selectcanappointmenthouse")
	@ResponseBody
    public Map<String,Object> selectCanAppointmentHouse(@RequestParam(required = true) String publicnumberid,
    		@RequestParam(required = true) String countyId){
    	Map<String,Object> resultMap = null;
    	try {
    		resultMap = hlHouseFacade.selectCanAppointmentHouse(publicnumberid,countyId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("请求异常！");
		}
		return resultMap;
    }
}

