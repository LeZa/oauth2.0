package com.sound.haolei.constants;

/**
 * redis常量定义
* @ClassName: RedisConstants 
* @Description: 这里用一句话描述这个类的作用
* @author tianyunyun 
* @date 2017年4月24日 下午12:29:54 
*
 */
public class RedisConstants {

	/********************************************表结构定义start********************************************/
	//机器码
	public static final String MACHINE_MCHID_LIST = "hs_machine:mchid:mchid_list";
	//机器信息
	public static final String MACHINE_INFO = "hs_machine:mchid:${mchid}:info";
	//联运机器信息
	public static final String LY_MACHINE_INFO = "ly_hs_machine:mchid:${mchid}:info";
	//最后在线时间
	public static final String MACHINE_LAST_ONLINE_TIME = "hs_machine:mchid:${mchid}:last_online_time";
	//机器位置记录标识
	public static final String MACHINE_LOCATION_STATUS = "hs_machine:mchid:${mchid}:location_status";
	//机器状态
	public static final String MACHINE_STATE = "hs_machine:mchid:langjian:${mchid}:status";
	//验证码key
	public static final String HL_USER_VERCODE = "hl_user:vercode:";
	//回收亭管理员验证码key
	public static final String HL_HOUSE_ADMIN_USER_VERCODE = "hl_house_admin_user:vercode:";
	//城市天氣key
	public static final String AREA_WEATHER = "hl_weather_area:${wfid}:${date}";
	//最近生产用户的序列号
    public static final String HL_USER_CREATED = "hl_user:create";
    //用户token key
    public static final String HL_USER_TOKEN = "hl_user:token:${userid}";
    //用户登陆机器码
    public static final String HL_USER_CURRENT_LOGIN_MACHINE_CODE = "hl_user:current_login_machine_code:${userId}";
    //用户最后登陆时间
    public static final String HL_USER_LAST_LOGIN_TIME = "hl_user:last_login_time:${userId}";
    //最后更新积分时间
    public static final String HL_USER_UPDATE_POINT_LAST_REQUEST_TME = "hl_user:update_point_request_last_time:${userid}";
    //用户图形验证码key
    public static final String HL_USER_GRAPHIC_CODE = "hl_user:graphic_code:${mobile}";
    //回收亭管理员图形验证码key
    public static final String HL_HOUSE_ADMIN_USER_GRAPHIC_CODE = "hl_house_admin_user:graphic_code:${mobile}";
    //联运机器位置记录标识key
    public static final String LY_MACHINE_LOCATION_STATUS = "hs_machine:mchid:lianyun:${mchid}:location_status";
    //智慧云行电子称位置状态
    public static final String ES_MACHINE_LOCATION_STATUS = "machine:mchid:escales:${mchid}:location_status";
    //查单快递公司列表key
    public static final String HL_EMS_QUERY_ORDER_COMPANY_LIST = "hl_ems_query_order_company_list";
    //查单快递公司列表key;版本号200
    public static final String HL_EMS_QUERY_ORDER_COMPANY_LIST_200 = "hl_ems_query_order_company_list_200";
    //发快递快递公司列表key
    public static final String HL_EMS_SEND_ORDER_COMPANY_LIST = "hl_ems_send_order_company_list";
    //用户通知已读未读
    public static final String HL_MAIL_UNREAD_MSG_LIST = "hl_mail_unread_msg_list:${uid}";
    //用户上一次查看消息时间
    public static final String HL_USER_LAST_READ_MSG_TIME = "hl_user:last_read_msg_time:${uid}";
    //回收亭管理员用户上一次查看消息时间 typeId 
    public static final String HL_HOUSE_ADMIN_USER_LAST_READ_MSG_TIME = "hl_house_admin_user:last_read_msg_time:${uid}:${typeId}";
    //回收亭管理员用户上token 
    public static final String HL_HOUSE_ADMIN_USER_TOKEN = "hl_house_admin_user:token:${adminUserId}";
    //管理端登录机器码
    public static final String HL_HOUSE_ADMIN_USER_CURRENT_LOGIN_MACHINE_CODE = "hl_house_admin_user:current_login_machine_code:${userId}";
    //回收亭管理员所在回收亭id
    public static final String HL_HOUSE_ADMIN_USER_SUBSTATION_ID = "hl_house_admin_user:substationId:${adminUserId}";
    //首页广告
    public static final String HL_POPUP_SUBSTATIONSPELL = "hl_popup:substationspell:${substationspell}";
    //百科分类列表
    public static final String HL_ENCYCLOPEDIA_TYPE_LIST = "hl_encyclopedia_type_list";
    /**
     * 千米支付缴费单位属性标识key (value 省份:省份v编号:缴费单位名称:城市:城市v编号:缴费方式v标号)
     * province:unitId:unitName:city:cityId:modeId
     */
    public static final String HL_PAY_QIANMI_ITEM_PROPS = "hl_pay_qianmi:item_props:${itemId}:${uid}";
    /**
     * 千米支付账单信息标识key (value 客户姓名:账单月:地址:应缴金额:滞纳金:余额:返回的账期:起始日期:截止日期:合同号:返回消息:查询结果状态)
     * customerName:month:customerAddress:payAmount:penalty:balance:billCycle:beginDate:endDate:contractNo:message:status
     */
    public static final String HL_PAY_QIANMI_ACCOUNT_INFO = "hl_pay_qianmi:account_info:${account}:${uid}";
    
    /**
     * 记录用户当前城市id
     */
    public static final String HL_USER_CURRENT_CITY_ID = "hl_user:current_id:${uid}";
    /**
     * 记录用户当前分站id
     */
    public static final String HL_USER_CURRENT_SUBSTATION_ID = "hl_user:current_substation_id:${uid}";
    // 回收亭管理员角色权限标识 0未发生改变 1发生改变
    public static final String HL_HOUSE_ADMIN_USER_MODULE_FLAG = "hl_house_admin_user:module_flag:${roleId}";
    // 回收亭管理员角色id
    public static final String HL_HOUSE_ADMIN_USER_ROLE_ID = "hl_house_admin_user:role_id:${adminId}";
    // 回收亭管理员所在回收亭
    public static final String HL_HOUSE_ADMIN_CURRENT_HOUSE_ID = "hl_house_admin_user:current_house_id:${adminId}";
    // 回收亭管理员状态  0 正常 1 冻结
    public static final String HL_HOUSE_ADMIN_CURRENT_STATUS = "hl_house_admin_user:current_status:${adminId}";
    
    //已完成回收订单数量
    public static final String HL_APPOINTMENT_DONE_ORDER_COUNT = "hl_appointment:done_order_count:substationid:${substationid}:uid:${uid}";
    
    //已完成快递订单数量
    public static final String HL_EMS_CALL_DONE_ORDER_COUNT = "hl_ems_call:done_order_count:substationid:${substationid}:uid:${uid}";
    
    //已完兑换订单数量
    public static final String SHOP_GOODS_ORDER_DONE_ORDER_COUNT = "shop_goods_order:done_order_count:substationid:${substationid}:uid:${uid}";
    
    /***********************************云平台相关start***************************************/
    //云平台数据同步用户数据发送成功最后一条id
    public static final String CLOUD_USER_LAST_SUCCESS_ID = "cloud:user:last_success_id";
    //云平台数据同步用户数据发送失败列表
    public static final String CLOUD_USER_FAIL_ID_LIST = "cloud:user:fail_id_list";
    //云平台浪尖机器新增数据同步发送失败列表key
    public static final String HS_MACHINE_LANGJIAN_NEW_FAIL_SEND_IDS = "cloud:machine:langjian:new_fail_send_ids";
    //云平台联运机器新增数据同步发送失败列表key
    public static final String HS_MACHINE_LIANYUN_NEW_FAIL_SEND_IDS = "cloud:machine:lianyun:new_fail_send_ids";
    //云平台电子称机器新增数据同步发送失败列表key
    public static final String HS_MACHINE_ESCALES_NEW_FAIL_SEND_IDS = "cloud:machine:escales:new_fail_send_ids";
    //云平台浪尖机器更新数据同步发送失败列表key
    public static final String HS_MACHINE_LANGJIAN_UPDATE_FAIL_SEND_IDS = "cloud:machine:langjian:update_fail_send_ids";
    //云平台联运机器更新数据同步发送失败列表key
    public static final String HS_MACHINE_LIANYUN_UPDATE_FAIL_SEND_IDS = "cloud:machine:lianyun:update_fail_send_ids";
    //云平台电子称机器更新数据同步发送失败列表key
    public static final String HS_MACHINE_ESCALES_UPDATE_FAIL_SEND_IDS = "cloud:machine:escales:update_fail_send_ids";
    //云平台浪尖机器最后更新时间
    public static final String HS_MACHINE_LANGJIAN_LAST_UPDATE_TIME = "cloud:machine:langjian:last_update_time";
    //云平台联运机器最后更新时间
    public static final String HS_MACHINE_LIANYUN_LAST_UPDATE_TIME = "cloud:machine:lianyun:last_update_time";
    //云平台电子称机器最后更新时间
    public static final String HS_MACHINE_ESCALES_LAST_UPDATE_TIME = "cloud:machine:escales:last_update_time";
    //报修最后更新时间
    public static final String CLOUD_USER_REPARE_LAST_UPDATE_TIME = "cloud:user:repare:last_update_time";
    //报修新增数据同步云平台失败id列表key
    public static final String CLOUD_USER_REPARE_NEW_DATA_FAIL_ID_LIST = "cloud:user:repare:new_data_fail_id_list";
    //报修更新数据同步云平台失败id列表key
    public static final String CLOUD_USER_REPARE_UPDATE_DATA_FAIL_ID_LIST = "cloud:user:repare:update_data_fail_id_list";
    //预约数据新增同步云平台失败id列表key
    public static final String CLOUD_USER_APPOINTMENT_NEW_DATA_ID_LIST = "cloud:user:appointment:new_data_fail_id_list";
    //预约更新数据同步云平台失败id列表key
    public static final String CLOUD_USER_APPOINTMENT_UPDATE_DATA_ID_LIST = "cloud:user:appointment:update_data_fail_id_list";
    //预约数据更新同步云平台最后更新时间key
    public static final String CLOUD_USER_APPOINTMENT_LAST_UPDATE_TIME = "cloud:user:appointment:last_update_data_time";
    //快递数据新增同步云平台失败id列表key
    public static final String CLOUD_EMS_QUERY_NEW_DATA_FAIL_ID_LIST = "cloud:ems:query:new_data_fail_id_list";
    //快递数据更新同步云平台失败id列表key
    public static final String CLOUD_EMS_QUERY_UPDATE_DATA_FAIL_ID_LIST = "cloud:ems:query:update_data_fail_id_list";
    //快递数据更新同步云平台最后更新时间
    public static final String CLOUD_EMS_QUERY_UPDATE_LAST_UPDATE_TIME = "cloud:ems:query:last_update_time";
    //在线发快递数据新增同步云平台失败id列表key
    public static final String CLOUD_EMS_SEND_NEW_DATA_FAIL_ID_LIST = "cloud:ems:send:new_data_fail_id_list";
    //回收亭数据新增同步云平台失败id列表key
    public static final String CLOUD_HOUSE_SEND_NEW_DATA_FAIL_ID_LIST = "cloud:house:send:new_data_fail_id_list";
    //回收亭数据更新同步云平台失败id列表key
    public static final String CLOUD_HOUSE_SEND_UPDATE_DATA_FAIL_ID_LIST = "cloud:house:send:${substationId}:update_data_fail_id_list";
    //回收亭数据更新同步云平台最后时间
    public static final String CLOUD_HOUSE_SEND_UPDATE_LAST_UPDATE_TIME = "cloud:house:send:${substationId}:last_update_data_time";
    //水电缴费同步云平台失败id列表key
    public static final String CLOUD_ORDER_SEND_NEW_DATA_FAIL_ID_LIST = "cloud:order:send:new_data_fail_id_list";
    /***********************************云平台相关end***************************************/
    
    
    //微信用户token,过期时间设置为7天
    public static final String HL_WX_USER_TOKEN = "hl_user:wx_token:${token}";
    //用户未读消息最大id
    public static final String HL_WX_USER_UNREAD_MSG_ID = "hl_user:${uid}:unread_max_msg_id";
    
    /*************************************短信模板*****************************************************************/
    public static final String HL_SMS_TEMPLATE_CONTENT = "hl_sms_template:${tid}:sms_template_content";
    
    //分站信息表
    public static final String HL_SUBSTATION_STATUS = "hl_substation:${substationId}:status";
    //用户所在城市对应分站
    public static final String HL_SUBSTATION_USER_CURRENT_SUBSTATION = "hl_substation:hl_user:${uid}:current_substation";
    //回收亭对应的分站
    public static final String HL_SUBSTATION_HOUSE_CURRENT_SUBSTATION = "hl_substation:house:${houseId}:current_substation";
    //城市id对应分站站点名称spell
    public static final String HL_SUBSTATION_CITYID_SPELL = "hl_substation:cityId:spell:${cityId}";
    //分站id对应分站站点名称spell
    public static final String HL_SUBSTATION_ID_SPELL = "hl_substation:id:spell:${substationId}";
    //分站市级和县级(开通)和基础版本信息
    public static final String HL_SUBSTATION_CITY_CONTRY_VERSION = "hl_substation:cityContryVersion";
    
    /********************************************商城  start*************************************************************/
    //首页二级分类
    public static final String SHOP_CATEGORY_INDEX_LEVEL2_LIST = "shop_goods:shop_category_index_level2_list:${substationId}";
    //用户首页二级分类序号
    public static final String SHOP_CATEGORY_INDEX_LEVEL2_ORDERNO = "shop_goods:shop_category_index_level2:${uid}:orderno";
    //全部二级分类
    public static final String SHOP_CATEGORY_LEVEL2_ALL_LIST = "shop_category_level2_all_list:${substationId}";
    
    public static final String SHOP_CATEGORY_LEVEL2_LIST = "shop_goods:shop_category_level2:${substationId}:level2id:${level2id}:list";
    //商城一级分类
    public static final String SHOP_CATEGORY_LEVEL1_LIST = "shop_goods:shop_category_level1_list:substationspell:${substationId}";
    //商品单个信息
    public static final String SHOP_GOODS_ID_INFO = "shop_goods:shop_goods_id_info:${substationId}:${goodsId}";
    //商品单个信息 wx端使用
    public static final String SHOP_GOODS_ID_INFO_WX = "shop_goods:shop_goods_id_info_wx:${substationId}:${goodsId}";
    //商品sku信息
    public static final String SHOP_GOODS_SKU_INFO = "shop_goods:shop_goods_sku_info:${substationId}:${goodsId}:${skuValue1}:${skuValue2}";
    //最后一次订单提交时间戳
    public static final String SHOP_GOODS_ORDER_LAST_COMMIT = "shop_goods:shop_goods_order:last_commit_time:${uid}";
    //当前商品数量
    public static final String SHOP_GOODS_SKU_CURRENT_NUMBER = "shop_goods:shop_goods_sku:current_number:${substationId}:${goodsId}:${skuId}";
    
    /********************************咨询部分*****************************/
    //咨询信息分类
    public static final String LOCAL_NEWS_TYPE = "localnews:hl_localnews_type:substationspell:${substationspell}";
    //咨询大标题
    public static final String LOCAL_NEWS_INFO = "localnews:hl_localnews_info:substationspell:${substationspell}";
    
    
    
    
    
    
    
    
    
    
    
    /********************************************商城  end*************************************************************/
    
    /******************************************** 积分类型 start *************************************************************/
    /**
	 * 服务亭回收衣服乐豆
	 */
    public static final String POINTS_CHANNEL_CLOTHES = "hl_points_channel_type:clothes:${substationId}";
    /**
     * 服务亭回收印刷品乐豆
     */
    public static final String POINTS_CHANNEL_PRINT = "hl_points_channel_type:print:${substationId}";
    /**
     * 服务亭回收塑料乐豆
     */
    public static final String POINTS_CHANNEL_PLASTIC = "hl_points_channel_type:plastic:${substationId}";
    /**
     * 服务亭回收金属乐豆
     */
    public static final String POINTS_CHANNEL_METAL = "hl_points_channel_type:metal:${substationId}";
    /**
     * 服务亭回收家电乐豆
     */
    public static final String POINTS_CHANNEL_MACHINE = "hl_points_channel_type:machine:${substationId}";
    /**
     * 服务亭回收纸板乐豆
     */
    public static final String POINTS_CHANNEL_PAPER = "hl_points_channel_type:paper:${substationId}";
    /**
     * 服务亭回收饮料瓶乐豆 wangyonghui 2017-10-09 15:21:10
     */
    public static final String POINTS_CHANNEL_BOTTLE = "hl_points_channel_type:bottle:${substationId}";
    /**
     * 首次登录app送乐豆
     */
    public static final String POINTS_CHANNEL_FIRST_LOGIN_CASH = "hl_points_channel_type:first_login_cash:${substationId}";
    /**
	 * 首次登录app送积分
	 */
    public static final String POINTS_CHANNEL_FIRST_LOGIN = "hl_points_channel_type:first_login:${substationId}";
    /**
	 * 邀请好友注册送乐豆
	 */
    public static final String POINTS_CHANNEL_INVITE = "hl_points_channel_type:invite:${substationId}";
    /**
	 * 分享晒单送乐豆
	 */
    public static final String POINTS_CHANNEL_SHARE = "hl_points_channel_type:share:${substationId}";
    /**
     * 联运回收家电乐豆/台
     */
    public static final String POINTS_CHANNEL_LIANYUN_MACHINE = "hl_points_channel_type:lianyun:machine:${substationId}";

    /********************************************   联运回收机部分start *************************************************************/
    /**
     * 联运回收瓶子积分/瓶
     */
    public static final String POINTS_CHANNEL_LIANYUN_BOTTLE = "hl_points_channel_type:lianyun:bottle:${substationId}";
    /**
     * 联运回收纸板乐豆/公斤
     */
    public static final String POINTS_CHANNEL_LIANYUN_PAPER = "hl_points_channel_type:lianyun:paper:${substationId}";
    /**
     * 联运回收衣服乐豆/公斤
     */
    public static final String POINTS_CHANNEL_LIANYUN_CLOTHE = "hl_points_channel_type:lianyun:clothe:${substationId}";
    /**
     * 联运回收塑料乐豆/公斤 wangyonghui 2017-11-01 15:46:02
     */
    public static final String POINTS_CHANNEL_LIANYUN_PLASTIC = "hl_points_channel_type:lianyun:plastic:${substationId}";
    /**
     * 联运回收金属乐豆/公斤 wangyonghui 2017-11-01 15:46:09
     */
    public static final String POINTS_CHANNEL_LIANYUN_METAL = "hl_points_channel_type:lianyun:metal:${substationId}";
    /**
     * 联运回收玻璃乐豆/公斤 wangyonghui 2017-11-01 15:46:17
     */
    public static final String POINTS_CHANNEL_LIANYUN_GLASS = "hl_points_channel_type:lianyun:glass:${substationId}";
    
    /********************************************   联运回收机部分end *************************************************************/
    
    /********************************************   只能回收箱start *************************************************************/
    /**
	 * 使用智能回收箱/在线卖废品一个订单
	 */
	public static final String POINTS_CHANNEL_INTELLIGENCE_ONLINESELLORDER = "hl_points_channel_intelligence_type:onlinesellorder:${substationId}";
    
    /********************************************   只能回收箱end *************************************************************/

    
    /******************************************** 积分类型 end *************************************************************/
    
    /**
     * 用户手机号当天发送验证码次数
     */
    public static final String CUR_DAY_SMS_COUNT_OF_MOBILE = "hl_user:cur_day_sms_count_of_mobile:${mobile}";
    
    /**
	 * APP下单寄快递送积分
	 */
    public static final String POINTS_CHANNEL_EMS_SEND = "hl_points_channel_ems_send";
    
    /**
	 * 服务亭代收快递送积分
	 */
    public static final String POINTS_CHANNEL_EMS_RECEIVE = "hl_points_channel_ems_receive";
    
	/********************************************表结构定义end**********************************************/
}
