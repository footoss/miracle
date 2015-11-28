package com.footoss.miracle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.footoss.basic.common.PageModel;
import com.footoss.basic.utils.DBUtils;
import com.footoss.basic.utils.StringHelper;
import com.footoss.miracle.dao.BaseDao;
import com.footoss.miracle.domain.User;

public class UserDao extends BaseDaoImpl<User> implements BaseDao<User>{

	private static Logger logger = Logger.getLogger(UserDao.class.getName());
	
	
	
	@Override
	public int getCount(Map<String, Object> queryParams) {
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(*) AS ct FROM USER WHERE 1=1 ");
		if(!StringHelper.isBlank(queryParams.get("id"))){
			sb.append(" AND ID = '").append(queryParams.get("id")).append("'");
		}else{
			if(!StringHelper.isBlank(queryParams.get("age"))){
				sb.append(" AND AGE = '").append(queryParams.get("age")).append("'");
			}
			if(!StringHelper.isBlank(queryParams.get("name"))){
				sb.append(" AND NAME LIKE '%").append(queryParams.get("name")).append("%'");
			}
		} 
		
		String sql = sb.toString();
		logger.info(sql);
		
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		try {
			conn 	= DBUtils.getConn();
			pstmt 	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();

			String ct = null;
			if(rs.next())
				ct = StringHelper.trim(rs.getString("ct"));

			if (!StringHelper.isBlank(ct))
				return Integer.parseInt(ct);
		} catch (SQLException e) {
			logger.log(Level.WARNING,"数据库异常",e);
		}finally {
			DBUtils.close(conn, pstmt, rs);
		}
		
		return 0;
	}

	@Override
	public List<User> getQueryData(PageModel<User> pageModel) {
		Map<String , Object> queryParams = pageModel.getQueryParams();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM USER WHERE 1=1 ");
		if(!StringHelper.isBlank(queryParams.get("id"))){
			sb.append(" AND ID = ").append(queryParams.get("id")).append("");
		}else{
			if(!StringHelper.isBlank(queryParams.get("age"))){
				sb.append(" AND AGE = '").append(queryParams.get("age")).append("'");
			}
			if(!StringHelper.isBlank(queryParams.get("name"))){
				sb.append(" AND NAME LIKE '%").append(queryParams.get("name")).append("%'");
			}
		} 
		
		
		sb.append(" LIMIT ").append(pageModel.getStartRecord()).append(" , ").append(pageModel.getPageSize());
		
		String sql = sb.toString();
		logger.info(sql);
		
		List<User> userList = null;
		
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		
		try {
			conn 	= DBUtils.getConn();
			pstmt 	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			
			userList = new ArrayList<>();
			while (rs.next()) {
				User page = orm(rs);
				userList.add(page);
			}

		} catch (SQLException e) {
			logger.log(Level.WARNING, "查询异常", e);
		}finally {
			DBUtils.close(conn, pstmt, rs);
		}
		return userList;
	}
	
	@Override
	public User orm(ResultSet rs) {
		User user = null;
		
		try {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String age = rs.getString("age");

			user = new User(id, name, age);
		} catch (SQLException e) {
			logger.log(Level.WARNING, "从结果集中取数据异常", e);
		}
		
		return user;
	}
}
