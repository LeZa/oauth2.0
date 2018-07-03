package com.sound.haolei.constants;


public class DefaultValueConstants {

	/**************************************************翻页请求默认值start*******************************************/
	/**
	 * 上下拉方向，1：下拉，-1：上拉，默认下拉
	 */
	public static final String WHICH = "1";
	/**
	 * 每页显示条数默认值，20
	 */
	public static final String SIZE = "20";
	/**
	 * 最大、最小id
	 */
	public static final String LASTID = "0";
	/**************************************************翻页请求默认值end*********************************************/
	
	/**
	 * 数据库对应翻页参数名定义，上下拉参数名
	 */
	public static final String PAGE_WHICH = "which";
	
	/**
	 * 每页显示条数参数名
	 */
	public static final String PAGE_SIZE = "size";
	
	public static final String PAGE_LAST_ID = "currentId";
	/**
	 * 分站id参数名
	 */
	public static final String PAGE_SUBSTATION_ID = "substationId";
	/**
	 * 默认分站id值
	 */
	public static final String DEFAULT_SUBSTATION_ID = "686";
	
	/**
	 * 分站名全拼参数名
	 */
	public static final String SUBSTATION_NAME_SPELL = "substationNameSpell";
	
	/**
	 * 不需要拦截替换表名的变量声明key
	 */
	public static final String IGNORE_INTERCEPTOR_SQL_KEY = "ignoreInterceptorSql";
	/**
	 * 不需要拦截替换表名的变量声明value
	 */
	public static final String IGNORE_INTERCEPTOR_SQL_VALUE = "1";
	/**
	 * 初始化替换表名的变量声明value
	 */
	public static final String DEFAULT_INTERCEPTOR_SQL_VALUE = "0";
	
}