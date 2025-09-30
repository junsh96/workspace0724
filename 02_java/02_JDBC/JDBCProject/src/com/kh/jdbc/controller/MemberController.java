package com.kh.jdbc.controller;

import java.util.List;

import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;
import com.kh.jdbc.view.MemberMenu;

/*
 * Controller : View를 통해서 사용자가 요청한 기능에 대해 처리하는 객체
 * 				해당 메서드로 전달된 데이터를 가공후 dao로 전달하여 기능 수행.
 * 				dao로 부터 전달받은 결과에 따라 성공/실패여부를 판단해 응답화면에 결정.
 */
public class MemberController {

	private MemberDao md = new MemberDao();
	/*
	 * 사용자의 추가요청을 처리하는 메서드
	 * userId ~ hobby : 사용자가 입력한 정보를 매개변수로 받음
	 */
	public void insertMember(String userId, String userPwd, String userNm, String gen, String age, String email,
			String phone, String address, String hobby) {
		
		//view로부터 전달받은 값을 바로 dao에 전달 x
		//vo에 담아서 전달
		Member m = new Member(userId,userPwd,userNm,gen,Integer.parseInt(age),email,phone,address,hobby);
		
		int result = md.insertMember(m);
		
		if (result > 0) {
			new MemberMenu().displaySuccess("회원 추가 성공");
		} else {
			new MemberMenu().displayFail("회원 추가 실패");
			
		}
	}
	
	//회원을 모두 조회후 출력
	public void selectMemberAll() {
		List<Member> list = md.selectMemberLsit();
		
		if (list.isEmpty()) {
			new MemberMenu().displayNoData("화원 목록이 없습니다.");
		} else {
			new MemberMenu().displayList(list, "회원 목록");
		}
		
	}
	
	/**
	 * userId,email,phone,address,hobby를 전달 받아 수정
	 * @param userId
	 * @param email
	 * @param phone
	 * @param address
	 * @param hobby
	 */
	public void updateMember(String userId, String  email, String phone, String address, String hobby) {
		
		Member m = new Member();
		m.setUserId(userId);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		m.setHobby(hobby);
		
		int result = md.updateMember(m);
		
		if (result > 0) {
			new MemberMenu().displaySuccess("회원 수정 성공");
		} else {
			new MemberMenu().displayFail("회원 수정 실패");
		}
		
	}
	
	public void deleteMember(String userId,String userPwd) {
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		int result = md.deleteMember(m);
		
		if (result > 0) {
			new MemberMenu().displaySuccess("회원 삭제 성공");
		} else {
			new MemberMenu().displayFail("회원 삭제 실패");
		}
	}
	
}
