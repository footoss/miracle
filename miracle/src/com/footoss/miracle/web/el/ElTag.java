package com.footoss.miracle.web.el;

import javax.servlet.http.HttpServletRequest;

import com.footoss.basic.utils.StringHelper;

public class ElTag {

	public static String basePath(HttpServletRequest request){
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		return basePath;
	}
	
	public static String reverse(String str){
		return StringHelper.reverse(str);
	}
}
