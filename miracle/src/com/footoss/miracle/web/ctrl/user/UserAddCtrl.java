package com.footoss.miracle.web.ctrl.user;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.footoss.basic.common.PageModel;
import com.footoss.basic.ctrl.BaseCtrl;
import com.footoss.miracle.domain.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UserAddCtrl extends BaseCtrl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4158054591612531511L;
	private static Logger logger = Logger.getLogger(UserAddCtrl.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/user/add.jsp").forward(request, response);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = getPostJson(request);
		json = URLDecoder.decode(json, "UTF-8");
		logger.info("request json is : " + json);
		Gson gson = new Gson();
		Type type = new TypeToken<User>(){}.getType();
		User user = gson.fromJson(json, type);
		outputJSON(user, type ,response);
		return;
	}
	
	

}
