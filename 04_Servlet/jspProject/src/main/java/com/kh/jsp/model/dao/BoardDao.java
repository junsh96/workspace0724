package com.kh.jsp.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.jsp.common.JdbcTemplate;
import com.kh.jsp.model.vo.Attachment;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Category;
import com.kh.jsp.model.vo.Reply;

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
	
	/**
	 * 게시글 페이징용 갯수 조회
	 * @param conn
	 * @return
	 */
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
	
	/**
	 * 게시글 등록폼 카테고리 조회
	 * @param conn
	 * @return
	 */
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
	
	/**
	 * 게시글 등록
	 * @param b
	 * @param conn
	 * @return
	 */
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
	
	public int insertAttachment(Attachment at, Connection conn) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	/**
	 * 게시글 상세보기
	 * @param boardNo
	 * @param conn
	 * @return
	 */
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

	/**
	 * 게시글 조회수 증가
	 * @param boardNo
	 * @param conn
	 * @return
	 */
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

	/**
	 * 게시글 수정
	 * @param b
	 * @param conn
	 * @return
	 */
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
	
	/**
	 * 게시글 삭제
	 * @param b
	 * @param conn
	 * @return
	 */
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
	
	/**
	 * 댓글 조회
	 * @param conn
	 * @param boardNo
	 * @return
	 */
	public ArrayList<Reply> selectReplyByBoardNo(Connection conn, int boardNo) {
		ArrayList<Reply> result = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectReplyByBoardNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Reply r = new Reply();
				r.setReplyNo(rset.getInt("REPLY_NO"));
				r.setReplyContent(rset.getString("REPLY_CONTENT"));
				r.setMemberId(rset.getString("MEMBER_ID"));
				r.setCreateDate(rset.getDate("CREATE_DATE"));
				
				
				result.add(r);
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
	
	public int deleteReply(Connection conn, int replyNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyNo);
			
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
