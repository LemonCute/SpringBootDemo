/*
 * All rights reserved.  http://www.tansun.com.cn
 *
 * This software is the confidential and proprietary information of Tansun Tech Corporation ("Confidential Information").  
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Tansun Tech.
 */
package com.lcke.demo.utils.tools;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 *  web 端 工具类
 * </pre>
 * 
 * @author 林凯<br>
 * <b>mail</b> linkai@tansun.com.cn<br>
 * <b>date</b> 2018年9月6日 下午5:45:45<br>
 * @version 1.0.1
 */
public class TsWebUtil {

	/**
	 * 判断是否为ip地址
	 * @param ip ip地址
	 * @return true：是 false：否
	 * 
	 * <pre>
	 * <b>处理逻辑：</b>
	 * </pre>
	 */
	public static boolean isIp(String ip) {
		if (ip.length() < 7 || ip.length() > 15 || "".equals(ip))
			return false;
		// 判断IP格式和范围
		String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
		Pattern pat = Pattern.compile(rexp);
		Matcher mat = pat.matcher(ip);
		return mat.find();
	}

	/**
	 * 获取客户端地址
	 * @param request {@link HttpServletRequest request}
	 * @return 地址
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		String ip = "";
		try {
			ip = request.getHeader("X-real-ip");// 先从nginx自定义配置获取
			if (!StringUtils.hasLength(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("x-forwarded-for");
				if (StringUtils.hasLength(ip)) {
					String[] attr = StringUtils.delimitedListToStringArray(ip, ",");
					ip = attr[0];
				}
			}
			if (!StringUtils.hasLength(ip) || "unknown".equalsIgnoreCase(ip))
				ip = request.getHeader("Proxy-Client-IP");
			if (!StringUtils.hasLength(ip) || "unknown".equalsIgnoreCase(ip))
				ip = request.getHeader("WL-Proxy-Client-IP");
			if (!StringUtils.hasLength(ip) || "unknown".equalsIgnoreCase(ip))
				ip = request.getRemoteAddr();
			if ((ip.equals("127.0.0.1")) || (ip.toLowerCase().equals("localhost")) || (ip.equals("0:0:0:0:0:0:0:1"))) {
				ip = InetAddress.getLocalHost().getHostAddress();
			}
		} catch (UnknownHostException e) {
		}
		return ip;
	}
}
