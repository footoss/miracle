package com.footoss.miracle.web.ctrl.user;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.footoss.basic.ctrl.BaseCtrl;

public class UserAddCtrl extends BaseCtrl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4158054591612531511L;
	private static Logger logger = Logger.getLogger(UserAddCtrl.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/user/add.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
	

}
