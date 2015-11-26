package com.footoss.miracle.web.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.footoss.miracle.web.http.XssHttpServletRequestWrapper;

public class XssFilter implements Filter{

	private static Logger logger = Logger.getLogger(XssFilter.class.getName());
	
	@Override
	public void destroy() {
		logger.info("anit xss attach filter destroyed!");		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest)request);		
		
		filterChain.doFilter(xssRequest, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("anti xss attach filter init!");
	}

	
}
