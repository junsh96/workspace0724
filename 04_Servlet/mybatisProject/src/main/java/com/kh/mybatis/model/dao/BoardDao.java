package com.kh.mybatis.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.vo.PageInfo;
import com.kh.mybatis.model.vo.Board;

public class BoardDao {

	/**
	 * 게시물 갯수
	 * @param sqlSession
	 * @return
	 */
	public int selectAllBoardCount(SqlSession sqlSession) {
		
		int result =sqlSession.selectOne("BoardMapper.selectAllBoardCount");
		
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
	
}
