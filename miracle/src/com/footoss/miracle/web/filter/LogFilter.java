package com.footoss.miracle.web.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {

	private static Logger logger = Logger.getLogger(LogFilter.class.getName());
	
	@Override
	public void destroy() {
		logger.info("日志过滤器销毁完毕！");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		ServletContext context = req.getServletContext();
		HttpServletRequest request = (HttpServletRequest )req;
		String requestPath = request.getServletPath();
		logger.info("Request Path --->  " + requestPath);
		context.log(requestPath);
		filterChain.doFilter(request, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("日志过滤器初始化完毕!");
	}

}
