package com.sound.haolei.provider.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.dubbo.config.annotation.Service;
import com.sound.haolei.constants.DefaultValueConstants;
import com.sound.haolei.facade.HlOldRecycleFacade;
import com.sound.haolei.model.HlOldRecycle;
import com.sound.haolei.model.HlOldRecycleTrack;
import com.sound.haolei.provider.dao.HlOldRecycleMapper;
import com.sound.haolei.provider.dao.HlOldRecycleTrackMapper;
import com.sound.haolei.utils.CheckUtil;

@Service(version = "1.0.0", application = "${dubbo.application.id}", protocol = "${dubbo.protocol.id}", registry = "${dubbo.registry.id}")
public class HlOldRecycleFacadeImpl extends BaseFacadeImpl<HlOldRecycle, HlOldRecycleMapper>
		implements HlOldRecycleFacade {

	@Autowired
	private HlOldRecycleMapper hlOldRecycleMapper;
	
	@Autowired
	private HlOldRecycleTrackMapper hlOldRecycleTrackMapper;

	@Override
	public HlOldRecycleMapper getMapper() throws Exception {
		return hlOldRecycleMapper;
	}

	/**
	 * @describe:有得卖 推送消息到好嘞，生成订单接口
	 * @author wangruwei
	 * @date 2018年3月13日上午10:27:15 `product_Code` varchar(50) NOT NULL COMMENT
	 *       '商品编码', `product_Name` varchar(255) NOT NULL COMMENT '商品名称',
	 *       `product_Type` varchar(2) NOT NULL COMMENT '商品分类', `product_Img`
	 *       varchar(100) NOT NULL COMMENT '可以是图片链接也可以是图片附件', `product_Attrs`
	 *       varchar(500) NOT NULL COMMENT '商品使用描述。格式 Q:A;Q:A;', `event_Code`
	 *       varchar(20) DEFAULT NULL COMMENT '所选活动码', `order_No` varchar(30)
	 *       NOT NULL COMMENT '有得卖回收单号', `order_Price` decimal(10,2) NOT NULL
	 *       COMMENT '订单价格。精确到元', `order_Source` int(2) NOT NULL COMMENT
	 *       '1、PC端；2、无线端；', `order_Status` int(2) NOT NULL COMMENT '回收单状态',
	 *       `contacts` varchar(20) NOT NULL COMMENT '联系人', `mobile` varchar(20)
	 *       NOT NULL COMMENT '联系电话', `contact_Address` varchar(100) NOT NULL
	 *       COMMENT ' 联系地址', `trade_Type` int(2) NOT NULL COMMENT
	 *       '交易方式。1:上门回收；2:快递寄运；5:地铁交易', `remark` varchar(100) DEFAULT NULL
	 *       COMMENT '回收单备注', `user_Id` varchar(32) NOT NULL COMMENT
	 *       '合作端用户的唯一ID，供发券使用', `partner_Id` varchar(10) NOT NULL COMMENT
	 *       '合作方唯一ID', `sign` varchar(32) NOT NULL COMMENT '加密标记', `c_time`
	 *       datetime DEFAULT NULL COMMENT '创建时间',
	 * @return
	 */
	@Override
	public Map<String, Object> createOrderInfo(String productCode, String productName, String productType,
			String productImg, String productAttrs, String eventCode, String orderNo, BigDecimal orderPrice,
			Integer orderSource, Integer orderStatus, String contacts, String mobile, String contactAddress,
			Integer tradeType, String remark, String userId, String partnerId, String sign) {
		if (CheckUtil.isEmpty(productCode)) {
			return getFailRtn("商品编码不能为空");
		}
		if (CheckUtil.isEmpty(productName)) {
			return getFailRtn("商品名称不能为空");
		}
		if (CheckUtil.isEmpty(productType)) {
			return getFailRtn("商品分类不能为空");
		}
		if (CheckUtil.isEmpty(productImg)) {
			return getFailRtn("商品图片链接不能为空");
		}
		if (CheckUtil.isEmpty(productAttrs)) {
			return getFailRtn("商品使用描述不能为空");
		}
//		if (CheckUtil.isEmpty(eventCode)) {
//			return getFailRtn("所选活动码不能为空");
//		}
		if (CheckUtil.isEmpty(orderNo)) {
			return getFailRtn("回收单号不能为空");
		}
		if (CheckUtil.isEmpty(orderPrice)) {
			return getFailRtn("订单价格不能为空");
		}
		if (CheckUtil.isEmpty(orderSource)) {
			return getFailRtn("回收单来源不能为空");
		}
		if (CheckUtil.isEmpty(orderStatus)) {
			return getFailRtn("回收单状态不能为空");
		}
		if (CheckUtil.isEmpty(contacts)) {
			return getFailRtn("联系人不能为空");
		}
		if (CheckUtil.isEmpty(mobile)) {
			return getFailRtn("联系电话不能为空");
		}
		if (CheckUtil.isEmpty(contactAddress)) {
			return getFailRtn("联系地址不能为空");
		}
		if (CheckUtil.isEmpty(tradeType)) {
			return getFailRtn("交易方式不能为空");
		}
//		if (CheckUtil.isEmpty(remark)) {
//			return getFailRtn("回收单备注不能为空");
//		}
		if (CheckUtil.isEmpty(userId)) {
			return getFailRtn("用户ID不能为空");
		}
		if (CheckUtil.isEmpty(partnerId)) {
			return getFailRtn("合作商id不能为空");
		}
		if (CheckUtil.isEmpty(sign)) {
			return getFailRtn("加密标记不能为空");
		}
		
		try {
			//orderNum如果存在，告诉已经存在
			Map<String,Object> csmap = new HashMap<String,Object>();
			csmap.put("orderNo", orderNo);
			List<HlOldRecycle> hlOldRecycleList = hlOldRecycleMapper.selectByCondition(csmap);
			if(hlOldRecycleList.size()>0){
				return getFailRtn("此单号已经存在:"+orderNo);
			}
			
			HlOldRecycle hlOldRecycle = new HlOldRecycle();
			hlOldRecycle.setProductCode(productCode);
			hlOldRecycle.setProductName(productName);
			hlOldRecycle.setProductType(productType);
			hlOldRecycle.setProductImg(productImg);
			hlOldRecycle.setProductAttrs(productAttrs);
			hlOldRecycle.setEventCode(eventCode);
			hlOldRecycle.setOrderNo(orderNo);
			hlOldRecycle.setOrderPrice(orderPrice);
			hlOldRecycle.setOrderSource(orderSource);
			hlOldRecycle.setOrderStatus(orderStatus);
			hlOldRecycle.setContacts(contacts);
			hlOldRecycle.setMobile(mobile);
			hlOldRecycle.setContactAddress(contactAddress);
			hlOldRecycle.setTradeType(tradeType);
			hlOldRecycle.setRemark(remark);
			hlOldRecycle.setUserId(userId);
			hlOldRecycle.setPartnerId(partnerId);
			hlOldRecycle.setSign(sign);
			hlOldRecycle.setcTime(new Date());
			
			hlOldRecycleMapper.insertSelective(hlOldRecycle);
			return getSussRtn("推送成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return getFailRtn("推送失败",e.getMessage());
		}
		
		

	}
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
	@Override
	public Map<String, Object> updateOrderInfo(String orderNo, Integer currStatus, Integer nextStatus, String remark,
			String partnerId, String sign) {
		if(CheckUtil.isEmpty(orderNo)){
			return getFailRtn("回收单编号不能为空");
		}
		if(CheckUtil.isEmpty(currStatus)){
			return getFailRtn("当前回收单状态不能为空");
		}
		if(CheckUtil.isEmpty(nextStatus)){
			return getFailRtn("回收单目标状态不能为空");
		}
		if(currStatus==nextStatus){
			return getFailRtn("目标状态与当前状态不能相同");
		}
		if(CheckUtil.isEmpty(remark)){
			return getFailRtn("备注不能为空");
		}
		if(CheckUtil.isEmpty(partnerId)){
			return getFailRtn("合作商id不能为空");
		}
		if(CheckUtil.isEmpty(sign)){
			return getFailRtn("加密标记不能为空");
		}
		
		try {
			//先更新主数据表，再插入track表
			//1,更新主数据表
			HlOldRecycle hloldRecycle = new HlOldRecycle();
			hloldRecycle.setOrderNo(orderNo);
			hloldRecycle.setOrderStatus(nextStatus);
			hloldRecycle.setRemark(remark);
			int updateNum = hlOldRecycleMapper.updateByCondition(hloldRecycle);
			if(updateNum<1){
				return getFailRtn("没有找到此订单");
			}
			
			//2插入track
			HlOldRecycleTrack hloldtrack = new HlOldRecycleTrack();
			hloldtrack.setOrderNo(orderNo);
			hloldtrack.setCurrStatus(currStatus);
			hloldtrack.setNextStatus(nextStatus);
			hloldtrack.setRemark(remark);
			hloldtrack.setCtime(new Date());
			hlOldRecycleTrackMapper.insertSelective(hloldtrack);
			
			return getSussRtn("更新成功",null);
		} catch (Exception e) {
			e.printStackTrace();
			return getFailRtn("更新失败",e.getMessage());
		}
	}
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
	 * @return
	 */
	@Override
	public Map<String, Object> selectOrdersPage(String startDate, String endDate, Integer status, Integer tradeType,
			String productType, String phoneNum, String which, Integer size, Integer lastId
			
			) {
		Map<String,Object> csmap = new HashMap<String,Object>();
		if(!CheckUtil.isEmpty(startDate)){
			if(CheckUtil.validatorDateStr(startDate)){
				csmap.put("startDate", startDate);
			}else{
				return getFailRtn("开始时间格式不正确");
			}
		}
		if(!CheckUtil.isEmpty(endDate)){
			if(CheckUtil.validatorDateStr(endDate)){
				csmap.put("endDate", endDate);
			}else{
				return getFailRtn("结束时间格式不正确");
			}
		}
		if(!CheckUtil.isEmpty(status)){
			csmap.put("status", status);
		}
		if(!CheckUtil.isEmpty(tradeType)){
			csmap.put("tradeType", tradeType);
		}
		if(!CheckUtil.isEmpty(productType)){
			csmap.put("productType", productType);
		}
		if(!CheckUtil.isEmpty(phoneNum)){
			csmap.put("phoneNum", phoneNum);
		}
		csmap.put(DefaultValueConstants.PAGE_WHICH, which);
		csmap.put(DefaultValueConstants.PAGE_SIZE, size);
		csmap.put(DefaultValueConstants.PAGE_LAST_ID, lastId);
		
		List<HlOldRecycle> list = hlOldRecycleMapper.queryOldRecyclePage(csmap);
		if(list.size()>0){
			return getSussRtn(list);
		}else{
			return getSussRtn(new ArrayList<HlOldRecycle>());
		}
	}
}
