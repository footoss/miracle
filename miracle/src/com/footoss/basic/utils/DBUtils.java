package com.footoss.basic.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtils {
	
	private static Logger logger = Logger.getLogger(DBUtils.class.getName());

	private static String DBDRIVER = "com.mysql.jdbc.Driver"; 
	private static String DBURL	   = "jdbc:mysql://localhost:3306/pagination";
	private static String DBUSER   = "root";
	private static String DBPASSWD = "123456";	
	
	private DBUtils(){}
	
	public static Connection getConn(){
	
		try {
			Class.forName(DBDRIVER);
			Connection conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWD);
			return conn;
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE, "未找到数据库驱动类: " + DBDRIVER, e);
			System.out.println();
			System.out.println();
			System.out.println();
			e.printStackTrace();
			System.exit(-1);
		}catch (SQLException e) {
			logger.log(Level.SEVERE, "获取数据库连接失败 " , e);
		}
		return null;
	}
	
	public static void close(Connection conn,PreparedStatement pstmt, ResultSet rs){
		try {
			if(null != conn) 
				conn.close();
		} catch (SQLException e) {
			logger.log(Level.WARNING, "关闭Connection失败", e);
		}finally {
			try {
				if (null != pstmt)
					pstmt.close();
			} catch (SQLException e) {
				logger.log(Level.WARNING, "关闭PreparedStatement失败", e);
			}finally{
				try {
					if (null != rs)
						rs.close();
				}catch(SQLException e){
					logger.log(Level.WARNING, "关闭ResultSet失败", e);
				}
			}
		}
	}
}
