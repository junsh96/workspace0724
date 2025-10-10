package com.kh.jsp.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.jsp.common.JdbcTemplate;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Category;

import static com.kh.jsp.common.JdbcTemplate.*;

public class BoardDao {
	private Properties prop = new Properties();
	
	public BoardDao() {
		super();
		String path = JdbcTemplate.class.getResource("/db/sql/board-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(path));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 게시판 리스트
	 * 추후 페이징
	 * @param conn
	 * @return
	 */
	public List<Board> boardList(int pageNo,Connection conn) {
		
		List<Board> result = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectBoardList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, pageNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setBoardType(rset.getInt("BOARD_TYPE"));
				b.setBoardTypeName(rset.getNString("BOARD_TYPE_NAME"));
				b.setCategoryNo(rset.getInt("CATEGORY_NO"));
				b.setCategoryName(rset.getString("CATEGORY_NAME"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardContent(rset.getString("BOARD_CONTENT"));
				b.setBoardWriter(rset.getInt("BOARD_WRITER"));
				b.setMemberName(rset.getString("MEMBER_NAME"));
				b.setCount(rset.getInt("COUNT"));
				b.setCreateDate(rset.getDate("CREATE_DATE"));
				b.setStatus(rset.getString("STATUS"));
				
				result.add(b);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return result;
	}
	
	public int boardCnt(Connection conn) {
		int result = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectBoardCnt");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			rset = pstmt.executeQuery();
			rset.next();
			
			result = rset.getInt("CNT");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		return result;
	}
	
	
	public List<Category> categoryList(Connection conn) {
		
		List<Category> result = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectCategoryList");
		
		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();
			while(rset.next()) {
				Category c = new Category();
				c.setCategoryName(rset.getNString("CATEGORY_NAME"));
				c.setCategoryNo(rset.getInt("CATEGORY_NO"));
				
				result.add(c);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
			close(rset);
		}

		
		
		
		return result;
	}
	
	public int insertBoard(Board b, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBoard");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getBoardType());
			pstmt.setInt(2, b.getCategoryNo());
			pstmt.setString(3, b.getBoardTitle());
			pstmt.setString(4, b.getBoardContent());
			pstmt.setInt(5, b.getBoardWriter());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}
	
	public Board boardDetail(int boardNo, Connection conn) {
		
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectBoardDetail");
		Board b = new Board();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setBoardType(rset.getInt("BOARD_TYPE"));
				b.setBoardTypeName(rset.getString("BOARD_TYPE_NAME"));
				b.setCategoryNo(rset.getInt("CATEGORY_NO"));
				b.setCategoryName(rset.getString("CATEGORY_NAME"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardContent(rset.getString("BOARD_CONTENT"));
				b.setBoardWriter(rset.getInt("BOARD_WRITER"));
				b.setMemberName(rset.getString("MEMBER_NAME"));
				b.setCount(rset.getInt("COUNT"));
				b.setCreateDate(rset.getDate("CREATE_DATE"));
				b.setStatus(rset.getString("STATUS"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
			close(rset);
		}
	
		return b;
	}
	
	public int boardCount(int boardNo, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateBoardCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	
	public int updateBoardDetail(Board b, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateBoardDetail");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getCategoryNo());
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setInt(4, b.getBoardNo());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
		}
		
		return result;
		
		
	}
	
	public int deleteBoard(Board b, Connection conn) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteBoard");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getBoardNo());
			
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
