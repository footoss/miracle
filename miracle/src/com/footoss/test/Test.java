package com.footoss.test;

import java.util.HashMap;
import java.util.Map;

import com.footoss.basic.common.PageModel;
import com.footoss.miracle.dao.BaseDao;
import com.footoss.miracle.dao.impl.PageDao;
import com.footoss.miracle.domain.Page;
import com.footoss.miracle.service.BaseService;
import com.footoss.miracle.service.PageService;

public class Test {

	
	public static void main(String[] args) {
				
		Map<String,Object> queryParams = new HashMap<>();
		queryParams.put("name", "zhangsan");
		queryParams.put("currentPage", 3);
		queryParams.put("pageSize", 5);
		
		BaseDao<Page> dao = new PageDao();	
		BaseService<Page> service = new PageService();
		service.setBaseDao(dao);
		
		PageModel pageModel = service.listByPage(queryParams);
		
//		for(Page page : pageModel.getRows()){
//			System.out.println(page);
//		}
		
		
	}
}
