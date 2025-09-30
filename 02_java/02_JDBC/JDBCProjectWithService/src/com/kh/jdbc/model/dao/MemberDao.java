package com.kh.jdbc.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.StringTokenizer;

import com.kh.jdbc.common.JdbcTemplate;
import com.kh.jdbc.model.vo.Member;

public class MemberDao {
	private Properties prop = new Properties();
	
	
	
	public MemberDao() {
		super();
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertMember(Member m,Connection conn) {
		//insertMember -> insert -> 처리된 행의 수
		int result = 0;
		PreparedStatement pstmt = null;
		
		//sql문
		String sql = prop.getProperty("insertMember");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserNm());
			pstmt.setString(4, m.getGen());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("????");
		}finally {
			
			JdbcTemplate.close(pstmt);
			
		}
		
		return result;
	}
	
	public ArrayList<Member> selectMemberLsit(Connection conn) {
		
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<>();

		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectMemberLsit");
		try {
			
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserNm(rset.getString("USER_NAME"));
				m.setGen(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getTimestamp("ENROLL_DATE").toLocalDateTime());
				
				list.add(m);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(rset);
		}
		
		
		return list;
	}
	
	//Member 객체 m을 통해서 update sql을 전달
	public int updateMember(Member m,Connection conn) {

		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateMember");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getHobby());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			JdbcTemplate.close(pstmt);
				
		}
		
		return result;
	}
	
	public int deleteMember(Member m,Connection conn) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			

			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			JdbcTemplate.close(pstmt);			
		}
		
		return result;
	}
	
	public List<Member> selectKeyWord(String keyword,Connection conn) {
		List<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectKeyWord");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserNm(rset.getString("USER_NAME"));
				m.setGen(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getTimestamp("ENROLL_DATE").toLocalDateTime());
				
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(rset);
		}
		
		return list;
	}
	
	
	/**
	 * 다중 인원 추가
	 * @param map
	 * @param conn
	 * @return
	 */
	public int bulkINsertMembers(Entry<String, Member> map, Connection conn) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		Member m = map.getValue();
		try {
				
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserNm());
			pstmt.setString(4, m.getGen());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			result = pstmt.executeUpdate();
				
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			JdbcTemplate.close(pstmt);
			
		}
		
		return result;
	}
	
	/**
	 * 다중 인원 삭제
	 * @param delUserId
	 * @param conn
	 * @return
	 */
	public int bulkDeleteMembers(String delUserId, Connection conn) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMultiMember");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, delUserId);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}
	
}
