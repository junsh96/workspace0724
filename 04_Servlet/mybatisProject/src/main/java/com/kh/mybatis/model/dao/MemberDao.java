package com.kh.mybatis.model.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.vo.Member;

public class MemberDao {
	
	/**
	 * 유저 로그인
	 * @param sqlsession
	 * @param userId
	 * @param userPwd
	 * @return
	 */
	public Member loginMember(SqlSession sqlSession, String userId, String userPwd) {
		HashMap<String, String> map = new HashMap<>();
		map.put("memberId", userId);
		map.put("memberPwd", userPwd);
		
		Member loginMember = sqlSession.selectOne("MemberMapper.loginMember",map);
		
		return loginMember;
	}
	
	/**
	 * 아이디 중복 체크
	 * @param sqlSession
	 * @param checkId
	 * @return
	 */
	public int idCheck(SqlSession sqlSession, String checkId) {
		
		int result = sqlSession.selectOne("MemberMapper.idCheck",checkId);
		
		return result;
	}
	
	/**
	 * 회원가입
	 * @param sqlSession
	 * @param m
	 * @return
	 */
	public int insertMember(SqlSession sqlSession, Member m) {
		
		int result = sqlSession.insert("MemberMapper.insertMember",m);
		
		return result;
		
	}
	
	/**
	 * 회원 정보 수정
	 * @param sqlSession
	 * @param m
	 * @return
	 */
	public int updateMember(SqlSession sqlSession, Member m) {
		
		int result = sqlSession.update("MemberMapper.updateMember",m);
		
		return result;
		
	}
	
	/**
	 * 
	 * @param sqlSession
	 * @param memberId
	 * @return
	 */
	public Member selectMemberByUserId(SqlSession sqlSession, String memberId) {
		
		Member updateMemberId = sqlSession.selectOne("MemberMapper.selectMemberId",memberId);
		
		return updateMemberId;
	}
	
}
