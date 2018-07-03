package com.sound.haolei.consumer.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.config.annotation.Reference;
import com.sound.haolei.constants.ConstantsPointsTypeChannel;
import com.sound.haolei.facade.HlPointsChannelTypeFacade;
import com.sound.haolei.facade.HlSubstationFacade;
import com.sound.haolei.model.HlPointsChannelType;
import com.sound.haolei.utils.CheckUtil;


@Controller
@RequestMapping(value = "/recycle")
public class HlPointsChannelTypeController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(HlSubstationController.class);
	
    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "dubbo://localhost:12345",timeout=100000)
	private HlPointsChannelTypeFacade hlPointsChannelTypeFacade;
    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "dubbo://localhost:12345",timeout=100000)
    private HlSubstationFacade hlSubstationFacade;
	
    /**
     * 
    * @Title: findRecyclePrice 
    * @Description: 微信公众号ID回收价格查询
    * @param @param publicnumberid
    * @param @return    设定文件 
    * @return Map<String,Object>    返回类型 
    * @throws 
    * @author Lvshiyang
    * @date 2018年3月12日 下午6:33:31
     */
    @RequestMapping("findrecycleprice")
    @ResponseBody
    public Map<String,Object> findRecyclePrice(@RequestParam(required = true) String publicnumberid, @RequestParam(required = true) Integer stype){
    	
    	if(CheckUtil.isEmpty(publicnumberid)){
    		return getRtnCode("", "公众号ID不能为空", 1013);
    	}
    	if(CheckUtil.isEmpty(stype)){
    		return getRtnCode("","查询分类标识不能为空",1013);
    	}
    	Map<String, String> map = hlSubstationFacade.selectTypeByPublicNumberId(publicnumberid);
		if(CheckUtil.isEmpty(map)){
			return getRtnCode("", "公众号ID不存在！", 1014);
		}
		
		
    	Map<String,Object> resultMap = new HashMap<String,Object>();
    	try {
    		Object id = hlPointsChannelTypeFacade.selectSubAllspellAndId(publicnumberid).get("id");
    		int sid = Integer.parseInt(String.valueOf(id));//分站id
    		if(stype == 1){
    			Map<String,Object> clotheMap = hlPointsChannelTypeFacade.selectByChannel(ConstantsPointsTypeChannel.POINTS_CHANNEL_CLOTHE,sid,publicnumberid);//衣物
    			Map<String,Object> printMap = hlPointsChannelTypeFacade.selectByChannel(ConstantsPointsTypeChannel.POINTS_CHANNEL_PRINT,sid,publicnumberid);//印刷品
    			Map<String,Object> plasticMap = hlPointsChannelTypeFacade.selectByChannel(ConstantsPointsTypeChannel.POINTS_CHANNEL_PLASTIC,sid,publicnumberid);//塑料
    			Map<String,Object> metalMap = hlPointsChannelTypeFacade.selectByChannel(ConstantsPointsTypeChannel.POINTS_CHANNEL_METAL,sid,publicnumberid);//金属
    			Map<String,Object> machineMap = hlPointsChannelTypeFacade.selectByChannel(ConstantsPointsTypeChannel.POINTS_CHANNEL_MACHINE,sid,publicnumberid);//家电
    			Map<String,Object> paperMap = hlPointsChannelTypeFacade.selectByChannel(ConstantsPointsTypeChannel.POINTS_CHANNEL_PAPER,sid,publicnumberid);//纸张
    			Map<String,Object> bottleMap = hlPointsChannelTypeFacade.selectByChannel(ConstantsPointsTypeChannel.POINTS_CHANNEL_BOTTLE,sid,publicnumberid);//饮料瓶
    			
    			if( clotheMap != null && clotheMap.containsKey("code")){
    				int code = (int) clotheMap.get("code");
    				if( code == 0 ){
    					if( clotheMap.containsKey("data") ){
    						HlPointsChannelType hpct = (HlPointsChannelType) clotheMap.get("data");
    						if( hpct != null){
    							HashMap<String, Object> paramMap = new HashMap<String, Object>();
    							if(hpct.getChannel().equals("服务亭回收衣服乐豆/公斤")){
    								paramMap.put("name", "衣服");
    								paramMap.put("unit ", "公斤");
    							}
    							paramMap.put("points", hpct.getPoints() == null?0:hpct.getPoints());
    							resultMap.put("clothe", paramMap);
    						}
    					}
    				}
    			}
    			if( printMap != null && printMap.containsKey("code")){
    				int code = (int) printMap.get("code");
    				if( code == 0 ){
    					if( printMap.containsKey("data") ){
    						HlPointsChannelType hpct = (HlPointsChannelType) printMap.get("data");
    						if( hpct != null){
    							HashMap<String, Object> paramMap = new HashMap<String, Object>();
    							if(hpct.getChannel().equals("服务亭回收印刷品乐豆/公斤")){
    								paramMap.put("name", "印刷品");
    								paramMap.put("unit ", "公斤");
    							}
    							paramMap.put("points", hpct.getPoints() == null?0:hpct.getPoints());
    							resultMap.put("print", paramMap);
    						}
    					}
    				}
    			}
    			if( plasticMap != null && plasticMap.containsKey("code")){
    				int code = (int) plasticMap.get("code");
    				if( code == 0 ){
    					if( plasticMap.containsKey("data") ){
    						HlPointsChannelType hpct = (HlPointsChannelType) plasticMap.get("data");
    						if( hpct != null){
    							HashMap<String, Object> paramMap = new HashMap<String, Object>();
    							if(hpct.getChannel().equals("服务亭回收塑料乐豆/公斤")){
    								paramMap.put("name", "塑料");
    								paramMap.put("unit ", "公斤");
    							}
    							paramMap.put("points", hpct.getPoints() == null?0:hpct.getPoints());
    							resultMap.put("plastic", paramMap);
    						}
    					}
    				}
    			}
    			if( metalMap != null && metalMap.containsKey("code")){
    				int code = (int) metalMap.get("code");
    				if( code == 0 ){
    					if( clotheMap.containsKey("data") ){
    						HlPointsChannelType hpct = (HlPointsChannelType) metalMap.get("data");
    						if( hpct != null){
    							HashMap<String, Object> paramMap = new HashMap<String, Object>();
    							if(hpct.getChannel().equals("服务亭回收金属乐豆/公斤")){
    								paramMap.put("name", "金属");
    								paramMap.put("unit ", "公斤");
    							}
    							paramMap.put("points", hpct.getPoints() == null?0:hpct.getPoints());
    							resultMap.put("metal", paramMap);
    						}
    					}
    				}
    			}
    			if( machineMap != null && machineMap.containsKey("code")){
    				int code = (int) machineMap.get("code");
    				if( code == 0 ){
    					if( clotheMap.containsKey("data") ){
    						HlPointsChannelType hpct = (HlPointsChannelType) machineMap.get("data");
    						if( hpct != null){
    							HashMap<String, Object> paramMap = new HashMap<String, Object>();
    							if(hpct.getChannel().equals("服务亭回收家电乐豆/台")){
    								paramMap.put("name", "家电");
    								paramMap.put("unit ", "台");
    							}
    							paramMap.put("points", hpct.getPoints() == null?0:hpct.getPoints());
    							resultMap.put("machine", paramMap);
    						}
    					}
    				}
    			}
    			if( paperMap != null && paperMap.containsKey("code")){
    				int code = (int) paperMap.get("code");
    				if( code == 0 ){
    					if( paperMap.containsKey("data") ){
    						HlPointsChannelType hpct = (HlPointsChannelType) paperMap.get("data");
    						if( hpct != null){
    							HashMap<String, Object> paramMap = new HashMap<String, Object>();
    							if(hpct.getChannel().equals("服务亭回收纸板乐豆/公斤")){
    								paramMap.put("name", "纸板");
    								paramMap.put("unit ", "公斤");
    							}
    							paramMap.put("points", hpct.getPoints() == null?0:hpct.getPoints());
    							resultMap.put("paper", paramMap);
    						}
    					}
    				}
    			}
    			if(bottleMap != null && bottleMap.containsKey("code")){
    				int code = (int) bottleMap.get("code");
    				if( code == 0 ){
    					if( bottleMap.containsKey("data") ){
    						HlPointsChannelType hpct = (HlPointsChannelType) bottleMap.get("data");
    						if( hpct != null){
    							HashMap<String, Object> paramMap = new HashMap<String, Object>();
    							if(hpct.getChannel().equals("服务亭回收饮料瓶乐豆/个")){
    								paramMap.put("name", "饮料瓶");
    								paramMap.put("unit ", "个");
    							}
    							paramMap.put("points", hpct.getPoints() == null?0:hpct.getPoints());
    							resultMap.put("bottle", paramMap);
    						}
    					}
    				}
    			}
    		}
    		if(stype == 2){
    			Map<String,Object> lianyunPlasticMap = hlPointsChannelTypeFacade.selectByChannel(ConstantsPointsTypeChannel.POINTS_CHANNEL_LIANYUN_PLASTIC,sid,publicnumberid);//智能回收塑料
    			Map<String,Object> lianyunMetalMap = hlPointsChannelTypeFacade.selectByChannel(ConstantsPointsTypeChannel.POINTS_CHANNEL_LIANYUN_METAL,sid,publicnumberid);//智能回收金属
    			Map<String,Object> lianyunGlassMap = hlPointsChannelTypeFacade.selectByChannel(ConstantsPointsTypeChannel.POINTS_CHANNEL_LIANYUN_GLASS,sid,publicnumberid);//智能回收玻璃
    			
    			if(lianyunPlasticMap != null && lianyunPlasticMap.containsKey("code")){
    				int code = (int) lianyunPlasticMap.get("code");
    				if( code == 0 ){
    					if( lianyunPlasticMap.containsKey("data") ){
    						HlPointsChannelType hpct = (HlPointsChannelType) lianyunPlasticMap.get("data");
    						if( hpct != null){
    							HashMap<String, Object> paramMap = new HashMap<String, Object>();
    							if(hpct.getChannel().equals("联运回收塑料乐豆/公斤")){
    								paramMap.put("name", "塑料");
    								paramMap.put("unit ", "公斤");
    							}
    							paramMap.put("points", hpct.getPoints() == null?0:hpct.getPoints());
    							resultMap.put("plastic", paramMap);
    						}
    					}
    				}
    			}
    			if(lianyunMetalMap != null && lianyunMetalMap.containsKey("code")){
    				int code = (int) lianyunMetalMap.get("code");
    				if( code == 0 ){
    					if( lianyunMetalMap.containsKey("data") ){
    						HlPointsChannelType hpct = (HlPointsChannelType) lianyunMetalMap.get("data");
    						if( hpct != null){
    							HashMap<String, Object> paramMap = new HashMap<String, Object>();
    							if(hpct.getChannel().equals("联运回收金属乐豆/公斤")){
    								paramMap.put("name", "金属");
    								paramMap.put("unit ", "公斤");
    							}
    							paramMap.put("points", hpct.getPoints() == null?0:hpct.getPoints());
    							resultMap.put("metal", paramMap);
    						}
    					}
    				}
    			}
    			if(lianyunGlassMap != null && lianyunGlassMap.containsKey("code")){
    				int code = (int) lianyunGlassMap.get("code");
    				if( code == 0 ){
    					if( lianyunGlassMap.containsKey("data") ){
    						HlPointsChannelType hpct = (HlPointsChannelType) lianyunGlassMap.get("data");
    						if( hpct != null){
    							HashMap<String, Object> paramMap = new HashMap<String, Object>();
    							if(hpct.getChannel().equals("联运回收玻璃乐豆/公斤")){
    								paramMap.put("name", "玻璃");
    								paramMap.put("unit ", "公斤");
    							}
    							paramMap.put("points", hpct.getPoints() == null?0:hpct.getPoints());
    							resultMap.put("glass", paramMap);
    						}
    					}
    				}
    			}
    		}
    		if(stype == 3){
    			
    		}
    		
    		
    		
		} catch (Exception e) {
			e.getStackTrace();
			logger.debug("请求异常");
			return getFailRtn("请求异常");
		}
		return getSuccessRtn(resultMap);
    }
}

