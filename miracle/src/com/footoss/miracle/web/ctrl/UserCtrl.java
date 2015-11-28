package com.footoss.miracle.web.ctrl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URLDecoder;

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
//	private static Logger logger = Logger.getLogger(PageCtrl.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String json = request.getQueryString();
		json = URLDecoder.decode(json, "UTF-8");
		System.out.println(json);
		Gson gson = new Gson();
		Type type = new TypeToken<PageModel<User>>(){}.getType();
		PageModel<User> pageModel = gson.fromJson(json, type);
		
		pageModel.validate();
		
		BaseDao<User> dao = new UserDao();
		BaseService<User> service = new UserService();
		service.setBaseDao(dao);
		service.listByPage(pageModel);
		
		outputJSON(pageModel, type ,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		this.doGet(req, resp);
	}

}
