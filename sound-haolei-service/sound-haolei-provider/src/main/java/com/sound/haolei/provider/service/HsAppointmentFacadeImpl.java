package com.sound.haolei.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.sound.haolei.dto.AppointmentDto;
import com.sound.haolei.facade.HsAppointmentFacade;
import com.sound.haolei.model.HlUser;
import com.sound.haolei.model.HsAppointment;

import com.sound.haolei.model.HsMachineLianyunCard;
import com.sound.haolei.provider.dao.*;
import com.sound.haolei.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import sun.awt.geom.AreaOp;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class HsAppointmentFacadeImpl extends BaseFacadeImpl
            implements HsAppointmentFacade  {

	@Autowired
	private HsAppointmentMapper hsAppointmentMapper;

	@Autowired
    private HlSubstationMapper hlSubstationMapper;

	@Autowired
    private HlUserMapper hlUserMapper;

	@Autowired
    private HsMachineLianyunTrackMapper hsMachineLianyunTrackMapper;

	@Autowired
    private HsMachineLianyunCardMapper hsMachineLianyunCardMapper;

    /**
     * @Description 保存上门回收
     * @author sushile
     * @date 20180308
     * @return
     */
	@Override
    public String saveAppointment(AppointmentDto dto) {
        Map<String,Object>  weChatSub = hlSubstationMapper.getHsIdAndHsSpellByWechatOfficialAccountsId( dto.getOpenId() );
        if( weChatSub != null
                && weChatSub.containsKey("substationId") ){
            String subId  = String.valueOf( weChatSub.get("substationId") );
            HlUser hlUser = hlUserMapper.selectByMobile(dto.getMobile() );
            if( hlUser != null
                    && hlUser.getId() != 0) {
                HsAppointment hsAppointment = new HsAppointment();
                hsAppointment.setSubstationId(Integer.parseInt(subId));
                hsAppointment.setAppointmentName(dto.getName());
                hsAppointment.setAddress(dto.getAddress());
                hsAppointment.setProvinceId(Integer.parseInt(dto.getProvinceId()));
                hsAppointment.setCityId(Integer.parseInt(dto.getCityId()));
                hsAppointment.setCountyId(Integer.parseInt(dto.getCountyId()));
                hsAppointment.setAppointmentMobile(dto.getMobile());
                hsAppointment.setDescription("预约上门回收");
                hsAppointment.setStatus(new Byte("0"));
                hsAppointment.setRemark("预约上门回收");
                hsAppointment.setType1(0L);
                hsAppointment.setType2(0L);
                hsAppointment.setType3(0L);
                hsAppointment.setType4(0L);
                hsAppointment.setType5(0L);
                hsAppointment.setType6(0L);
                hsAppointment.setType7(0L);
                hsAppointment.setType8(0L);
                hsAppointment.setType9(0L);
                hsAppointment.setPayType(new Byte("0"));
                hsAppointment.setPayNum(new BigDecimal(0));
                hsAppointment.setCuser(hlUser.getId());

                int areaId = Integer.parseInt(dto.getAreaId());
                hsAppointment.setAreaId(areaId);
                int houseId = Integer.parseInt(dto.getHouseId());
                hsAppointment.setHouseId(houseId);
                try {
                    Date startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dto.getStartTime());
                    Date endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dto.getEndTime());
                    hsAppointment.setStarttime(startTime);
                    hsAppointment.setEndtime(endTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String typeStr = "";
                for (String type : dto.getType()) {
                    typeStr = typeStr + type + ",";
                }
                hsAppointment.setType(typeStr);
                hsAppointment.setCtime(new Date());

                try {
                    hsAppointmentMapper.insertSelective(hsAppointment);
                } catch (Exception exp) {
                    exp.printStackTrace();
                    return new Gson().toJson(getFailRtn("预约上门失败", new ArrayList()));
                }
                return new Gson().toJson(getSussRtn("预约上门成功", new ArrayList()));
            }else{
                return new Gson().toJson( getFailRtn("未查询到该用户",new ArrayList<>()));
            }
        }else{
            return new Gson().toJson( getFailRtn("未开通该分站",new ArrayList<>()));
        }
    }


    /**
     * @Description 根据手机号和公众号查询
     * @author sushile
     * @date 20180308
     * @return
     */
    @Override
    public String selectByMobileOpenId( String mobile,String openId ){
       Map<String,Object>  weChatSub = hlSubstationMapper.getHsIdAndHsSpellByWechatOfficialAccountsId(openId);
       Map<String,Object>  resultMap = new HashMap<String,Object>();
       if( weChatSub != null
               && weChatSub.containsKey("substationId") ){
                String subId  = String.valueOf( weChatSub.get("substationId") );
                HlUser hlUser = hlUserMapper.selectByMobile( mobile );
                if( hlUser != null
                        && hlUser.getId() != null){
                        int id = hlUser.getId();
                        String firstDayOfMonth = DateUtil.firstDayOfMonth()+" 00:00:00";
                        String lastDayOfMonth = DateUtil.lastDayOfMonth()+" 23:59:59";
                        String weight =  hsMachineLianyunTrackMapper.selectTrackByUserId( String.valueOf(id),subId,firstDayOfMonth,lastDayOfMonth);
                        resultMap.put("cashPoint", hlUser.getCashPoints());
                        if( weight != null) {
                            resultMap.put("weight", weight);
                        }else{
                            resultMap.put("weight", 0);
                        }
                        return new Gson().toJson(getSussRtn("查询成功",resultMap));
                }else{
                    return new Gson().toJson( getFailRtn("未查询到该用户",new ArrayList()));
                }
       }else{
           return new Gson().toJson( getFailRtn("未开通该分站",new ArrayList<>()));
       }
    }

    /**
     * @Description 上门回收记录
     * @author  sushile
     * @date 20180309
     */
    @Override
    public String selectHomeRecy(String mobile, String openId,int currentPage,int pageSize) {
        Map<String,Object>  weChatSub = hlSubstationMapper.getHsIdAndHsSpellByWechatOfficialAccountsId(openId);
        if( weChatSub != null
                && weChatSub.containsKey("substationId") ){
                    String subId  = String.valueOf( weChatSub.get("substationId") );
                    Map<String,Object> resultMap = new HashMap<String,Object>();
                    resultMap.put("mobile",mobile);
                    resultMap.put("substationId",subId);
                    PageHelper.startPage(currentPage,pageSize);
                    List<Map<String,Object>> resultList =  hsAppointmentMapper.selectByAppointmentMobile(resultMap);
                    if( resultList != null
                                && resultList.size() > 0 ){
                        return new Gson().toJson(getSussRtn("查询成功",resultList));
                    }else{
                        return new Gson().toJson(getSussRtn("查询成功",new ArrayList()));
                    }
        }else{
            return new Gson().toJson( getFailRtn("未开通该分站",new ArrayList<>()));
        }
    }

    /**
     * @Description 智能回收记录
     * @author sushile
     * @date 20180309
     * @return
     */
    @Override
    public String selectMachineRecy(String mobile, String openId,int currentPage,int pageSize) {
        Map<String,Object>  weChatSub = hlSubstationMapper.getHsIdAndHsSpellByWechatOfficialAccountsId(openId);
        if( weChatSub != null
                && weChatSub.containsKey("substationNameSpell") ) {
            String spell = String.valueOf(weChatSub.get("substationNameSpell"));
            String subId  = String.valueOf( weChatSub.get("substationId") );
            HlUser hlUser = hlUserMapper.selectByMobile(mobile);
            int userId = hlUser.getId();
            HsMachineLianyunCard hsMachineLianyunCard = hsMachineLianyunCardMapper.selectByUserId(userId);
            if( hsMachineLianyunCard != null
                    && hsMachineLianyunCard.getCardId() != null) {
                    String cardId = hsMachineLianyunCard.getCardId();
                    Map<String, Object> paramMap = new HashMap<String, Object>();
                    paramMap.put("substationId", subId);
                    paramMap.put("spell", "_"+spell);
                    paramMap.put("cardId", cardId);
                    PageHelper.startPage(currentPage, pageSize);
                    List<Map<String, Object>> resultList = hsMachineLianyunTrackMapper.selectTrackByCardId(paramMap);
                    if (resultList != null
                            && resultList.size() > 0) {
                        return new Gson().toJson(getSussRtn("查询成功", resultList));
                    } else {
                        return new Gson().toJson(getSussRtn("查询成成功", new ArrayList<>()));
                    }
            }else{
                return new Gson().toJson( getFailRtn("该用户未绑定卡号",new ArrayList<>()));
            }
        }else{
            return new Gson().toJson( getFailRtn("未开通该分站",new ArrayList<>()));
        }
    }


    /**
     * @Description 上门回收详情
     * @author sushile
     * @date 20180309
     */
    @Override
    public String getHomeRecyDetail(String openId, String id) {
        Map<String,Object>  weChatSub = hlSubstationMapper.getHsIdAndHsSpellByWechatOfficialAccountsId(openId);
        if( weChatSub != null
                && weChatSub.containsKey("substationId") ) {
            String subId  = String.valueOf( weChatSub.get("substationId") );
            HsAppointment hsAppointment = hsAppointmentMapper.selectByIdWithSubId(id,subId);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(hsAppointment.getStarttime());
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
            calendar.setTimeZone(timeZone);
            hsAppointment.setStarttime( calendar.getTime() );
            if( hsAppointment != null){
                return new Gson().toJson( getSussRtn("查询成功",hsAppointment));
            }else{
                return new Gson().toJson( getFailRtn("查询失败",new ArrayList<>()));
            }
        }else{
            return new Gson().toJson( getFailRtn("未开通该分站",new ArrayList<>()));
        }
    }


    /**
     * @Description 更新上门回收状态
     * @author sushile
     * @date 20180312
     * @return
     */
    @Override
    public String updateAppointmentStatus(String openId,String id,String status){
        Map<String,Object>  weChatSub = hlSubstationMapper.getHsIdAndHsSpellByWechatOfficialAccountsId(openId);
        if( weChatSub != null
                && weChatSub.containsKey("substationId") ) {
            String subId = String.valueOf(weChatSub.get("substationId"));
            HsAppointment hsAppointment = new HsAppointment();
            hsAppointment.setId( Integer.parseInt( id ));
            hsAppointment.setStatus( new Byte(status));
            try {
                hsAppointmentMapper.updateByPrimaryKeySelective(Byte.valueOf(status));
                return new Gson().toJson( getSussRtn("更新状态成功", new ArrayList()));
          }catch( Exception exp ){
           return new Gson().toJson( getFailRtn("更新状态失败",new ArrayList<>()));
            }
        }else{
            return new Gson().toJson( getFailRtn("未开通该分站",new ArrayList<>()));
        }
    }

    @Override
    public IBaseMapper getMapper() throws Exception {
        return null;
    }
}
