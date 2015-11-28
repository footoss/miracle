package com.footoss.miracle.web.ctrl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.footoss.basic.common.PageModel;
import com.footoss.basic.ctrl.BaseCtrl;
import com.footoss.miracle.dao.BaseDao;
import com.footoss.miracle.dao.impl.UserDao;
import com.footoss.miracle.domain.User;
import com.footoss.miracle.service.BaseService;
import com.footoss.miracle.service.UserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UserCtrl extends BaseCtrl {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9167202579673171395L;
	private static Logger logger = Logger.getLogger(UserCtrl.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String json = request.getQueryString();
		
		PageModel<User> pageModel = null;
		if(null == json){
			pageModel = new PageModel<>(); 
			wrapperPageModel(pageModel);
			json = getJSON(pageModel);
			request.setAttribute("data", json);
			request.getRequestDispatcher("/WEB-INF/views/user/list.jsp").forward(request, response);
			return;
		}else{
			json = URLDecoder.decode(json, "UTF-8");
			logger.info("request json is : " + json);
			Gson gson = new Gson();
			Type type = new TypeToken<PageModel<User>>(){}.getType();
			pageModel = gson.fromJson(json, type);
			wrapperPageModel(pageModel);
			outputJSON(pageModel, type ,response);
			return;
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		this.doGet(req, resp);
	}
	
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("user service");
		logger.info(request.getMethod());
		super.service(request, response);
	}

	public void wrapperPageModel(PageModel<User> pageModel){
		pageModel.validate();
		
		BaseDao<User> dao = new UserDao();
		BaseService<User> service = new UserService();
		service.setBaseDao(dao);
		service.listByPage(pageModel);
	}

}
