package com.sound.haolei.provider.service;


import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.sound.haolei.constants.ConstantsPointsTypeChannel;
import com.sound.haolei.constants.RedisConstants;
import com.sound.haolei.constants.ServiceCodeConstants;
import com.sound.haolei.facade.HlPointsChannelTypeFacade;
import com.sound.haolei.model.HlPointsChannelType;
import com.sound.haolei.model.HlSubstation;
import com.sound.haolei.provider.dao.HlHouseMapper;
import com.sound.haolei.provider.dao.HlPointsChannelTypeMapper;
import com.sound.haolei.provider.dao.HlSubstationMapper;
import com.sound.haolei.utils.CheckUtil;


@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class HlPointsChannelTypeFacadeImpl
		extends BaseFacadeImpl<HlPointsChannelType, HlPointsChannelTypeMapper>
			implements HlPointsChannelTypeFacade {

	@Autowired
	private HlHouseMapper hlHouseMapper;
	@Autowired
	private HlPointsChannelTypeMapper hlPointsChannelTypeMapper;

    @Autowired
    private HlSubstationMapper hlSubstationMapper;
    @Autowired
    private RedisClientTemplate redisClientTemplate;


	
	@Override
	public HlPointsChannelTypeMapper getMapper() throws Exception {
		return hlPointsChannelTypeMapper;
	}
	/**
	 * 
	* @Title: findRecyclePrice 
    * @Description: 微信公众号ID回收价格查询
	* @param publicnumberid
	* @return 参数说明
	* @author Lvshiyang
	* @date 2018年3月12日 下午6:36:39
	 */
	@Override
	public Map<String, Object> findRecyclePrice(String publicnumberid) {
		
		return null;
	}
	
	
	/**
	 * 
	* @Title: selectSubAllspellAndId 
	* @Description: 根据公众号ID查询分站全拼以及分站ID
	* @param @param publicnumberid
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2018年3月12日 下午6:45:28
	 */
	@Override
	public Map<String, Object> selectSubAllspellAndId(String publicnumberid) {
		return hlHouseMapper.selectSubAllspellAndId(publicnumberid);
	}
	/**
	 * 
	* @Title: selectByChannel 
	* @Description: 通过渠道名称查询社区积分类型
	* @param pointsChannelClothe
	* @param sid
	* @return 参数说明
	* @author Lvshiyang
	* @date 2018年3月12日 下午7:00:37
	 */
	@Override
	public Map<String, Object> selectByChannel(String channel, int substationId, String publicnumberid) {
		if(CheckUtil.isEmpty(channel)){
			return getRtnCode("渠道类型为空", ServiceCodeConstants.REQUIRED_PARAM_NULL_ILLEGAL);
		}
		if(CheckUtil.isEmpty(substationId)){
			return getRtnCode("分站id为空", ServiceCodeConstants.REQUIRED_PARAM_NULL_ILLEGAL);
		}
		// 获取分站spell
		String spell = (String)selectSubAllspellAndId(publicnumberid).get("spell");
		String spellall = "_"+spell;
		HlPointsChannelType pct = hlPointsChannelTypeMapper.selectByChannel(channel,spellall);
		if(pct == null){
			logger.error("未查询到渠道【"+channel+"】的社区积分类型");
		}
		return getSussRtn(pct);
	}



    /**
     * @Description 分页查询回收价格
     * @author sushile
     * @date 20180313
     **/
	@Override
    public String findByPage( int pageNo,int pageSize){
        PageHelper.startPage(pageNo,pageSize);
	    return  new Gson().toJson( getSussRtn("查询成功",
                        hlPointsChannelTypeMapper.searchByPage().getResult()));
    }

    /**
     * @Description 编辑回收价格提供给php
     * @author sushile
     * @date 20180312
     */
    @Override
    public String recyPriceEdit(String id,String price,String openId) {
        Map<String, Object> weChatSub = hlSubstationMapper.getHsIdAndHsSpellByWechatOfficialAccountsId(openId);
        if (weChatSub != null
                && weChatSub.containsKey("substationNameSpell")) {
            String spell = String.valueOf(weChatSub.get("substationNameSpell"));
            HlPointsChannelType hlPointsChannelType = new HlPointsChannelType();
            hlPointsChannelType.setId(Integer.parseInt(id));
            hlPointsChannelType.setPoints(Integer.parseInt(price));
            hlPointsChannelType.setSubstationNameSpell("_"+spell);
            try {
                hlPointsChannelTypeMapper.updateSupportPhp(hlPointsChannelType);
            } catch (Exception exp) {
                exp.printStackTrace();
                return new Gson().toJson(getFailRtn("更新价格失败", new ArrayList()));
            }
            return new Gson().toJson(getSussRtn("更新状态成功", new ArrayList()));
        } else {
            return new Gson().toJson(getFailRtn("未开通该分站", new ArrayList<>()));
        }
    }

    /**
     * @param channel
     * @param substationId
     * @return
     * @Description: 通过channel和分站id来找到积分(乐豆)数量
     * @author wangruwei
     * @date 2017年8月1日上午10:25:53
     */
    @Override
    public int getPointByChannel(String channel, Integer substationId) {
        Integer cashPoint = 0;
        // 获取redis中channel key
        String key = getChannelRedisKey(channel,substationId);
        // 从redis中获取
        String points = redisClientTemplate.get(key);
        if(null == points || "".equals(points)){
            // 从数据库查询
            HlSubstation substation = hlSubstationMapper.selectByPrimaryKey(substationId,"");
            String spell = "";
            if (substation !=null){
                spell = "_"+substation.getSpell();
            }
            HlPointsChannelType pct = hlPointsChannelTypeMapper.selectByChannel(channel,spell);
            if(pct != null){
                cashPoint = pct.getPoints();
                // 存入redis
                redisClientTemplate.set(key, cashPoint.toString());
                // 设置失效期7天
                redisClientTemplate.expire(key, 60 * 60 * 24 * 7);
            }
        }else{
            cashPoint = Integer.valueOf(points);
        }
        return cashPoint;
    }
    /**
     * 获取redis中channel key
     * @Title: getChannelRedisKey
     * @param channel
     * @return    设定文件
     * @return String    返回类型
     * @throws
     * @author wanghancheng
     * @date 2017年7月19日 下午3:59:33
     */
    private String getChannelRedisKey(String channel,Integer substationId){
        String key = "";
        if(ConstantsPointsTypeChannel.POINTS_CHANNEL_CLOTHE.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_CLOTHES;
        }else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_PRINT.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_PRINT;
        }else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_PLASTIC.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_PLASTIC;
        }else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_METAL.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_METAL;
        }else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_MACHINE.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_MACHINE;
        }else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_PAPER.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_PAPER;
        }else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_BOTTLE.equals(channel)){//wangyonghui add 2017-10-09 15:24:08
            key = RedisConstants.POINTS_CHANNEL_BOTTLE;
        }
        /**
         * wangruwei
         * 2017年9月8日11:19:16
         * 首次登陆部分
         */
        //首次登陆送乐豆
        else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_FIRST_LOGIN_CASH.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_FIRST_LOGIN_CASH;
        }
        //首次登陆送积分
        else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_FIRST_LOGINDESC.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_FIRST_LOGIN;
        }
        //邀请好友注册送乐豆
        else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_INVITE.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_INVITE;
        }
        //分享晒单送乐豆
        else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_SHARE.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_SHARE;
        }
        //联运回收家电乐豆/台
        else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_LIANYUN_MACHINE.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_LIANYUN_MACHINE;
        }
        //联运回收瓶子乐豆/台
        else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_LIANYUN_BOTTLE.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_LIANYUN_BOTTLE;
        }
        //联运回收纸板乐豆/公斤
        else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_LIANYUN_PAPER.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_LIANYUN_PAPER;
        }
        //联运回收衣服乐豆/公斤
        else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_LIANYUN_CLOTHE.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_LIANYUN_CLOTHE;
        }
        //联运回收塑料乐豆/公斤 wangyonghui 2017-11-01 15:48:01
        else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_LIANYUN_PLASTIC.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_LIANYUN_PLASTIC;
        }
        //联运回收金属乐豆/公斤 wangyonghui 2017-11-01 15:48:01
        else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_LIANYUN_METAL.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_LIANYUN_METAL;
        }
        //联运回收玻璃乐豆/公斤 wangyonghui 2017-11-01 15:48:01
        else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_LIANYUN_GLASS.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_LIANYUN_GLASS;
        }
        //使用智能回收箱/在线卖废品一个订单
        else if(ConstantsPointsTypeChannel.POINTS_CHANNEL_ONLINESELLORDER.equals(channel)){
            key = RedisConstants.POINTS_CHANNEL_INTELLIGENCE_ONLINESELLORDER;
        }else if( channel.equals( ConstantsPointsTypeChannel .POINTS_CHANNEL_EMS_SEND)){
            key = RedisConstants.POINTS_CHANNEL_EMS_SEND;   /** APP下单寄快递送积分 */
        }else if( channel.equals(ConstantsPointsTypeChannel.POINTS_CHANNEL_EMS_RECEIVE)){
            key = RedisConstants.POINTS_CHANNEL_EMS_RECEIVE;/** 服务亭代收快递送积分*/
        }else{
            key = channel +":"+substationId;
        }
        return replaceKey(key, "\\$\\{substationId\\}", substationId.toString());
    }

}
