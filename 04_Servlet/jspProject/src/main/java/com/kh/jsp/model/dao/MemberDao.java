package com.kh.jsp.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.jsp.common.JdbcTemplate;
import static com.kh.jsp.common.JdbcTemplate.*;
import com.kh.jsp.model.vo.Member;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	
	
	public MemberDao() {
		super();
		String path = JdbcTemplate.class.getResource("/db/sql/member-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(path));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertMember(Member m, Connection conn) {
		//insert -> 처리된 행 수 -> 반환
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());
			pstmt.setString(7, m.getInterest());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	public Member loginMember(String userId, String userPwd, Connection conn) {
		int result = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Member m = null;
		String sql = prop.getProperty("userLogin");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				m = new Member(
					rset.getInt("MEMBER_NO"),
					rset.getString("MEMBER_ID"),
					rset.getString("MEMBER_PWD"),
					rset.getString("MEMBER_NAME"),
					rset.getString("PHONE"),
					rset.getString("EMAIL"),
					rset.getString("ADDRESS"),
					rset.getString("INTEREST"),
					rset.getDate("ENROLL_DATE"),
					rset.getDate("MODIFY_DATE"),
					rset.getString("STATUS")
				);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		return m;
	}
	
	
	public int updateMember(Member m, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPhone());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getInterest());
			pstmt.setString(5, m.getMemberId());
			pstmt.setString(6, m.getMemberName());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	
	public Member selectMemberByUserId(String userId, Connection conn) {
		int result = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Member m = null;
		String sql = prop.getProperty("selectMemberId");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				m = new Member(
					rset.getInt("MEMBER_NO"),
					rset.getString("MEMBER_ID"),
					rset.getString("MEMBER_PWD"),
					rset.getString("MEMBER_NAME"),
					rset.getString("PHONE"),
					rset.getString("EMAIL"),
					rset.getString("ADDRESS"),
					rset.getString("INTEREST"),
					rset.getDate("ENROLL_DATE"),
					rset.getDate("MODIFY_DATE"),
					rset.getString("STATUS")
				);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		return m;
	}
	
	public int updatePwd(String currentPwd,String newPwd, String userId, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePwd");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, currentPwd);

			
			result = pstmt.executeUpdate();
			

			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}
	
	public int deleteMember(String userId, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
			
		}
		return result;
		
	}
	
	public int idCheck(Connection conn , String checkId) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idCheck");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				count = rset.getInt("COUNT");
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		return count;
	}
	
}
