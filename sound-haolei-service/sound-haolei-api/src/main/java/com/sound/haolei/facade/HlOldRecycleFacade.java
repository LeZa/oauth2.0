package com.sound.haolei.facade;

import java.math.BigDecimal;
import java.util.Map;

import com.sound.haolei.model.HlOldRecycle;


public interface HlOldRecycleFacade extends BaseFacade<HlOldRecycle> {
	/**
	 * @describe:有得卖 推送消息到好嘞，生成订单接口
	 * @author wangruwei
	 * @date 2018年3月13日上午10:27:15
	 * `product_Code` varchar(50) NOT NULL COMMENT '商品编码',
	  `product_Name` varchar(255) NOT NULL COMMENT '商品名称',
	  `product_Type` varchar(2) NOT NULL COMMENT '商品分类',
	  `product_Img` varchar(100) NOT NULL COMMENT '可以是图片链接也可以是图片附件',
	  `product_Attrs` varchar(500) NOT NULL COMMENT '商品使用描述。格式 Q:A;Q:A;',
	  `event_Code` varchar(20) DEFAULT NULL COMMENT '所选活动码',
	  `order_No` varchar(30) NOT NULL COMMENT '有得卖回收单号',
	  `order_Price` decimal(10,2) NOT NULL COMMENT '订单价格。精确到元',
	  `order_Source` int(2) NOT NULL COMMENT '1、PC端；2、无线端；',
	  `order_Status` int(2) NOT NULL COMMENT '回收单状态',
	  `contacts` varchar(20) NOT NULL COMMENT '联系人',
	  `mobile` varchar(20) NOT NULL COMMENT '联系电话',
	  `contact_Address` varchar(100) NOT NULL COMMENT ' 联系地址',
	  `trade_Type` int(2) NOT NULL COMMENT '交易方式。1:上门回收；2:快递寄运；5:地铁交易',
	  `remark` varchar(100) DEFAULT NULL COMMENT '回收单备注',
	  `user_Id` varchar(32) NOT NULL COMMENT '合作端用户的唯一ID，供发券使用',
	  `partner_Id` varchar(10) NOT NULL COMMENT '合作方唯一ID',
	  `sign` varchar(32) NOT NULL COMMENT '加密标记',
	  `c_time` datetime DEFAULT NULL COMMENT '创建时间',
	 * @return
	 */
	Map<String, Object> createOrderInfo(String productCode, String productName, String productType, String productImg,
			String productAttrs, String eventCode, String orderNo, BigDecimal orderPrice, Integer orderSource,
			Integer orderStatus, String contacts, String mobile, String contactAddress, Integer tradeType,
			String remark, String userId, String partnerId, String sign);
	/**
	 * @describe:更新订单状态
	 * @author wangruwei
	 * @date 2018年3月13日上午11:23:26
	 * @param orderNo	回收单编号
	 * @param currStatus	当前回收单状态
	 * @param nextStatus	回收单目标状态
	 * @param remark		备注信息
	 * @param partnerId		合作商id
	 * @param sign			加密标记
	 * @return
	 */
	Map<String, Object> updateOrderInfo(String orderNo, Integer currStatus, Integer nextStatus, String remark,
			String partnerId, String sign);
	/**
	 * @describe:查询订单分页，对PHP的接口
	 * @author wangruwei
	 * @date 2018年3月13日下午3:36:26
	 * @param startDate	开始日期
	 * @param endDate	结束日期
	 * @param status	订单状态
	 * @param tradeType	交易方式
	 * @param productType	商品分类
	 * @param phoneNum	电话号码
	 * @param lastId 
	 * @param size 
	 * @param which 
	 * @return
	 */
	Map<String, Object> selectOrdersPage(String startDate, String endDate, Integer status, Integer tradeType,
			String productType, String phoneNum, String which, Integer size, Integer lastId);
	
}

