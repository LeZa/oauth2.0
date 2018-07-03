package com.sound.haolei.provider.dao;

import com.sound.haolei.model.HsMachineLianyunMchidSubstation;

public interface HsMachineLianyunMchidSubstationMapper  extends IBaseMapper<HsMachineLianyunMchidSubstation> {

	/**
	 * 
	 * @Title: selectByMchid 
	 * @Description: 根据机器码获取 
	 * @param mchid
	 * @return    设定文件 
	 * HsMachineLianyunMchidSubstation    返回类型 
	 * @throws 
	 * @author tianyunyun
	 * @date 2017年7月19日 下午3:32:47
	 */
	HsMachineLianyunMchidSubstation selectByMchid(String mchid);
}