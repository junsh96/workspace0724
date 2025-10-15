package com.kh.jsp.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.kh.jsp.common.JdbcTemplate;
import com.kh.jsp.model.vo.Attachment;
import com.kh.jsp.model.vo.Reply;

import static com.kh.jsp.common.JdbcTemplate.*;

public class ReplyDao {
	private Properties prop = new Properties();
	
	public ReplyDao() {
		super();
		String path = JdbcTemplate.class.getResource("/db/sql/reply-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(path));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 댓글 등록
	 * @param r
	 * @param conn
	 * @return
	 */
	public int insertReply(Reply r, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("insertReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getReplyContent());
			pstmt.setInt(2, r.getRefBno());
			pstmt.setInt(3, r.getReplyWriter());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	
}
