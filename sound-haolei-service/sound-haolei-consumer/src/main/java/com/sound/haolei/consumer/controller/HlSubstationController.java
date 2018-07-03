package com.sound.haolei.consumer.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.config.annotation.Reference;
import com.sound.haolei.facade.HlSubstationFacade;

@RestController
@RequestMapping("hlSubstation")
public class HlSubstationController {
	private static Logger logger = LoggerFactory.getLogger(HlSubstationController.class);

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345")
    private HlSubstationFacade hlSubstationFacade;
    /**
     * 
    * @Title: ban 
    * @Description: 注册页面-根据公众号ID查询省市接口
    * @param @param name
    * @param @return
    * @param @throws Exception    设定文件 
    * @return Map<String,Object>    返回类型 
    * @throws 
    * @author Lvshiyang
    * @date 2018年3月5日 下午7:50:39
     */
    @RequestMapping("selectprovincecitybypublicnumberid")
    @ResponseBody
    public Map<String,Object> selectProvinceCityByPublicNumberId(@RequestParam(required = true) String publicnumberid){
    	Map<String, Object> provinceCity = null;
    	try {
    		provinceCity = hlSubstationFacade.selectProvinceCityByPublicNumberId(publicnumberid);
		} catch (Exception e) {
			logger.debug("请求异常！");
			e.printStackTrace();
		}
		return provinceCity;
    }
}
