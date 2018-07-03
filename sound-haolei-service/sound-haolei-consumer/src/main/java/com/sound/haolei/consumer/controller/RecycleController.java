package com.sound.haolei.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sound.haolei.dto.AppointmentDto;
import com.sound.haolei.facade.HsAppointmentFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Descripiton  上门回收
 * @author sushile
 * @date 20180305
 */
@RestController
@RequestMapping(value="/appointment")
public class RecycleController {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345")
    private HsAppointmentFacade hsAppointmentFacade;

    /**
     * @Description  保存上门回收
     * @author sushile
     * @date 20180305
     * @return
     */
    @RequestMapping(value = "/save")
    public String saveAppointment( AppointmentDto dto ){
        return  hsAppointmentFacade.saveAppointment( dto );
    }

    /**
     * @Description   根据用户手机号查询投放量量和乐
     * @author sushile
     * @date 20180308
     * **/
    @RequestMapping(value="/monthVal")
    public String mounthVal( String mobile,String openId ){
       return  hsAppointmentFacade.selectByMobileOpenId( mobile,openId );
    }

    /**
     * @Description  上门回收记录
     * @author sushile
     * @date 20180309
     * @return
     */
    @RequestMapping(value = "/homeRecy")
    public String  homeRecy(String mobile,String openId,int currentPage,int pageSize){
            return hsAppointmentFacade.selectHomeRecy(mobile,openId,currentPage,pageSize);
    }

    /**
     * @Description 智能回收记录
     * @author sushile
     * @date 20180309
     * @return
     */
    @RequestMapping(value = "/machineRecy")
    public String machineRecy(String mobile,String openId,int currentPage,int pageSize){
       return  hsAppointmentFacade.selectMachineRecy(mobile,openId,currentPage,pageSize);
    }

    /**
     * @Description 上门回收详情
     * @author sushile
     * @date 20180309
     */
    @RequestMapping(value = "/homeRecyDetai")
    public String homeRecyDetail( String openId,String id){
         return hsAppointmentFacade.getHomeRecyDetail(openId,id);
    }

    /**
     * @Description  更新上门回收状态
     * @author sushile
     * @date 20180312
     * @return
     */
    @RequestMapping(value = "/homeRecyUpStatus")
    public String homeRecyUpStatus( String openId,String id,String status ){
        return hsAppointmentFacade.updateAppointmentStatus(openId,id,status);
    }


  }
