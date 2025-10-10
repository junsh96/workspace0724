package com.kh.jsp.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.kh.jsp.common.JdbcTemplate;
import com.kh.jsp.model.vo.Attachment;

import static com.kh.jsp.common.JdbcTemplate.*;

public class AttachmentDao {
	private Properties prop = new Properties();
	
	public AttachmentDao() {
		super();
		String path = JdbcTemplate.class.getResource("/db/sql/attachment-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(path));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int uploadFile(Attachment a, Connection conn) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("uploadFile");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getOriginName());
			pstmt.setString(2, a.getChangeName());
			pstmt.setString(3, a.getFilePath());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
}
