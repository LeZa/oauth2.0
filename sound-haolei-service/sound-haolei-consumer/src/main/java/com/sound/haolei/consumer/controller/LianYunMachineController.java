package com.sound.haolei.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sound.haolei.constants.ConstantsSubstation;
import com.sound.haolei.facade.*;
import com.sound.haolei.model.HsMachineLianyun;
import com.sound.haolei.model.MapProvince;
import com.sound.haolei.utils.CheckUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 联运回收机管理
 * @ClassName: LianYunMachineController 
 * @author liuyang
 * @date 2017年5月5日 上午11:34:44 
 *  
 */
@RestController
@RequestMapping("/machineLianYun")
public class LianYunMachineController extends BaseController{

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345")
    private HsMachineLianyunFacade hsMachineLYFacade;
    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345")
    private MapProvinceFacade provinceFacade;
    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345")
    private MapCityFacade cityFacade;
    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345")
    private MapCountryFacade countryFacade; @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345")
    private HlSubstationFacade hlSubstationFacade;

    /**
     * 返回所有的省信息
     * @param request
     * @return
     */
    @RequestMapping("index")
    public List<MapProvince> index(HttpServletRequest request){
        List<MapProvince> provinceList = null;
        try {
            // 查询省份信息
            provinceList = provinceFacade.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return provinceList;
    }

    /**
     * 智能回收机保存或更新接口
     * @param wechatOfficialAccountsId 公众号id
     * @param id 联运回收机id
     * @param mchid 机器码
     * @param houseId 所在回收亭id
     * @param provinceId 所在省份id
     * @param cityId 所在城市id
     * @param countyId 所在县id
     * @param area 所在小区
     * @param address 详细地址
     * @param potX 设备安置点经度
     * @param potY 设备安置点纬度
     * @param description 描述信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveorupdate", method = RequestMethod.POST)
    public Map<String,Object> saveOrUpdate(String wechatOfficialAccountsId,Integer id,String mchid,Integer houseId,Integer provinceId,Integer cityId,Integer countyId,
                                           String area,String address,String potX,String potY,String description){
        HsMachineLianyun hsMachineLianyun = new HsMachineLianyun();
        Map<String,Object> paramMap = hlSubstationFacade.getHsIdAndHsSpellByWechatOfficialAccountsId(wechatOfficialAccountsId);
        if(!CheckUtil.isEmpty(id)){
            hsMachineLianyun.setId(id);
        }

        if(!CheckUtil.isEmpty(mchid)){
            hsMachineLianyun.setMchid(mchid);
        }else {
            return  getFailRtn("机器码不能为空");
        }

        if(!CheckUtil.isEmpty(houseId)){
            hsMachineLianyun.setHouseId(houseId);
        }else {
            return  getFailRtn("所在服务亭不能为空");
        }

        if(!CheckUtil.isEmpty(provinceId)){
            hsMachineLianyun.setProvinceId(provinceId);
        }else {
            return  getFailRtn("所在省份不能为空");
        }

        if(!CheckUtil.isEmpty(cityId)){
            hsMachineLianyun.setCityId(cityId);
        }else {
            return  getFailRtn("所在城市不能为空");
        }

        if(!CheckUtil.isEmpty(countyId)){
            hsMachineLianyun.setCountyId(countyId);
        }else {
            return  getFailRtn("所在县不能为空");
        }

        if(!CheckUtil.isEmpty(address)){
            hsMachineLianyun.setAddress(address);
        }else {
            return  getFailRtn("详细地址不能为空");
        }

        if(!CheckUtil.isEmpty(potX)){
            hsMachineLianyun.setPotX(potX);
        }else {
            return  getFailRtn("设备安置点经度不能为空");
        }

        if(!CheckUtil.isEmpty(potY)){
            hsMachineLianyun.setPotY(potY);
        }else {
            return  getFailRtn("设备安置点纬度不能为空");
        }

        if(!CheckUtil.isEmpty(description)){
            hsMachineLianyun.setDescription(description);
        }else {
            return  getFailRtn("描述信息不能为空");
        }

        //因为php管理员用户和好嘞的不一致，暂时用分站id代替
        paramMap.put("cuid", paramMap.get(ConstantsSubstation.SUBSTATION_ID));

        try{
            Map<String,String> resultMap = hsMachineLYFacade.saveOrUpdate(hsMachineLianyun,paramMap);
            if( resultMap != null && (resultMap.containsKey("jqmerror")  || resultMap.containsKey("jqncerror"))){
               //机器码已经存在，请重新输入
                if( resultMap.containsKey("jqmerror")){
                   return  getFailRtn(resultMap.get("jqmerror"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getFailRtn("保存数据出错,请与管理人员联系!");
        }

        return getSuccessRtn("");
    }

    /**
     *
     * @param publicnumberid
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getInfo")
    public Map<String,Object> getInfo(String wechatOfficialAccountsId,Integer id){
        Map<String,Object> paramMap = hlSubstationFacade.getHsIdAndHsSpellByWechatOfficialAccountsId(wechatOfficialAccountsId);
        HsMachineLianyun hsMachineLianyun = hsMachineLYFacade.selectByIdAndSubstationNameSpell(id,paramMap.get(ConstantsSubstation.SUBSTATION_NAME_SPELL).toString());
        return getSuccessRtn(hsMachineLianyun);
    }

    /**
     * 加载回收机信息数据
     * @Title: ajaxMachineList
     * @param provinceId
     * @param cityId
     * @param countryId
     * @param status
     * @param useNumberOrderBy
     * @param page
     * @param size
     * @return Map    返回类型
     * @throws
     * @author liuyang
     * @date 2018年3月8日19:06:45
     */
    @RequestMapping(value="ajaxMachineList")
    @ResponseBody
    public Map<String,Object> ajaxMachineList(HttpServletRequest request,Integer page,Integer size){
        Map<String,Object> retMap = null;
        Map<String,Object> param = new HashMap<String,Object>();
        String sell = (String) request.getSession().getAttribute("hSSpell");
        if( !CheckUtil.isEmpty(sell) ){
            param.put(ConstantsSubstation.SUBSTATION_NAME_SPELL, sell);
        }
        String mchId = request.getParameter("mchId");
        if(!CheckUtil.isEmpty(mchId)){
            param.put("mchId", mchId.trim());
        }

        String orderStr = request.getParameter("orderStr");
        if( !CheckUtil.isEmpty(orderStr)){
            param.put("orderStr",orderStr);
        }

        String ctimestartdate = request.getParameter("ctimestartdate");
        String ctimestarttime = request.getParameter("ctimestarttime");
        if(!CheckUtil.isEmpty(ctimestartdate)){
            if(CheckUtil.isEmpty(ctimestarttime)){
                ctimestarttime = "00:00:00";
            }
            ctimestartdate = ctimestartdate + " "+ ctimestarttime;
            param.put("ctimestart", ctimestartdate);
        }

        String ctimeenddate = request.getParameter("ctimeenddate");
        String ctimeendtime = request.getParameter("ctimeendtime");
        if(!CheckUtil.isEmpty(ctimeenddate)){
            if(CheckUtil.isEmpty(ctimeendtime)){
                ctimeendtime = "23:59:59";
            }
            ctimeenddate = ctimeenddate + " "+ctimeendtime;
            param.put("ctimeend", ctimeenddate);
        }

        String weight = request.getParameter("weight");
        String zlstart = request.getParameter("zlstart");
        String zlend = request.getParameter("zlend");
        if(!CheckUtil.isEmpty(weight) && !weight.equals("-1") ){
            param.put("weight", weight.trim());
            if(!CheckUtil.isEmpty(zlstart)){
                param.put("zlstart", zlstart.trim());
            }
            if(!CheckUtil.isEmpty(zlend)){
                param.put("zlend", zlend.trim());
            }
        }

        String provinceId = request.getParameter("provinceId");
        if( !CheckUtil.isEmpty(provinceId) && !provinceId.equals("-1")){
            param.put("provinceId", provinceId);
        }

        String cityId = request.getParameter("cityId");
        if( !CheckUtil.isEmpty(cityId) && !cityId.equals("-1")){
            param.put("cityId", cityId);
        }

        String countryId = request.getParameter("countryId");
        if( !CheckUtil.isEmpty(countryId) && !countryId.equals("-1")){
            param.put("countryId", countryId);
        }

        String nickname = request.getParameter("nickname");
        if(!CheckUtil.isEmpty(nickname)){
            param.put("nickname", nickname);
        }

        param.put("page", page != null ? page : 1);
        param.put("size", size != null ? size: 20);

        try {
            retMap = getPageResult(hsMachineLYFacade, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retMap;
    }
}

