package com.footoss.test;

import java.util.HashMap;
import java.util.Map;

import com.footoss.basic.common.PageModel;
import com.footoss.miracle.dao.BaseDao;
import com.footoss.miracle.dao.impl.UserDao;
import com.footoss.miracle.domain.User;
import com.footoss.miracle.service.BaseService;
import com.footoss.miracle.service.UserService;

public class Test {

	
	public static void main(String[] args) {
				
		Map<String,Object> queryParams = new HashMap<>();
		queryParams.put("name", "zhangsan");
		queryParams.put("currentPage", 3);
		queryParams.put("pageSize", 5);
		
		BaseDao<User> dao = new UserDao();	
		BaseService<User> service = new UserService();
		service.setBaseDao(dao);
		
		PageModel pageModel = service.listByPage(queryParams);
		
//		for(Page page : pageModel.getRows()){
//			System.out.println(page);
//		}
		
		
	}
}
