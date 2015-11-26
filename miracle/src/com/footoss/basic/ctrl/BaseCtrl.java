package com.footoss.basic.ctrl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.footoss.basic.constant.Constants;
import com.google.gson.GsonBuilder;

public class BaseCtrl extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8967594667062181067L;

	private static Logger logger = Logger.getLogger(BaseCtrl.class.getName());
	
	public String outputJSON(Object obj, Type type , HttpServletResponse response) {
		String json = new GsonBuilder().setDateFormat(Constants.DATE_TIME_FORMAT).create().toJson(obj,type);
		logger.info(json);
		return output(json, response);
	}
	
	public String outputJSON(Object obj, HttpServletResponse response) {
		String json = new GsonBuilder().setDateFormat(Constants.DATE_TIME_FORMAT).create().toJson(obj);
		logger.info(json);
		return output(json, response);
	}
	
	public String output(Object obj, HttpServletResponse response) {
		response.setCharacterEncoding(Constants.CHARSET);
		try {
			response.getWriter().print(obj);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			logger.log(Level.WARNING, "IO异常", e);
		}
		return null;
	}
}
