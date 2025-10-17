package com.mybatis.jsp.service;


import static com.kh.mybatis.common.Template.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.Template;
import com.kh.mybatis.model.dao.MemberDao;
import com.kh.mybatis.model.vo.Member;



public class MemberService {
	private MemberDao memberDao = new MemberDao();

	/**
	 * 로그인
	 * @param userId
	 * @param userPwd
	 * @return
	 */
	public Member loginMember(String userId, String userPwd) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Member result = memberDao.loginMember(sqlSession, userId, userPwd);

		sqlSession.close();
		
		return result;
	}
	
	/**
	 * 아이디 중복체크
	 * @param checkId
	 * @return
	 */
	public int idCheck(String checkId) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = memberDao.idCheck(sqlSession,checkId);
		
		sqlSession.close();
		
		return result;
	}
	
	/**
	 * 회원가입
	 * @param m
	 * @return
	 */
	public int insertMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = memberDao.insertMember(sqlSession,m);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
		
	}
	
	/**
	 * 회원정보 수정
	 * @param m
	 * @return
	 */
	public Member updateMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = memberDao.updateMember(sqlSession,m);
		
		Member updateMember = null; 
		if(result > 0) {
			updateMember = memberDao.selectMemberByUserId(sqlSession, m.getMemberId());
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return updateMember;
	}
	
	/**
	 * 비밀번호 수정
	 * @param currentPwd
	 * @param newPwd
	 * @param userId
	 * @return
	 */
	public Member updatePwd(String currentPwd, String newPwd, String userId) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = memberDao.updatePwd(sqlSession,currentPwd, newPwd, userId);
		
		Member updateMember = null; 
		if(result > 0) {
			updateMember = memberDao.selectMemberByUserId(sqlSession, userId);
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return updateMember;
		
	}
	
	public int deleteMember(String userId) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = memberDao.deleteMember(sqlSession,userId);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
}
