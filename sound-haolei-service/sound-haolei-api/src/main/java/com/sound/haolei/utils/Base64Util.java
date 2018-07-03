package com.sound.haolei.utils;

import java.io.UnsupportedEncodingException;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * base64 加密
 * @author zhangyong
 * @date 2016-04-07
 */
public class Base64Util {
	//private Logger log = LoggerFactory.getLogger("Base64Util.class");
	
	private static class Base64UtilHandler{
		private static Base64Util instance = new Base64Util();
	}
	
	private Base64Util(){}
	
	public static Base64Util getInstance(){
		return Base64UtilHandler.instance;
	}
	
	public String base64(String str, String charset) throws UnsupportedEncodingException{
		String encoded = Base64.encode(str.getBytes(charset));
		return encoded;
	}
	
	public String decode(String str, String charset) throws UnsupportedEncodingException{
		String decode = new String(Base64.decode(str),charset);
		return decode;
	}
}
