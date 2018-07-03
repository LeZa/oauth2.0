package com.sound.haolei.utils;

import java.util.Map;

public class ThreadLocalUtil {

	private static final ThreadLocal<Map<String,Object>> tl = new ThreadLocal<>();
	
	public static void set(Map<String,Object> map){
		//对于线程复用来说（比如线程池），threadlocal是线程不安全的
		tl.set(map);
	}
	
	public static Map<String,Object> get(){
		return ( Map<String,Object>)tl.get();
	}
	
}
