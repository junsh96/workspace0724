package com.kh.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//공통 템플릿(매번 반복적으로 작성된 코드를 메서드로 정의)
public class JdbcTemplate {

	//모든 메서드를 전부 static메서드로 생성
	
	//1.Connection객체 생성후 해당 connecntion 반환
	public static Connection getConnecntion() {
		Connection conn = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("resources/driver,properties"));
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
			
			conn.setAutoCommit(false);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return conn;
	}
	
	//2. connection 객체를 전달받아 상태를 확인 후 commit하는 메서드
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	//3. connection 객체를 전달받아 상태를 확인 후 rollback하는 메서드
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	//4 Statement 관련 객체 전달받아 반납시키는 메서드
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//5 Connection 관련 객체 전달받아 반납시키는 메서드
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//6 ResultSet 관련 객체 전달받아 반납시키는 메서드
		public static void close(ResultSet rset) {
			try {
				if(rset != null && !rset.isClosed()) {
					rset.close();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	
}
