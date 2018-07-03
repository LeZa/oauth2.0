package com.sound.haolei.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sound.haolei.facade.HlUserFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345")

    private HlUserFacade hlUserFacade;

    /**
     * 用户登陆接口，有直接登陆没有注册新用户
     * @param userId
     * @return
     */
    @PostMapping("/loginbytel")
    public Map<String,Object> loginByTel(String tel,String openId,Integer subustationId) {
        return  hlUserFacade.loginByTel(tel,openId,subustationId);
    }


}
