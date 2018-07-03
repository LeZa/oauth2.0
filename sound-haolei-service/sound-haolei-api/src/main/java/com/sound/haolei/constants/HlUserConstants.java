package com.sound.haolei.constants;

import java.util.HashMap;
import java.util.Map;

public class HlUserConstants {
	// 普通会员角色id
	public static final Integer ROLE_ID_NORMAL = 0;
	// 管理员角色id
	public static final Integer ROLE_ID_ADMIN = 99;
	// 普通会员角色名称
	public static final String ROLE_NAME_NORMAL = "普通会员";
	// 管理员角色名称
	public static final String ROLE_NAME_ADMIN = "管理员";
	// 用户角色id、名称存储集合
	public static Map<Integer,String> HL_USER_ROLE_MAP; 
	
	static{
		HL_USER_ROLE_MAP = new HashMap<Integer,String>();
		HL_USER_ROLE_MAP.put(ROLE_ID_NORMAL, ROLE_NAME_NORMAL);
		HL_USER_ROLE_MAP.put(ROLE_ID_ADMIN, ROLE_NAME_ADMIN);
	}
	// 用户状态代码 正常
	public static final Integer USER_STATUS_NORMAL = 0;
	// 用户状态代码  冻结
	public static final Integer USER_STATUS_FREEZE = 1;
	// 投递一个瓶子增加积分
	public static final Integer INTEGRAL_ADD_BOTTLE = 10;
	// 投递1kg衣服增加积分
	public static final Integer INTEGRAL_ADD_CLOTHES = 30;
	// 注册成功提示语
	public static final String MSG_REGISTER_SUCCESS = "恭喜您注册成功！欢迎您加入好嘞社区~";
	// 乐豆添加成功提示语
	public static final String MSG_LEDOU_SUCCESS = "您的乐豆已到账！快去乐豆详情页查看乐豆使用规则吧！";
	// 积分添加成功提示语
	public static final String MSG_JIFEN_SUCCESS = "您获得了50积分，去积分页看看？据说积分越多特权越多哟，快去了解使用规则吧~";
	// 预约回收接单成功提示语
	public static final String MSG_APPOINTMENT_ACCEPT_SUCCESS = "您的回收订单已分配服务人员为您处理，请您保持电话畅通。";
	
	//************************************数据库短信模板  start*****************************
	//快递寄出对应id
	public static final Integer SMS_TEMPLATE_ID_OF_EXPRESS_SEND = 1;
	//快递到达回收亭对应id
	public static final Integer SMS_TEMPLATE_ID_OF_EXPRESS_ARRIVE_HOUSE = 2;
	//快递被取走对应id
	public static final Integer SMS_TEMPLATE_ID_OF_EXPRESS_TAKE_AWAY = 3;
	//快递被取走对应id
	public static final Integer SMS_TEMPLATE_ID_OF_EXPRESS_BINDED = 4;
	//验证码对应得id
	public static final Integer SMS_TEMPLATE_ID_OF_GET_VERCODE = 5;
	//用户绑定联运卡成功后发送短信通知对应id
	public static final Integer SMS_TEMPLATE_ID_OF_SERVICE_TO_BINDUSER = 6;
	//管理员代下订单后，发件人不是系统用户，新建用户并发提示信息对应id
	public static final Integer SMS_TEMPLATE_ID_OF_EXPTESS_ADMIN_GET_REGISTER = 7;
	//管理员代下订单后，已注册用户提示语对应id
	public static final Integer SMS_TEMPLATE_ID_OF_EXPTESS_ADMIN_GET_NO_REGISTER = 8;
	// 预约回收接单成功提示语对应id
	public static final Integer SMS_TEMPLATE_ID_OF_APPOINTMENT_ACCEPT_SUCCESS = 9;
	//预约回收成功---已注册用户提示语对应id
	public static final Integer SMS_TEMPLATE_ID_OF_APPOINTMENT_SUCCESS_REGISTER = 10;
	//预约回收成功---未注册用户提示语对应id
	public static final Integer SMS_TEMPLATE_ID_OF_APPOINTMENT_SUCCESS_NO_REGISTER = 11;
	//************************************数据库短信模板  end*****************************
	public static final String SYSTEM_ERROR_TIP_MSG = "系统繁忙，请稍后重试";
}
