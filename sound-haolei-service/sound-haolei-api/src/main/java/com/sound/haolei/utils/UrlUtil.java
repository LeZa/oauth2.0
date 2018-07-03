package com.sound.haolei.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Url加密/解密
 * @author zhangyong
 * @date 2016-04-07
 */
public class UrlUtil {
	private static class UrlUtilHandler{
		private static UrlUtil instance = new UrlUtil();
	}
	
	private UrlUtil(){}
	
	public static UrlUtil getInstance(){
		return UrlUtilHandler.instance;
	}
	
	/**
	 * 加密
	 * @param str
	 * @param charset
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String encode(String str, String charset) throws UnsupportedEncodingException{
		String result = URLEncoder.encode(str, charset);
		return result;
	}
}
