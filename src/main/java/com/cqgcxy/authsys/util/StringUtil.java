///:StringUtil.java
package com.cqgcxy.authsys.util;

/**
 * description: 字符串工具类
 * @author sagachen created at 2017年10月7日 
 * @version 1.0
 */
public class StringUtil {
	/**
	 * 首字母小写
	 * @param old
	 * @return
	 */
	public static String lowerFirstChar(String old) {
		char first = old.charAt(0);
		StringBuffer sb = new StringBuffer(old);
		sb.replace(0, 1, String.valueOf(Character.toLowerCase(first)));
		return sb.toString();
	}
	/**
	 * 首字母大写
	 * @param old
	 * @return
	 */
	public static String upperFirstChar(String old) {
		char[] chars = old.toCharArray();
		if (chars[0] > 97 && chars[0] <= 122) {
			chars[0] -= 32;
		}
		return String.valueOf(chars);
	}
}
///:StringUtil.java