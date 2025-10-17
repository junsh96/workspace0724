package com.kh.mybatis.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.vo.PageInfo;
import com.kh.mybatis.model.vo.Attachment;
import com.kh.mybatis.model.vo.Board;
import com.kh.mybatis.model.vo.Category;

public class BoardDao {

	/**
	 * 게시물 갯수
	 * @param sqlSession
	 * @return
	 */
	public int selectAllBoardCount(SqlSession sqlSession) {
		
		int result = sqlSession.selectOne("BoardMapper.selectAllBoardCount");
		
		return result;
	}
	
	/**
	 * 게시글 조회
	 * @param sqlSession
	 * @param pi
	 * @return
	 */
	public ArrayList<Board> selectAllBoard(SqlSession sqlSession, PageInfo pi) {
		
		//mybatis에서 자체적으로 페이징 처리를 통해 RowBounds 라는 class를 제공
		//offset : 몇개의 게시글을 건너 띄우고 조회할 것인가
		//boardLimit : 몇개의 게시글을 가져올것인가.
		
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("BoardMapper.selectAllBoard",null,rowBounds);
		
		
		return list;
	}
	
	/**
	 * 게시글 카테고리 조회
	 * @param sqlSession
	 * @return
	 */
	public ArrayList<Category> categoryList(SqlSession sqlSession) {
		
		ArrayList<Category> list = (ArrayList)sqlSession.selectList("BoardMapper.categoryList");
		
		return list;
		
	}
	
	/**
	 * 게시글 등록
	 * @param sqlSession
	 * @param b
	 * @return
	 */
	public int insertBoard(SqlSession sqlSession, Board b) {
		
		int result = sqlSession.insert("BoardMapper.insertBoard",b);
		
		return result;
		
	}
	
	/**
	 * 게시글 첨부 파일 등록
	 * @param sqlSession
	 * @param at
	 * @return
	 */
	public int insertAttachment(SqlSession sqlSession, Attachment at) {
		
		int result = sqlSession.insert("BoardMapper.insertAttachment",at);
		
		return result;
		
	}
	
	/**
	 * 첨부 파일 조회
	 * @param sqlSession
	 * @param boardNo
	 * @return
	 */
	public Attachment selectBoardFile(SqlSession sqlSession, int boardNo) {
		
		Attachment result = (Attachment)sqlSession.selectList("BoardMapper.selectBoardFile",boardNo);
		
		return result;
		
	}
	
	/**
	 * 게시글 수정
	 * @param sqlSession
	 * @param b
	 * @return
	 */
	public int updateBoardDetail(SqlSession sqlSession, Board b) {
		int result = sqlSession.update("BoardMapper.updateBoardDetail",b);
		
		return result;
	}
	
	/**
	 * 게시글 상세 조회
	 * @param sqlSession
	 * @param boardNo
	 * @return
	 */
	public Board boardDetail(SqlSession sqlSession, int boardNo) {
		
		Board result = (Board)sqlSession.selectList("BoardMapper.boardDetail",boardNo);
		
		return result;
	}
	
	/**
	 * 첨부 파일 변경
	 * @param sqlSession
	 * @param at
	 * @return
	 */
	public int updateAttachment(SqlSession sqlSession, Attachment at) {
		
		int result = sqlSession.update("BoardMapper.updateAttachment",at);
		
		return result;
	}
	
	/**
	 * 신규 천부 파일 등록
	 * @param sqlSession
	 * @param at
	 * @return
	 */
	public int insertNewAttachment(SqlSession sqlSession, Attachment at) {
		
		int result = sqlSession.update("BoardMapper.insertNewAttachment",at);
		
		return result;
	}
	
	/**
	 * 게시글 삭제
	 * @param sqlSession
	 * @param boardNo
	 * @return
	 */
	public int deleteBoard(SqlSession sqlSession, int boardNo) {
		
		int result = sqlSession.update("BoardMapper.deleteBoard",boardNo);
		
		return result;
	}
	/**
	 * 파일 삭제
	 * @param sqlSession
	 * @param fileNo
	 * @return
	 */
	public int deleteFile(SqlSession sqlSession, int fileNo) {
		int result = sqlSession.update("BoardMapper.deleteFile",fileNo);
		
		return result;
	}
	
}
