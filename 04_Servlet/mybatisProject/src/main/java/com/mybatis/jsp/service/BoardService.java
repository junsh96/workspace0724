package com.mybatis.jsp.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.Template;
import com.kh.mybatis.common.vo.PageInfo;
import com.kh.mybatis.model.dao.BoardDao;
import com.kh.mybatis.model.vo.Board;

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
	
}
