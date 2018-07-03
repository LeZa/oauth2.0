package com.sound.haolei.constants;

public class ServiceCodeConstants {
	
	/************************************************************code码定义start************************************************************/
	public static final Integer CODE_PARAM_ILLEGAL = -1;
	/**
	 * 异地登录
	 */
	public static final Integer OTHER_PLACE_LOGIN = 1001;
	
	/**
	 * token过期
	 */
	public static final Integer TOKEN_EXPIRE = 1002;
	
	/**
	 * userId为空非法
	 */
	public static final Integer REQUEST_USERID_NULL_ILLEGAL = 1003;
	
	/**
	 * token非法
	 */
	public static final Integer TOKEN_ILLEGAL = 1004;
	
	/**
	 * 成功请求返回码
	 */
	public static final Integer SUCCESS_RTN = 0;
	
	/**
	 * 失败请求返回码
	 */
	public static final Integer FAIL_RTN = -1;
	
	/**
	 * 登录用户不存在或密码错误 
	 */
	public static final Integer USER_NOT_EXISTS_PASSWORD_ILLEGAL = 1005;

	/**
	 * 用户已冻结
	 */
	public static final Integer USER_FREEZED = 1006;
	
	/**
	 * 手机号非法
	 */
	public static final Integer MOBILE_ILLEGAL = 1007;
	
	/**
	 * 验证码不对
	 */
	public static final Integer AUTH_CODE_ILLEAGL = 1008;
	
	/**
	 * 重复注册
	 */
	public static final Integer MULTIPLE_REGISTER = 1009;
	
	/**
	 * 手机号未注册
	 */
	public static final Integer MOBILE_UNREGISTER = 1010;
	
	/**
	 * 生产新用户失败
	 */
	public static final Integer USER_CREATE_FAILED = 1011;
	
	/**
	 * 机器码为空非法
	 */
	public static final Integer REQUEST_MACHINE_NULL_ILLEGAL = 1012;
	
	/**
	 * 必填字段为空
	 */
	public static final Integer REQUIRED_PARAM_NULL_ILLEGAL = 1013;
	
	/**
	 * 图片验证码不对
	 */
	public static final Integer GRAPHIC_CODE_ILLEGAL = 1014;
	
	/**
	 * 用户不存在
	 */
	public static final Integer USER_IS_NOT_EXISTS = 1015;
	
	/**
	 * 积分类型不存在
	 */
	public static final Integer POINT_TYPE_IS_NOT_EXISTS = 1016;
	
	/**
	 * 报修类型不存在
	 */
	public static final Integer MACHINE_REPARE_TYPE_IS_NOT_EXISTS = 1017;
	
	/**
	 * 用户昵称已存在
	 */
	public static final Integer USER_NICKNAME_EXISTS = 1018;
	
	/**
	 * 联运卡号为空非法
	 */
	public static final Integer REQUEST_CARDID_NULL_ILLEGAL = 1019;

	/**
	 * 上门回收预约单已被接单
	 */
	public static final Integer APPOINTMENT_ACCEPT_OF_YES = 1020;
	
	/**
	 * 服务亭管理员所在站点重新分配
	 */
	public static final Integer ADMIN_USER_SUBSTATION_RESET = 1021;
	/**
	 * 服务亭管理员角色权限发生改变
	 */
	public static final Integer ADMIN_USER_MODULE_RESET = 1022;
	/**
	 * roleId为空非法
	 */
	public static final Integer REQUEST_ROLEID_NULL_ILLEGAL = 1023;
	/**
	 * 服务亭管理员角色发生改变
	 */
	public static final Integer ADMIN_USER_ROLE_ID_RESET = 1024;
	/**
	 * 服务亭管理员角色发生改变
	 */
	public static final Integer CODE_EXPRESS_NOT_EXISTS = 1025;
	/**
	 * 未查询到管理员管辖回收亭地址
	 */
	public static final Integer CODE_ADMIN_HOUSE_IS_NULL = 1026;
	/**
	 * 服务器繁忙
	 */
	public static final Integer CODE_SERVER_ERROR = 1028;
	/**
	 * 服务亭管理员所在服务亭已重新分配
	 */
	public static final Integer ADMIN_USER_HOUSE_RESET = 1029;
	/**
	 * 服务亭管理员所在服务亭为空非法
	 */
	public static final Integer ADMIN_USER_HOUSE_NULL_ILLEGAL = 1030;
	
	/********************************商品订单相关code码*******************************************/
	/**
	 * 当前商品不存在
	 */
	public static final Integer CURRENT_SHOP_GOODS_NOT_EXISTS = 1031;
	
	/**
	 * 当前规格商品不存在
	 */
	public static final Integer CURRENT_SHOP_GOODS_SKU_NOT_EXISTS = 1032;
	
	/**
	 * 当前商品未上架或已下架
	 */
	public static final Integer CURRENT_SHOP_GOODS_OFF_SALE = 1033;
	
	/**
	 * 购买的商品不在同一个分站
	 */
	public static final Integer CURRENT_SHOP_GOODS_LIST_SUBSTATION_DIFF = 1034;
	
	/**
	 * 当前商品规格库存不足
	 */
	public static final Integer CURRENT_SHOP_GOODS_SKU_NOT_ENOUGH = 1035;
	
	/**
	 * 用户收货地址没有设置分站不支持配送
	 */
	public static final Integer CURRENT_RECEIVER_ADDRESS_NO_SUBSTAION = 1036;
	
	/**
	 * 当前商品不在配送范围
	 */
	public static final Integer CURRENT_SHOP_GOODS_DELIVERY_NONSUPPORT = 1037;
	
	/**
	 * 当前商品价格变动
	 */
	public static final Integer CURRENT_SHOP_GOODS_SKU_PRICE_CHANGE = 1052;
	
	/**
	 * 用户抵扣乐豆小于本次抵扣乐豆
	 */
	public static final Integer CURRENT_DELIVERY_CASHPOINTS_NOT_ENOUGH = 1040;
	/********************************商品订单相关code码*******************************************/
	/**
	 * 当前城市未开通分站
	 */
	public static final Integer SUBSTATION_IS_NULL = 1038;
	/**
	 * 暂未开通配送
	 */
	public static final Integer SHOP_EXPRESS_TYPE_IS_NULL = 1039;
	/**
	 * 暂无订单数据
	 */
	public static final Integer SHOP_GOODS_ORDER_NO_DATA = 1041;
	/**
	 * 商城订单修改状态失败
	 */
	public static final Integer SHOP_ORDER_STATUS_UPDATE_ERROR = 1042;
	/**
	 * 商城订单不存在
	 */
	public static final Integer SHOP_ORDER_IS_NULL = 1043;
	/**
	 * 商城订单已发货 不可删除
	 */
	public static final Integer SHOP_ORDER_IS_SHIPPED_NOT_DELETE = 1044;
	/**
	 * 商城订单不是正常单 不可取消
	 */
	public static final Integer SHOP_ORDER_NOT_CANCLE = 1044;
	/**
	 * 商城订单号为空
	 */
	public static final Integer SHOP_ORDER_NUM_IS_NULL = 1045;
	/**
	 * 分站Id为空非法
	 */
	public static final Integer REQUEST_SUBSTATIONID_NULL_ILLEGAL = 1046;
	/**
	 * 微信端wap支付生成签名串失败
	 */
	public static final Integer WX_WAP_PAY_SIGN_FAILED = 1047;
	/**
	 * 商品名称为空
	 */
	public static final Integer SHOP_ORDER_GOODS_NAME_IS_NULL = 1048;
	/**
	 * 管理员状态冻结或为空错误
	 */
	public static final Integer ADMIN_USER_STATUS_ILLEGAL = 1049;
	/**
	 * 异地登陆错误码
	 */
	public static final Integer OFF_SITE_LOGIN = 1050;
	/**
	 * 请求机器码为空错误码
	 */
	public static final Integer REQUEST_MACHINE_CODE_NULL_ILLEGAL = 1051;
	/**
	 * 本地连连订单为空错误码
	 */
	public static final Integer LOCAL_LIANLIAN_ORDER_NULL_ILLEGAL = 1052;
	/**
	 * 订单已删除
	 */
	public static final Integer SHOP_ORDER_STATUS_DELETED = 1053;
	/**
	 * 订单已取消
	 */
	public static final Integer SHOP_ORDER_STATUS_CANCELED = 1054;
	/**
	 * 订单已过期
	 */
	public static final Integer SHOP_ORDER_STATUS_EXPIRED = 1055;
	/**
	 * 订单不存在
	 */
	public static final Integer SHOP_ORDER_STATUS_NOT_EXISTS = 1061;
	/**
	 * 订单已完成
	 */
	public static final Integer SHOP_ORDER_STATUS_DONE = 1056;
	/**
	 * 订单未支付
	 */
	public static final Integer SHOP_ORDER_PAY_STATUS_NOTPAY = 1057;
	/**
	 * 订单已退款
	 */
	public static final Integer SHOP_ORDER_PAY_STATUS_RECOMMEND = 1058;
	/**
	 * 订单已收货
	 */
	public static final Integer SHOP_ORDER_EXPRESS_STATUS_RECEIVED = 1059;
	/**
	 * 商品订单状态不支持退款操作
	 */
	public static final Integer SHOP_ORDER_STATUS_REFUND_ERROR = 1060;
	/**
	 * 商品购物车同种商品数量超过99 不可添加
	 */
	public static final Integer SHOP_CART_GOODS_NUMBER_ILLEGAL = 1061;
	/********************************商品订单相关code码 end*******************************************/
	/**
	 * 必填字段逻辑错误
	 */
	public static final Integer REQUIRED_PARAM_LOGIC_ILLEGAL = 1062;
	/**
	 * 分站id为空
	 */
	public static final Integer EMS_SUBSTATION_IS_NULL=1063;
	/**
	 * 没有发件记录
	 */
	public static final Integer EMS_HLEMSCALL_IS_NULL=1064;
	/**
	 * 发件记录id为空
	 */
	public static final Integer EMS_HLEMSCALL_ID_IS_NULL=1065;
	/**
	 * 没有收件记录
	 */
	public static final Integer EMS_HLEMSSEARCH_IS_NULL=1066;
	/**
	 * 没有绑定微信校验
	 */
	public static final Integer WX_IS_NOT_BINDING=1067;
	/**
	 * 该手机账号关联另一个微信账号
	 */
	public static final Integer WX_IS_BINDING_MOBILE=1068;
	/************************************************************code码定义end************************************************************/
}
