package com.footoss.basic.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.footoss.basic.exception.ParameterException;

public class RequestHelper {

	
	public static String getParameterNullSafe(HttpServletRequest request,String paramName){
		return StringHelper.trim(request.getParameter(paramName));
	}
	
	public static String getParameterRequired(HttpServletRequest request,String paramName) 
		throws ParameterException
	{
		String retData = request.getParameter(paramName);
		if(StringHelper.isBlank(retData))
			throw new ParameterException(paramName);
		return retData;
	}
	
	public static Map<String, Object> getParameterMutiPart(HttpServletRequest request) {
		return null;
	}
	
	public static Map<String,Object> getParameterMap(HttpServletRequest request){
		String contentType = request.getContentType();
		if(!StringHelper.isBlank(contentType) 
				&& contentType.toLowerCase().indexOf("multipart/form-data") > 0){
//			return getParameterMutiPart(request);
			return null;
		}
		
		Map<String,Object>   paramsMap		= new HashMap<>();
		Map<String,String[]> requestParams 	= request.getParameterMap();
		Iterator<String> it = requestParams.keySet().iterator();
		while(it.hasNext()){
			String name = it.next();
			String[] values = requestParams.get(name);
			StringBuilder sb = new StringBuilder();
			
			for(String str : values){
				sb.append(str).append(","); 
			}
			
			String valueStr = sb.substring(0, sb.length()-1);
			if(sb.toString().length()>0) paramsMap.put(name, valueStr.trim());
		}
		
		return paramsMap;
	}
	
	

	public static Map<String,Object> getParameterMapRequired(HttpServletRequest request)
		throws ParameterException
	{
		Map<String,Object> paramsMap = getParameterMap(request);
		if(0 == paramsMap.size()){
			throw new ParameterException("至少需要一个参数");
		}
		return paramsMap;
	}
	
	
}
