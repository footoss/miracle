package com.footoss.miracle.service;

import java.util.Map;

import com.footoss.basic.common.PageModel;
import com.footoss.basic.constant.Constants;
import com.footoss.basic.utils.StringHelper;
import com.footoss.miracle.dao.BaseDao;

public abstract class BaseService<T> {

	private BaseDao<T> baseDao;
	
	public PageModel<T> listByPage(Map<String,Object> queryParams){
		

		int totalRecords = baseDao.getCount(queryParams);
		int pageSize,currentPage;
//		String sort, order;
		
		if(StringHelper.isBlank(queryParams.get("pageSize")))	pageSize = Constants.PAGE_SIZE;
		else 	pageSize = Integer.parseInt(StringHelper.trim(queryParams.get("pageSize")));
		
		if(StringHelper.isBlank(queryParams.get("currentPage")))	currentPage = 1; 
		else	currentPage = Integer.parseInt(StringHelper.trim(queryParams.get("currentPage")));
		
//		if(StringHelper.isBlank(queryParams.get("sort") == null)) 	sort = "ID";
//		else	sort = queryParams.get("sort").toString();
//			
//		if(StringHelper.isBlank(queryParams.get("order") == null)) 	order = "DESC";
//		else	order = queryParams.get("order").toString();
		
		PageModel<T> pageModel = new PageModel<T>(currentPage, totalRecords, pageSize, queryParams);
		pageModel.setRows(baseDao.getQueryData(pageModel));
		return pageModel;
	}
	
	public void listByPage(PageModel<T> pageModel){
		
		Map<String , Object> queryParams = pageModel.getQueryParams();

		int totalRecords = baseDao.getCount(queryParams);
		pageModel.setTotalRecords(totalRecords);
		pageModel.init();
		pageModel.initExpand();
		pageModel.setRows(baseDao.getQueryData(pageModel));
	}

	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	
	
}
