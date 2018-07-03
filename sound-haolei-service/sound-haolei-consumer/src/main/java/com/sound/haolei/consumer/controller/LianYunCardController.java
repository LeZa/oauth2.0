package com.sound.haolei.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sound.haolei.facade.HsMachineLianyunCardFacade;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/lianyuncard")
public class LianYunCardController {


    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345")
    private HsMachineLianyunCardFacade hsMachineLianyunCardFacade;

    /**
     * 通过用户id查询联运卡
     * @param userId
     * @return
     */
    @PostMapping("/selectlianyuncardbyuserid")
    public Map<String,Object> selectLianYunCardByUserId(Integer userId) {
        return  hsMachineLianyunCardFacade.selectCardByUserId(userId);
    }

    /**
     *
     * @param houseAdminId 回收亭管理员id
     * @param mobile 注册人手机号
     * @param subId 分站id
     * @param province 省
     * @param city 市区
     * @param country 小区
     * @param area 街道
     * @return
     */
    @PostMapping("/saveusertolianyun")
    public Map<String,Object> saveUserToLianYun( Integer userId,Integer subId ,String province,
                                                 String city,String country,String area){

        return  hsMachineLianyunCardFacade.saveUserToLianYun(userId,subId,province,city,country,area);
    }
}
