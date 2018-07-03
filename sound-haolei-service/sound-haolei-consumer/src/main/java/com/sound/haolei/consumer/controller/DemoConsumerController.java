package com.sound.haolei.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sound.haolei.facade.HlUserFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoConsumerController {


    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345")
    private HlUserFacade hlUserFacade;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        System.out.println( hlUserFacade.selectById("25342") );
        return "{name:"+name+"}";
    }


    @RequestMapping("/unauthenticated")
    public String unauthenticated() {
        return "{error:des}";
    }
}
