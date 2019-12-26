package com.lcke.demo.utils.tools;

import org.thymeleaf.util.MapUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnderscoredHumpTools {
	private static Pattern linePattern = Pattern.compile("_(\\w)");
	private static Pattern humpPattern = Pattern.compile("[A-Z]");
 
	/** 下划线转驼峰 */
	public static String lineToHump(String str) {
		str = str.toLowerCase();
		Matcher matcher = linePattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
	
	/** 下划线转驼峰 */
	public static Map<String, Object> lineToHump(Map<String, Object> map) {
		if (MapUtils.isEmpty(map)) return map;
		Map<String, Object> reMap = new HashMap<>();
		for (String key : map.keySet()) {
			reMap.put(lineToHump(key), map.get(key));
		}
		return reMap;
	}
 
    /** 驼峰转下划线 */
	public static String humpToLine(String str) {
		Matcher matcher = humpPattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
          matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
	
	/** 驼峰转下划线 */
	public static Map<String, Object> humpToLine(Map<String, Object> map){
		if (MapUtils.isEmpty(map)) return map;
		Map<String, Object> reMap = new HashMap<>();
		for (String key : map.keySet()) {
			reMap.put(humpToLine(key), map.get(key));
		}
		return reMap;
	}
 
}