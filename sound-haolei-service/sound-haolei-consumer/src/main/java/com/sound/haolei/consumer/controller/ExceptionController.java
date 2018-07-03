package com.sound.haolei.consumer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sound.haolei.constants.HlUserConstants;
import com.sound.haolei.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by admin on 2017/2/16.
 */
@ControllerAdvice(basePackages = "com.sound.haolei.consumer")
public class ExceptionController extends BaseController{

    private Logger log = LoggerFactory.getLogger(String.valueOf(ExceptionController.class));


    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

    /**
     * Exception统一处理
     *
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.getWriter().write(JSONObject.toJSONString( getFailRtn(HlUserConstants.SYSTEM_ERROR_TIP_MSG)));
        return;
    }
    /**
     * BusinessException  自定义异常统一处理
     *
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = BusinessException.class)
    public void defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, BusinessException e) throws Exception {
    	log.error(e.getMessage());
    	response.setCharacterEncoding("UTF-8");
    	response.setHeader("Content-type", "application/json;charset=UTF-8");
    	response.getWriter().write(JSONObject.toJSONString(getRtnCode(null,e.getMsg(),e.getCode())));
    	return;
    }


    /**
     * 参数绑定异常处理
     * BindException统一处理
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = BindException.class)
    public void bindErrorHandler(HttpServletRequest request, HttpServletResponse response, BindException e) throws Exception {
    	ObjectError error = e.getBindingResult().getAllErrors().get(0);
    	String errMsg = error.getDefaultMessage(); 
    	response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.getWriter().write(JSONObject.toJSONString( getFailRtn(errMsg)));
        return;
    }
}
