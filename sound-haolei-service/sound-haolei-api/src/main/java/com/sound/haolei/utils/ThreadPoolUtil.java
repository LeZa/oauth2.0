package com.sound.haolei.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 线程池
 * @author zhangyong
 */
public class ThreadPoolUtil {
	private ExecutorService pool;
	private static class ThreadPoolUtilHandler {
		private static ThreadPoolUtil instance = new ThreadPoolUtil();
		
	}
	private ThreadPoolUtil(){
		if(null == pool){
			pool = Executors.newCachedThreadPool(); 
		}
	}
	public static ThreadPoolUtil getInstance(){
		return ThreadPoolUtilHandler.instance;
	}
	
	public void submit(Runnable task){
		pool.submit(task);
	}
	
}
