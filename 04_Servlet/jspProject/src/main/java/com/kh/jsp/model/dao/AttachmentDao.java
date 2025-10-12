package com.kh.jsp.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	
	public Attachment selectBoardFile(int boardNo, Connection conn) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectBoardFile");
		Attachment a = new Attachment();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				a.setFileNo(rset.getInt("FILE_NO"));
				a.setRefBno(rset.getInt("REF_BNO"));
				a.setOriginName(rset.getString("ORIGIN_NAME"));
				a.setChangeName(rset.getString("CHANGE_NAME"));
				a.setFilePath(rset.getString("FILE_PATH"));
				a.setUploadDate(rset.getDate("UPLOAD_DATE"));
				a.setFileLevel(rset.getInt("FILE_LEVEL"));
				a.setStatus(rset.getString("STATUS"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return a;
	}
	
	public int deleteFile(Attachment a , Connection conn) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteFile");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, a.getFileNo());

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
