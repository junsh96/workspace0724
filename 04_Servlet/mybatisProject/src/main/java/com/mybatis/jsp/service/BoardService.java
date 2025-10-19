package com.mybatis.jsp.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.Template;
import com.kh.mybatis.common.vo.PageInfo;
import com.kh.mybatis.model.dao.BoardDao;
import com.kh.mybatis.model.vo.Attachment;
import com.kh.mybatis.model.vo.Board;
import com.kh.mybatis.model.vo.Category;
import com.kh.mybatis.model.vo.Reply;

public class BoardService {
	private BoardDao boardDao = new BoardDao();
	
	/**
	 * 게시물 갯수
	 * @return
	 */
	public int selectAllBoardCount() {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.selectAllBoardCount(sqlSession);
		
		sqlSession.close();
		
		return result;
	}
	
	/**
	 * 게시글 조회
	 * @param pi
	 * @return
	 */
	public ArrayList<Board> selectAllBoard(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Board> list = boardDao.selectAllBoard(sqlSession, pi);
		
		sqlSession.close();
		
		return list;
		
	}
	
	/**
	 * 게시글 카테고리 조회
	 * @return
	 */
	public ArrayList<Category> categoryList() {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Category> list = boardDao.categoryList(sqlSession);
		
		sqlSession.close();
		
		return list;
	}
	
	/**
	 * 게시글 등록
	 * @param b
	 * @param at
	 * @return
	 */
	public int insertBoard(Board b, Attachment at) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.insertBoard(sqlSession, b);
		
		if (at != null) {
			result *= boardDao.insertAttachment(sqlSession, at);
		}
		
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}
	
	/**
	 * 첨부 파일 조회
	 * @param boardNo
	 * @return
	 */
	public Attachment selectBoardFile(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();

		Attachment result = boardDao.selectBoardFile(sqlSession, boardNo);
		
		sqlSession.close();
		
		return result;
		
	}
	
	/**
	 * 게시글 수정
	 * @param b
	 * @param at
	 * @return
	 */
	public int updateBoardDetail(Board b, Attachment at) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.updateBoardDetail(sqlSession, b);
		
		if(at != null) {
			if(at.getFileNo() != 0) { //기존첨부파일이 존재할 때
				result *= boardDao.updateAttachment(sqlSession, at);
			} else { //기존첨부파일이 존재하지 않을 때
				result *= boardDao.insertNewAttachment(sqlSession, at);
			}
		}
		
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}
	
	/**
	 * 게시글 상세 조회
	 * @param boardNo
	 * @return
	 */
	public Board boardDetail(int boardNo) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		Board b =  boardDao.boardDetail(sqlSession, boardNo);
		
		sqlSession.close();
		
		return b;
	}
	
	/**
	 * 게시글 조회수 증가
	 * @param boardNo
	 * @return
	 */
	public int increaseCount(int boardNo) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.increaseCount(sqlSession, boardNo);
		
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
		
	}
	
	/**
	 * 게시글 삭제
	 * @param boardNo
	 * @return
	 */
	public int deleteBoard(int boardNo) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.deleteBoard(sqlSession, boardNo);
		
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
		
	}
	/**
	 * 파일 삭제
	 * @param fileNo
	 * @return
	 */
	public int deleteFile(int fileNo) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.deleteFile(sqlSession, fileNo);
		
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
		
	}
	/**
	 * 댓글 조회
	 * @param boardNo
	 * @return
	 */
	public ArrayList<Reply> selectReplyByBoardNo(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Reply> result = boardDao.selectReplyByBoardNo(sqlSession, boardNo);
		
		sqlSession.close();
		
		return result;
	}
	/**
	 * 댓글 등록
	 * @param r
	 * @return
	 */
	public int insertReply(Reply r) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.inertReply(sqlSession, r);
		
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
		
	}
	/**
	 * 댓글 삭제
	 * @param replyNo
	 * @return
	 */
	public int deleteReply(int replyNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.deleteReply(sqlSession, replyNo);
		
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}
	
	/**
	 * 사진 게시물 조회
	 * @return
	 */
	public ArrayList<Board> selectThumnailList() {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Board> result = boardDao.selectThumnailList(sqlSession);
		
		sqlSession.close();
		
		return result;
	}
	
	/**
	 * 사진 게시물 등록
	 * @param b
	 * @param list
	 * @return
	 */
	public int insertBoard(Board b, ArrayList<Attachment> list) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = boardDao.insertBoard(sqlSession, b);
		if (list.size() > 0) {
			for (Attachment at : list) {
				result *= boardDao.insertAttachment(sqlSession, at);
			}			
		}
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}
	
	/**
	 * 사진 게시물 첨부 파일 조회
	 * @param boardNo
	 * @return
	 */
	public ArrayList<Attachment> selectAttachmentList(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Attachment> result = boardDao.selectAttachmentList(sqlSession, boardNo);
		
		sqlSession.close();
		
		return result;
	}
}
