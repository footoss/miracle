package com.footoss.miracle.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.footoss.basic.common.PageModel;

public interface BaseDao<T> {

	int getCount(Map<String,Object> queryParams);
	List<T> getQueryData(PageModel<T> pageModel);
	T orm(ResultSet rs);
}
