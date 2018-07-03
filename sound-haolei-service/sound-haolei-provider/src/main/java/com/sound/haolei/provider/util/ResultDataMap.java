package com.sound.haolei.provider.util;

import java.util.HashMap;
import java.util.Map;

public class ResultDataMap {
	public static Map<String, Object> getRtnCode(Object data, String msg, Integer code) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("code", code);
		rtn.put("msg", msg);
		rtn.put("data", data);
		return rtn;
	}
}
