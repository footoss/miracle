package com.footoss.miracle.dao.impl;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.footoss.basic.common.PageModel;
import com.footoss.miracle.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	
	
	@Override
	public int getCount(Map<String, Object> queryParams) {
		return 0;
	}

	@Override
	public List<T> getQueryData(PageModel<T> pageModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T orm(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
