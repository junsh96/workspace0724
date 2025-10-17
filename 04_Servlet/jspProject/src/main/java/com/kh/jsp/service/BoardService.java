package com.kh.jsp.service;

import com.kh.jsp.model.dao.AttachmentDao;
import com.kh.jsp.model.dao.BoardDao;
import com.kh.jsp.model.dao.ReplyDao;
import com.kh.jsp.model.vo.Attachment;
import com.kh.jsp.model.vo.Board;
import com.kh.jsp.model.vo.Category;
import com.kh.jsp.model.vo.Reply;

import static com.kh.jsp.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
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
	
	/**
	 * 게시글 페이징용 갯수 조회
	 * @return
	 */
	public int boardCnt() {
		Connection conn = getConnecntion();
		
		int result = new BoardDao().boardCnt(conn);
		
		close(conn);
		
		return result;
		
	}
	
	/**
	 * 게시글 등록폼 카테고리 조회
	 * @return
	 */
	 
	public List<Category> categoryList () {
		Connection conn =  getConnecntion();
		
		List<Category> result = new BoardDao().categoryList(conn);
		
		
		close(conn);
		return result;
	}
	
	/**
	 * 게시글 등록
	 * @param b
	 * @return
	 */
	public int insertBoard(Board b, Attachment at) {
		Connection conn = getConnecntion();
		
		BoardDao bDao = new BoardDao();
		
		int result = bDao.insertBoard(b,conn);
		if (at != null) {
			result *= bDao.insertAttachment(at, conn);
		}
		
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		
	}
	
	/**
	 * 게시글 상세보기
	 * @param boardNo
	 * @return
	 */
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
	
	/**
	 * 게시글 수정
	 * @param b
	 * @return
	 */
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
	
	/**
	 * 게시글 삭제
	 * @param b
	 * @return
	 */
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
	
	/**
	 * 댓글 등록
	 * @param r
	 * @return
	 */
	public int insertReply(Reply r) {
		Connection conn = getConnecntion();
		
		int result = new BoardDao().insertReply(r, conn);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public ArrayList<Reply> selectReplyByBoardNo(int boardNo) {
		Connection conn = getConnecntion();
		
		ArrayList<Reply> list = new BoardDao().selectReplyByBoardNo(conn,boardNo);
		
		close(conn);
		return list;
		
		
	}
	
	public int deleteReply(int replyNo) {
		Connection conn = getConnecntion();
		
		int result = new BoardDao().deleteReply(conn,replyNo);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		
	}
	
	public ArrayList<Board> selectThumnailList() {
		Connection conn = getConnecntion();
		
		ArrayList<Board> result = new BoardDao().selectThumnailList(conn);
		
		close(conn);
		return result;
	}

	
	public int insertThumbBoard(Board b, ArrayList<Attachment> list) {
		Connection conn = getConnecntion();
		
		int result = new BoardDao().insertBoard(b, conn);
		result *= new BoardDao().insertThumbBoard(conn,list);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public ArrayList<Attachment> selectThumbnailFile(int boardNo) {
		Connection conn = getConnecntion();
		
		ArrayList<Attachment> list = new BoardDao().selectThumbnailFile(conn,boardNo);
		
		close(conn);
		
		return list;
		
	}
	
	/**
	 * 게시글 조회시 파일 조회
	 * @param boardNo
	 * @return
	 */
	public Attachment selectBoardFile(int boardNo) {
		Connection conn = getConnecntion();
		
		Attachment a = new BoardDao().selectBoardFile(boardNo,conn);
		
		close(conn);
		
		return a;
		
	}
	
	/**
	 * 파일 삭제
	 * @param a
	 * @return
	 */
	public int deleteFile(Attachment a) {
		Connection conn = getConnecntion();
		
		int result = new BoardDao().deleteFile(a,conn);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
		
	}
	
	
}
