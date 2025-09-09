package com.kh.jdbc.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

//static으로 import시 static메서드를 직접 가져올수있다.
import static com.kh.jdbc.common.JdbcTemplate.*;
import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;

/*
 * service
 * 트랜잭션 관리와 같은 비즈니스 로직을 처리하는 계층,Dao와 컨트롤러의 중간 역활 
 */
public class MemberService {

	private MemberDao md;
	
	
	
	public MemberService() {
		super();
		this.md = new MemberDao();
	}

	public int insertMember(Member m) {
		Connection conn = getConnecntion();
		
		int result = md.insertMember(m,conn);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return 0;
	}
	
	public List<Member> selectMemberList() {
		Connection conn = getConnecntion();
		
		List<Member> result = md.selectMemberLsit(conn);
		
		
		close(conn);
		
		return result;
	}
	
	public int updateMember(Member m) {
		
		Connection conn = getConnecntion();
		
		int result = md.updateMember(m,conn);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return 0;

	}
	
	public int deleteMember(Member m) {
		Connection conn = getConnecntion();
		
		int result = md.deleteMember(m,conn);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return 0;
	}
	
	public List<Member> selectKeyWord(String keyword) {
		
		Connection conn = getConnecntion();
		
		List<Member> result = md.selectKeyWord(keyword,conn);
		
		close(conn);
		
		return result;
		
	}
	
	
	/**
	 * 다중 인원 추가
	 * @param map
	 * @return
	 */
	public int bulkINsertMembers(HashMap<String, Member> map) {
		Connection conn = getConnecntion();
		int result =  0;
		for (Entry<String, Member> eMap : map.entrySet()) {
			
			result = md.bulkINsertMembers(eMap,conn);
			
		}
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
		
		
	}
	
	/**
	 * 다중 인원삭제
	 * @param delUserId
	 * @return
	 */
	public int bulkDeleteMembers(String delUserId) {
		Connection conn = getConnecntion();
		
		String[] delUser = delUserId.split(",");
		int result = 0;
		for (int i=0; i<delUser.length; i++) {
			result = md.bulkDeleteMembers(delUser[i],conn);			
		}
		
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
		
	}
	
}
