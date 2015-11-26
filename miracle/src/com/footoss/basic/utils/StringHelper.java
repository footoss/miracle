package com.footoss.basic.utils;

public class StringHelper {

	private StringHelper(){}
	
	public static String trim(Object obj){
		return null == obj ? "" : obj.toString().trim();
	}
	
	public static boolean isBlank(Object obj){
		return "".equals(trim(obj));
	}
	
	public static String reverse(String str){
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}
}
