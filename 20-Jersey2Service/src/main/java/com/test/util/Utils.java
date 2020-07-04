package com.test.util;

import java.util.Map;

public class Utils {
	
	public static <T> T getValue(Map<String,Object> map, String key, T defValue) {
		Object o = null;
		T t = null;
		if(map == null) {
			return defValue;
		}
		
		o = map.get(key);
		if(o == null) {
			return defValue;
		}
		try {
			t = (T) o;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return t;
	}

}
