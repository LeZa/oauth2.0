package com.sound.haolei.provider.service;

import com.sound.haolei.constants.ConstantsPointsTypeChannel;
import com.sound.haolei.constants.ConstantsUserExtSource;
import com.sound.haolei.constants.HlUserConstants;
import com.sound.haolei.constants.ServiceCodeConstants;
import com.sound.haolei.dto.HlUserExtLoginDto;
import com.sound.haolei.facade.HlPointsChannelTypeFacade;
import com.sound.haolei.facade.HlUserFacade;
import com.sound.haolei.model.HlPointsTrack;
import com.sound.haolei.model.HlUser;
import com.sound.haolei.provider.dao.HlPointsTrackMapper;
import com.sound.haolei.provider.dao.HlUserExtMapper;
import com.sound.haolei.provider.dao.HlUserMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.sound.haolei.utils.CheckUtil;
import com.sound.haolei.utils.GradeUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class HlUserFacadeImpl extends BaseFacadeImpl<HlUser,HlUserMapper>
         implements HlUserFacade {

    @Autowired
    private HlUserMapper hlUserMapper;
    @Autowired
    private HlUserExtMapper hlUserExtMapper;
    @Autowired
    private HlPointsChannelTypeFacade hlPointsChannelTypeFacade;
    @Autowired
    private HlPointsTrackMapper hlPointsTrackMapper;
    @Override
    public HlUser selectById(String id) {
//        return null;
        int idInt = Integer.parseInt( id );
        return hlUserMapper.selectByPrimaryKey( idInt );
    }

    /**
     * 登陆注册
     *
     * @param tel
     * @param phpUserId
     * @return
     */
    @Override
    public Map<String, Object> loginByTel(String tel, String openId,Integer sbustationId) {
        if (CheckUtil.isEmpty(tel) || CheckUtil.isEmpty(openId) || CheckUtil.isEmpty(sbustationId)){
            return getFailRtn("必填参数不能为空！");
        }
        if (!CheckUtil.isMobile(tel)) {
            logger.error("手机号格式错误");
            return getFailRtn("您的手机号码貌似不太对哦");
        }
        HlUser user = hlUserMapper.selectByMobile(tel);
        if (null !=user){
            Integer status = user.getStatus() != null?user.getStatus():0;
            // 冻结
            if (status == HlUserConstants.USER_STATUS_FREEZE) {
                logger.debug("账户被冻结");
                return getRtnCode("账户被冻结", ServiceCodeConstants.USER_FREEZED);
            }
            // 更新最近登录时间
            user.setLtime(new Date());
            hlUserMapper.updateByPrimaryKeySelective(user);
            //新增省市区name字段
            HlUserExtLoginDto ext = hlUserExtMapper.selectExtDtoByUserId(user.getId());
            if (null == ext) {
                ext = new HlUserExtLoginDto();
                ext.setUserId(user.getId());
                hlUserExtMapper.insertSelective(ext);
            }
            //机器码存入redis

            // 返回
            Map<String, Object> map = new HashMap<>();
            map.put("user", user);
            map.put("userext", ext);
            //新增登陆时返回用户未读消息id列表
//            map.put("unReadMsgIds", getUnreadMsgIds(user.getId()));
//            map.put("unReadMsgByTypeIds", getUnreadMsgByTypeIds(user.getId()));
            //查询用户小区名称
            if(user.getHouseId() != null){
                String userHouseName = getUserHouseName(user.getHouseId());
                map.put("userHouseName", userHouseName);
            }
            //绑定微信openid
            hlUserMapper.updateByPrimaryKeySelective(user);
            return getSussRtn(map);
        }
        HlUser hlUser = new HlUser();
        hlUser.setMobile(tel);
        hlUser.setPasswd("");// 密码加密规则
        // 注册时间
        Date ctime = new Date();
        hlUser.setCtime(ctime);
        hlUser.setLtime(ctime);
        // 非空字段
        hlUser.setWxOpenid(openId);
        hlUser.setWbOpenid("");
        //用户昵称，使用微信的昵称
        hlUser.setGrade(GradeUtil.getFirstLogin());
        hlUser.setRealname("");
        hlUser.setStatus(0);
        hlUserMapper.insertSelective(hlUser);
        // 用户拓展表
        HlUserExtLoginDto userExt = new HlUserExtLoginDto();
        userExt.setHsBottleAll(0);
        userExt.setHsClothesAll(0);
        userExt.setUserId(hlUser.getId());
        userExt.setHsRole(0);
        userExt.setSource(ConstantsUserExtSource.SOURCE_BY_PHP);
        userExt.setProvinceId(0);
        userExt.setCityId(0);
        userExt.setCountyId(0);
        hlUserExtMapper.insertSelective(userExt);
        // 用户积分轨迹
        // 等级积分更新操作
        updateFirstLoginPointTrack(hlUser.getId(),sbustationId);

        // 更新返回用户积分
        hlUser.setGrade(GradeUtil.getFirstLogin());
        hlUser.setCashPoints(hlPointsChannelTypeFacade.getPointByChannel(ConstantsPointsTypeChannel.POINTS_CHANNEL_FIRST_LOGIN,sbustationId));
        hlUser.setLevelPoints(hlPointsChannelTypeFacade.getPointByChannel(ConstantsPointsTypeChannel.POINTS_CHANNEL_FIRST_LOGIN,sbustationId));// @Description添加注册送50积分@author
        Map<String, Object> map = new HashMap<>();

        map.put("user", hlUser);
        map.put("userext", userExt);
        //新增登陆时返回用户未读消息id列表
//        map.put("unReadMsgIds", getUnreadMsgIds(hlUser.getId()));
//        map.put("unReadMsgByTypeIds", getUnreadMsgByTypeIds(hlUser.getId()));
        return getSussRtn(map);
    }
    /**
     * 获取用户小区名称
     * @Title: getUserHouseName
     * @param houseId 小区id
     * @author wangyonghui
     * @date 2017年9月1日 下午3:46:59
     */
    private String getUserHouseName(Integer houseId) {
        String substationNameSpell = hlUserMapper.selectUserHouseSubstationNameSpell(houseId);
        if(CheckUtil.isEmpty(substationNameSpell)){
            substationNameSpell = "";
        }else{
            substationNameSpell = "_" + substationNameSpell;
        }
        return hlUserMapper.selectUserHouseName(substationNameSpell, houseId);
    }
    // 首次登陆用户积分乐豆赠送

    public void updateFirstLoginPointTrack(Integer userId,Integer sbustationId){
        // 用户积分轨迹
        // 等级积分更新操作
        HlPointsTrack track = new HlPointsTrack();
        track.setCtime(new Date());
        track.setDescription("首次登陆送积分");
        track.setPoints(hlPointsChannelTypeFacade.getPointByChannel(ConstantsPointsTypeChannel.POINTS_CHANNEL_FIRST_LOGIN,sbustationId));
        track.setType(Byte.valueOf("1"));// 等级积分
        track.setUserId(userId);
        hlPointsTrackMapper.insertSelective(track);
        // 现金积分更新操作
        track = new HlPointsTrack();
        track.setCtime(new Date());
        track.setDescription("首次登陆送乐豆");
        track.setPoints(hlPointsChannelTypeFacade.getPointByChannel(ConstantsPointsTypeChannel.POINTS_CHANNEL_FIRST_LOGIN_CASH,sbustationId));

        track.setType(Byte.valueOf("0"));// 现金积分
        track.setUserId(userId);
        hlPointsTrackMapper.insertSelective(track);

    }





    @Override
    public HlUserMapper getMapper() throws Exception {
        return this.hlUserMapper;
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
    public List<HlUser> selectAll() throws Exception {
        return null;
    }

    @Override
    public HlUser selectById(Integer id) throws Exception {
        return null;
    }

    @Override
    public void update(HlUser obj) throws Exception {

    }

    @Override
    public void save(HlUser obj) throws Exception {

    }

    @Override
    public void batchDelete(List<Integer> ids) throws Exception {

    }

}
