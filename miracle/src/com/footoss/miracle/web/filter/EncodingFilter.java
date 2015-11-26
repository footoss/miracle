package com.footoss.miracle.web.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sound.sampled.AudioFormat.Encoding;

public class EncodingFilter implements Filter {
	
	private static Logger logger = Logger.getLogger(Encoding.class.getName());
	
	private Map<String,String> filterParams = null; 
	
	@Override
	public void destroy() {
		logger.info("EncodingFilter destroyed!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		String encoding = filterParams.get("encoding");
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=UTF-8");
		filterChain.doFilter(request, response);
		
		logger.info("EnchodingFilter setCharacterEncoding  --->  " + encoding);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Enumeration<String> paramNames =  filterConfig.getInitParameterNames();
		if(!paramNames.hasMoreElements())	return;
		
		filterParams = new HashMap<>();
		while(paramNames.hasMoreElements()){
			String paramName = paramNames.nextElement();
			String paramValue= filterConfig.getInitParameter(paramName);
			filterParams.put(paramName, paramValue);
		}
		
		logger.info("字符集过滤器初始化完毕！");
	}

	
}
