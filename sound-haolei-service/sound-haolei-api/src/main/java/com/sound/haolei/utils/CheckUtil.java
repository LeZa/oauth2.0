package com.sound.haolei.utils;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtil {

    public static boolean isEmpty(Object... param){
        if(null == param){
            return true;
        }
        if("".equals(param)){
            return true;
        }

        for(Object obj :param){
            if(!validatorParamNotEmpty(obj)){
                return true;
            }
        }
        return false;
    }

    private static boolean validatorParamNotEmpty(Object obj) {
        if(null == obj){
            return false;
        }
        // validate String
        if(String.class.isInstance(obj)){
            if("undefined".equals(obj) || 0 == ((String)obj).length()){
                return false;
            }
        }
        // validate Collection
        if(Collection.class.isInstance(obj)){
            if(0 == ((Collection<?>)obj).size()){
                return false;
            }
        }
        // validate Map
        if(Map.class.isInstance(obj)){
            if(0 == ((Map<?, ?>)obj).size()){
                return false;
            }
        }
        // validate Arrays
        if(Arrays.class.isInstance(obj)){
            if(0 == Array.getLength(obj)){
                return false;
            }
        }
        return true;
    }

    /**
     * 在使用正则表达式时，利用好其预编译功能，可以有效加快正则匹配速度
     */
    private static Pattern PHONE_PATTERN = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
    /**
     * 验证手机号
     * @param mobile
     * @author chenrui
     * @return 手机号格式正确:true,不正确:false
     */
    public static boolean isMobile(String mobile) {
        //Pattern p = null;
        Matcher m = null;
        boolean b = false;
        //p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        //m = p.matcher(mobile);
        m = PHONE_PATTERN.matcher(mobile);
        b = m.matches();
        return b;
    }

    /**
     * 验证是否数字
     * @param str
     * @return
     */
    public static boolean isInteger(Object str){
        if(null==str){
            return false;
        }
        String isstr = str + "";
        return isstr.matches("[0-9]+");
    }

    /**
	 * @describe:验证日期格式是否正确
	 * @author wangruwei
	 * @date 2017年11月2日下午2:49:19
	 * @param dateStr
	 * @return
	 */
	public static boolean validatorDateStr(String dateStr) {
		boolean convertSuccess = true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			// 设置lenient为false.
			// 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(dateStr);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}
}

