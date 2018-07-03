package com.sound.haolei.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 处理时间格式函数
 * 
 * @author zhangyong
 */
public class DateUtil {
	private Date date;

	public DateUtil(Date date) {
		if (null == date) {
			date = new Date();
		} else {
			this.date = date;
		}
	}

	/**
	 * 格式化时间样式
	 * 
	 * @return 返回 yyyy-MM-dd HH:mm:ss 格式字符串
	 */
	public String toFormat() {
		String patten = "yyyy-MM-dd HH:mm:ss";
		return toFormat(patten);
	}

	/**
	 * 格式化为指定格式
	 * 
	 * @param patten
	 *            日期格式如：yyyy/MM/dd
	 */
	public String toFormat(String patten) {
		SimpleDateFormat sdf = new SimpleDateFormat(patten);
		String returnStr = sdf.format(date);

		return returnStr;
	}

	/**
	 * 格式化为指定格式
	 * 
	 * @param patten
	 *            日期格式如：yyyy-MM-dd HH:mm:ss
	 * @throws ParseException 
	 */
	public Date str2Date(String strDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(strDate);
	}
	/**
	 * 
	* @Title: dateToString
	* @Description: 时间转字符串
	* @param @param date
	* @param @return
	* @param @throws ParseException    设定文件 
	* @return String    返回类型 
	* @throws 
	* @author Lvshiyang
	* @date 2017年11月23日 下午6:24:14
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
		 
	}

	
	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 获取某月的天数
	 * 
	 * @param year
	 *            年份,如果不传默认使用当前年
	 * @param month
	 *            月份,入股不传默认使用当前月
	 * @return
	 */
	public static int getDaysOfMonth(Integer year, Integer month) {
		Calendar time = Calendar.getInstance();
		//获取当前年月
		int currYear = time.get(Calendar.YEAR);
		int currMonth = time.get(Calendar.MONTH) + 1;
		time.clear();
		time.set(Calendar.YEAR, null == year ? currYear : year);
		time.set(Calendar.MONTH, null == month ? currMonth : month - 1);
		return time.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

    /**
     * @Description  获取当前时间的当前月的第一天
     */
    public static String firstDayOfMonth(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar   cal_1=Calendar.getInstance();
        cal_1.add(Calendar.MONTH, -1);
        cal_1.set(Calendar.DAY_OF_MONTH,1);
        return sdf.format(cal_1.getTime());
    }

    /**
     * @Description 获取当前时间的当前月的最后一天
     */
    public static String lastDayOfMonth(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH,0);
        return sdf.format(cale.getTime());
    }
}
