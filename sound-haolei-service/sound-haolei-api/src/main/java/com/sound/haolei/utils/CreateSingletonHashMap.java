package com.sound.haolei.utils;

import java.util.HashMap;
/**
 * 
* @ClassName: CreateSingletonHashMap 
* @Description: 懒汉单例(线程安全) 
* @author Lvshiyang 
* @date 2018年3月14日 上午11:42:18 
*
 */
public class CreateSingletonHashMap {
	    private static HashMap<String,Object> hashMap = null;
	    public static synchronized HashMap<String,Object> getInstance(){
	        if(hashMap == null){
	        	hashMap = new HashMap<String,Object>();
	        }
	        return hashMap;
	    }
}