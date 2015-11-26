package com.footoss.miracle.service;

import com.footoss.miracle.dao.impl.PageDao;
import com.footoss.miracle.domain.Page;

public class PageService extends BaseService<Page>{

	private PageDao pageDao;

	public PageDao getPageDao() {
		return pageDao;
	}

	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}
	
	
}
