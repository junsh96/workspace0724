package com.kh.jsp.service;

import com.kh.jsp.model.dao.BoardDao;
import com.kh.jsp.model.vo.Attachment;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Category;

import static com.kh.jsp.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;


public class BoardService {

	/**
	 * 게시판 리스트 
	 * 추후 페이징
	 * @return
	 */
	public List<Board> boardList(int pageNo) {
		Connection conn =  getConnecntion();
		
		List<Board> result = new BoardDao().boardList(pageNo,conn);
		
		
		close(conn);
		return result;
	}
	
	public int boardCnt() {
		Connection conn = getConnecntion();
		
		int result = new BoardDao().boardCnt(conn);
		
		close(conn);
		
		return result;
		
	}
	
	public List<Category> categoryList () {
		Connection conn =  getConnecntion();
		
		List<Category> result = new BoardDao().categoryList(conn);
		
		
		close(conn);
		return result;
	}
	
	public int insertBoard(Board b) {
		Connection conn = getConnecntion();
		
		int result = new BoardDao().insertBoard(b,conn);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		
	}
	
	public Board boardDetail(int boardNo) {
		Connection conn = getConnecntion();
		
		Board b =  new BoardDao().boardDetail(boardNo,conn);
		
		if (b != null) {
			//조회수 증가
			int result = new BoardDao().boardCount(boardNo,conn);
			if (result > 0 ) {
				commit(conn);
			} else {
				rollback(conn);
			}
		}
		
		close(conn);
		return b;
		
	}
	
	
	public Board updateBoardDetail(Board b) {
		Connection conn =  getConnecntion();
		
		int result = new BoardDao().updateBoardDetail(b, conn);
		Board updateBoard = null;
		if (result > 0 ) {
			commit(conn);
			//변경된 board 재 조회
			updateBoard = new BoardDao().boardDetail(b.getBoardNo(), conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return updateBoard;
	}
	
	
	public int deleteBoard(Board b) {
		Connection conn = getConnecntion();
		
		int result = new BoardDao().deleteBoard(b, conn);
		
		if (result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
}
