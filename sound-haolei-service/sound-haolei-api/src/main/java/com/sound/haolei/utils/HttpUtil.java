package com.sound.haolei.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by admin on 2017/3/26.
 */
public class HttpUtil {

    /**
     * 判断ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request){
        return  (request.getHeader("X-Requested-With") != null  && "XMLHttpRequest".equals( request.getHeader("X-Requested-With").toString())   ) ;
    }

    /**
     * 获取请求的url，带参数
     * @param request
     * @return
     */
    public static String getReqUrl(HttpServletRequest request){
        StringBuffer returnUrl = new StringBuffer(request.getRequestURL().toString());
        Enumeration<String> paramKeys = request.getParameterNames();
        StringBuffer params = new StringBuffer();
        while (paramKeys.hasMoreElements()) {
            String key = paramKeys.nextElement();
            if(!"null".equals(key)){
                String[] value = request.getParameterValues(key);
                params.append(key)
                        .append("=")
                        .append(StringUtils.join(value,","))
                        .append("&");
            }
        }
        if(StringUtils.isNotEmpty(params.toString())){
            returnUrl.append("?")
                    .append(params.toString().substring(0, params.length()-1));
        }
        return returnUrl.toString();
    }

    /**
     * 获取request中所有请求参数
     * @param request
     * @return
     */
    public static Map getRequestPararms(HttpServletRequest request){
        Enumeration<String> paramKeys = request.getParameterNames();
        Map param = new HashMap();
        while (paramKeys.hasMoreElements()) {
            String key = paramKeys.nextElement();
            if (!"null".equals(key)) {
                String[] valueArr = request.getParameterValues(key);
                String value = StringUtils.join(valueArr, ",");
                param.put(key, value);
            }
        }
        return param;
    }

    /**
     * 获取项目路路径
     * @param request
     * @return
     */
    public static String getBasePath(HttpServletRequest request){
        StringBuffer sbu = new StringBuffer();
        sbu.append(request.getScheme())
        .append("://")
        .append(request.getServerName())
        .append(":")
        .append(request.getServerPort())
        .append("/");
        return sbu.toString();
    }
    
    /**
     * 
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {  
            for (Cookie cookie : cookies) {
                if (cookieName.equalsIgnoreCase(cookie.getName())) {  
                    return cookie.getValue();  
                }  
            }  
        }  
        return null;
    }
  
}
