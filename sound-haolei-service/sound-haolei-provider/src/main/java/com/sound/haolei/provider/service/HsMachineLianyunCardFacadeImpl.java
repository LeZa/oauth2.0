package com.sound.haolei.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.sound.haolei.exception.HttpClientException;
import com.sound.haolei.facade.HsMachineLianyunCardFacade;
import com.sound.haolei.model.HsMachineLianyunCard;
import com.sound.haolei.provider.dao.HsMachineLianyunCardMapper;
import com.sound.haolei.provider.util.HttpClientUtil;
import com.sound.haolei.utils.ConversionMd5;
import com.sound.haolei.utils.RandomUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 联运卡人员信息
 * @author zhaoming
 */
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class HsMachineLianyunCardFacadeImpl
        extends BaseFacadeImpl<HsMachineLianyunCard,HsMachineLianyunCardMapper>
        implements HsMachineLianyunCardFacade{


    @Autowired
    private HsMachineLianyunCardMapper hsMachineLianyunCardMapper;

    @Override
    public Map<String, Object> selectByCardId(String cardId) {
        return null;
    }

    @Override
    public Map<String, Object> addCardUserInfo(String cardId, String houseAdminId, String mobile, String name, String province, String city, String country, String area) {
        return null;
    }

    @Override
    public Map<String, Object> selectUserByCardId(String cardId) {
        return null;
    }

    @Override
    public Map<String, Object> selectByHouseAdminId(Integer houseAdminId, Integer lastId, Integer size) {
        return null;
    }

    @Override
    public Map<String, Object> getHouseAdminAddress(Integer houseAdminId, Integer isLast) {
        return null;
    }

    @Override
    public Map<String, Object> batchDelMachines(List<Integer> ids) {
        return null;
    }

    @Override
    public Map<String, Object> addCardUserInfoBack(String cardId, String string, String usermobile, String username, String province, String city, String county, String address, String adminid) {
        return null;
    }

    @Override
    public Map<String, Object> selectByHouseAdminIdv201(Integer houseAdminId, Integer lastId, Integer size) {
        return null;
    }
    /**
     *
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> selectCardByUserId(Integer userId) {
        if (null ==userId){
            return getFailRtn("参数不能为空");
        }
        HsMachineLianyunCard model = hsMachineLianyunCardMapper.selectByUserId(userId);
        if (model ==null){
            return getFailRtn("数据异常");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("cardId",model.getCardId());
        return getSussRtn("返回成功!",map);
    }

    /**
     *  调用联运注册接口返回cardId
     * @param houseAdminId
     * @param mobile 确定是否需要发短信
     * @param subId 分站id
     * @param province 省
     * @param city 市/县
     * @param community 小区名称
     * @param street 街道/区
     * @return
     */
    @Override
    public Map<String, Object> saveUserToLianYun(Integer userId,Integer subId ,String province,
                                                 String city,String community,String street) {
        if(StringUtils.isEmpty(community) || StringUtils.isEmpty(street) || StringUtils.isEmpty(city)
                || StringUtils.isEmpty(province)){
            return getFailRtn("必填参数不能为空！");
        }
        if (null ==userId || null ==subId){
            return getFailRtn("必填参数不能为空！");
        }
        HsMachineLianyunCard model = hsMachineLianyunCardMapper.selectByUserId(userId);
        if (model !=null){
            return getRtnCode("该用户已经绑定联运卡",2);
        }
        String url = "http://60.191.75.18:10082/sd/use";
        String date = String.valueOf(new Date().getTime());
        String key = ConversionMd5.toMd5("sd"+date+"lyzh02");
        String qrcode = "LYZHX"+ RandomUtil.getInstance().genString(9,2)+"01";

        JSONObject userdata = new JSONObject();
        userdata.put("community",community);
        userdata.put("street",street);
        userdata.put("qrcode",qrcode);
        userdata.put("area","");
        userdata.put("city","");
        userdata.put("hostNo","");
        userdata.put("phone","");

        JSONObject object = new JSONObject();
        object.put("date",date);
        object.put("key",key);
        object.put("userdata",userdata);

        //请求头
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        headers.put("Accept", "application/json");
        Map<String, Object> result = HttpClientUtil.doPost(url, headers, object.toString());
        if (result !=null && result.get("code").toString().equals("0")){
            Map<String,String> data = (Map<String, String>) result.get("data");
            String cardId = data.get("code");
            //获取联运卡成功后保存到数据库
            HsMachineLianyunCard card = new HsMachineLianyunCard();
            card.setCardId(cardId);
            card.setUserId(userId);
            card.setCtime(new Date());
            card.setProvince(province);
            card.setCity(city);
            card.setCounty(street);
            card.setAddress(community);
            card.setSubstationId(Integer.valueOf(subId));
            int cnt = hsMachineLianyunCardMapper.insertSelective(card);
            if(cnt != 1){
                return getFailRtn("绑定用户失败");
            }
            logger.debug("添加到联运卡表中成功");
        }
        return result;

    }

    @Override
    public HsMachineLianyunCardMapper getMapper() throws Exception {
        return this.hsMachineLianyunCardMapper;
    }

}