package com.sound.haolei.utils;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * CookieUtil用来操作cookie的存取
 * 
 * @author niulu
 *
 */
public class CookieUtil {
	/**
	 * 
	 * @return
	 */
	public static String setCookie(HttpServletRequest request,HttpServletResponse response){
		if(null == request || null == response){
			return null;
		}
		String domain = request.getServerName();    
		String cookieId = ConversionMd5.toMd5("haolei");    
       	String redisSessionKey = UUID.randomUUID().toString();    
       	Cookie cookie = new Cookie(cookieId, redisSessionKey);    
       	cookie.setMaxAge(30*60);    
       	cookie.setPath("/");
       	response.addCookie(cookie);
		return redisSessionKey; 
	}
	
	/**
	 * 
	 * @return
	 */
	public static String getCookie(HttpServletRequest request,HttpServletResponse response){
		if(null == request){
			return null;
		}
		//读取
		String cookid  = ConversionMd5.toMd5("haolei");  
		Cookie[] cookies = request.getCookies();    
		String sessionKey = "";    
		if(cookies != null){    
		    for (Cookie cookie : cookies) {    
		        if(cookie.getName().equals(cookid)){    
		        	sessionKey = cookie.getValue() ;   
		        }    
		    }    
		}  
		return sessionKey;
	}
}
