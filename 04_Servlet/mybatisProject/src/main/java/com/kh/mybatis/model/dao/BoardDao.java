package com.kh.mybatis.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.vo.PageInfo;
import com.kh.mybatis.model.vo.Attachment;
import com.kh.mybatis.model.vo.Board;
import com.kh.mybatis.model.vo.Category;
import com.kh.mybatis.model.vo.Reply;

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
	 * 게시물 갯수
	 * @param sqlSession
	 * @param searchMap
	 * @return
	 */
	public int selectAllBoardCount(SqlSession sqlSession, HashMap<String, String> searchMap) {
		
		int result = sqlSession.selectOne("BoardMapper.selectSearchBoardCount", searchMap);
		
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
	 * 검새조건 게시물 조회
	 * @param sqlSession
	 * @param pi
	 * @param searchMap
	 * @return
	 */
	public ArrayList<Board> selectAllBoard(SqlSession sqlSession, PageInfo pi, HashMap<String, String> searchMap) {
		
		
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("BoardMapper.selectSearchBoard",searchMap,rowBounds);
		
		
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
		int result = 0;
		if (b.getBoardType() !=1 ) {
			result = sqlSession.insert("BoardMapper.insertThumBoard",b);
		} else {
			result = sqlSession.insert("BoardMapper.insertBoard",b);
		}
		
		
		
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
		
		Attachment result = (Attachment)sqlSession.selectOne("BoardMapper.selectBoardFile",boardNo);
		
		return result;
		
	}
	
	/**
	 * 게시글 수정
	 * @param sqlSession
	 * @param b
	 * @return
	 */
	public int updateBoardDetail(SqlSession sqlSession, Board b) {
		System.out.println("???"+b);
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
		
		Board result = (Board)sqlSession.selectOne("BoardMapper.boardDetail",boardNo);
		
		return result;
	}
	
	/**
	 * 게시글 조회수 증가
	 * @param sqlSession
	 * @param boardNo
	 * @return
	 */
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		int result = sqlSession.update("increaseCount", boardNo);
		
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
	
	/**
	 * 댓글 조회
	 * @param sqlSession
	 * @param boardNo
	 * @return
	 */
	public ArrayList<Reply> selectReplyByBoardNo(SqlSession sqlSession, int boardNo) {
		
		ArrayList<Reply> result = (ArrayList)sqlSession.selectList("selectReplyByBoardNo",boardNo);
		
		return result;
		
	}
	
	/**
	 * 댓글 등록
	 * @param sqlSession
	 * @param r
	 * @return
	 */
	public int inertReply(SqlSession sqlSession, Reply r) {
		int result = sqlSession.insert("insertReply",r);
		
		return result;
	}
	
	/**
	 * 댓글 삭제
	 * @param sqlSession
	 * @param replyNo
	 * @return
	 */
	public int deleteReply(SqlSession sqlSession, int replyNo) {
		int result = sqlSession.delete("deleteReply",replyNo);
		
		return result;
	}
	
	/**
	 * 사진 게시물 조회
	 * @param sqlSession
	 * @return
	 */
	public ArrayList<Board> selectThumnailList(SqlSession sqlSession) {
		
		ArrayList<Board> result = (ArrayList)sqlSession.selectList("selectThumnailList");
		
		return result;
	}
	
	/**
	 * 사진 게시물 첨부 파일 조회
	 * @param sqlSession
	 * @param boardNo
	 * @return
	 */
	public ArrayList<Attachment> selectAttachmentList(SqlSession sqlSession, int boardNo) {
		
		ArrayList<Attachment> result = (ArrayList)sqlSession.selectList("selectAttachmentList",boardNo);
		
		return result;
	}
}
