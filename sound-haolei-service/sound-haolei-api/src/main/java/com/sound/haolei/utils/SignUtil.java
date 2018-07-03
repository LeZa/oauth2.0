package com.sound.haolei.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 验证微信签名信息
 * @author zhangyong
 *
 */
public class SignUtil {
	private static String token = "duomeidaitoken";
	
	/**
	 * 验证签名
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce){
		String[] arr = new String[]{token, timestamp, nonce};
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder();
		for(int i=0;i<arr.length;i++){
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;
		
		try{
			md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		content = null;
		
		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	}
	
    /** 
     * 将字节数组转换为十六进制字符串 
     *  
     * @param byteArray 
     * @return 
     */  
    private static String byteToStr(byte[] byteArray) {  
        String strDigest = "";  
        for (int i = 0; i < byteArray.length; i++) {  
            strDigest += byteToHexStr(byteArray[i]);  
        }  
        return strDigest;  
    }  
  
    /** 
     * 将字节转换为十六进制字符串 
     *  
     * @param mByte 
     * @return 
     */  
    private static String byteToHexStr(byte mByte) {  
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
        char[] tempArr = new char[2];  
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];  
        tempArr[1] = Digit[mByte & 0X0F];  
  
        String s = new String(tempArr);  
        return s;  
    }  
    
    
    /**
     * 
    * @Title: createWMSToken 
    * @Description: 生成库存管理系统token
    * @param params 参与签名的键值对
    * @param salt 加密的私钥
    * @return    设定文件 
    * @return String    返回类型 
    * @throws 
    * @author wangzhanguo
    * @date 2017年11月16日 上午11:26:41
     */
	public static String createWMSToken(Map<String,String> params,String salt){
    	// 先将参数以其参数名的字典序升序进行排序
        TreeMap<String, String> sortedParams = new TreeMap<>(params);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> param : sortedParams.entrySet()) {
        	String strParam = param.getValue();
        	if(strParam != null && !strParam.equals("false") && !strParam.equals("0")){
        		sb.append(param.getKey()).append(strParam);
        	}
        }
        sb.append(salt);
    	return ConversionMd5.toMd5(sb.toString());
    }
    
    
}
