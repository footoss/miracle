package com.footoss.miracle.web.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.footoss.basic.utils.StringHelper;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private HttpServletRequest request;
	
	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	private static String xssEncode(String s){
		if(StringHelper.isBlank(s)) 	return s;
		
		StringBuilder sb = new StringBuilder(s.length() + 16);
		char[] cArr =  s.toCharArray();
		for(char c : cArr){
			switch (c) {
				case '>': 	sb.append('＞'); 	break;	//全角
				case '<':  	sb.append('＜'); 	break;	//全角
				case '\'': 	sb.append('‘'); 	break; 	//全角
				case '\"':	sb.append('“'); 	break; 	//全角
				case '\\':  sb.append('＼'); 	break; 	//全角
				case '#':  	sb.append('＃'); 	break; 	//全角
				
				default:	sb.append(c);		break;
			}
		}
		
		return sb.toString();
	}

	@Override
	public String getHeader(String name) {
		String value = super.getHeader(xssEncode(name));
		
		if(null != value) 
			return xssEncode(value);
		return null;
	}

	
	
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(xssEncode(name));
		
		if(null != value)
			return xssEncode(value);
		return null;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public static HttpServletRequest getRequest(HttpServletRequest request){
		if(request instanceof XssHttpServletRequestWrapper){
			return ((XssHttpServletRequestWrapper)request).getRequest();
		}
		return request;
	}
	
}
