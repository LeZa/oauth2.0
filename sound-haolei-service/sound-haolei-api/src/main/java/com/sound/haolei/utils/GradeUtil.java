package com.sound.haolei.utils;


public class GradeUtil {
	

	/**
	 * 
	 * @Title: getFirstLogin 
	 * @Description: 注册首次登陆获取平民等级 
	 * 从1开始，1平民，2楼长，3经理，4主任，5区长
	 * @return    设定文件 
	 * Integer    返回类型 
	 * @throws 
	 * @author tianyunyun
	 * @date 2017年5月17日 下午2:21:30
	 */
	public static Integer getFirstLogin(){
		return 1;
	}
	/**
	 * 
	 * @Title: getGradeByPoint 
	 * @Description: 根据积分获取等级 
	 * @param point
	 * @return    设定文件 
	 * Integer    返回类型 
	 * @throws 
	 * @author tianyunyun
	 * @date 2017年5月17日 下午2:26:01
	 */
	public static Integer getGradeByPoint(Integer point){
		if(null != point && point >= 10000){
			return 5;
		}else if(point >= 5000){
			return 4;
		}else if(point >= 2000){
			return 3;
		}else if(point >= 800){
			return 2;
		}
		return 1;
	}
	/**
	 * 
	 * @Title: getGradeByPoint 
	 * @Description: 根据积分获取等级名称
	 * @param point
	 * @return    设定文件 
	 * String    返回类型 
	 * @throws 
	 * @author wangyonbghui
	 * @date 2017年9月14日 11:46:07
	 */
	public static String getGradeNameByPoint(Integer point){
		if(null != point && point >= 10000){
			return "区长";
		}else if(point >= 5000){
			return "主任";
		}else if(point >= 2000){
			return "经理";
		}else if(point >= 800){
			return "楼长";
		}
		return "平民";
	}
	
	/**
	 * 根据等级获取等级民称
	* @Title: getGradeNameByGrade
	* @param grade
	* @return
	* @author wangyonghui
	* @date 2017年9月14日 下午12:00:56
	 */
	public static String getGradeNameByGrade(String grade){
		if("1".equals(grade)){
			return "平民";
		}
		if("2".equals(grade)){
			return "楼长";
		}
		if("3".equals(grade)){
			return "经理";
		}
		if("4".equals(grade)){
			return "主任";
		}
		if("5".equals(grade)){
			return "区长";
		}
		return grade;
	}
}
