package com.kh.jdbc.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.controller.MemberController;
import com.kh.jdbc.model.vo.Member;

//Vieq : 사용자와의 상호작용을 하는 객체 -> 입력 및 출력
public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public MemberMenu() {
		super();
		this.sc = new Scanner(System.in);
		this.mc = new MemberController();
	}
	
	/*
	 * 사용자가 보게될 첫 화면(메인화면)
	 */
	
	public void mainMenu() {
		System.out.println("====회원 관리 프로그램=====");
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 전체 조회");
		System.out.println("3. 회원 정보 변경");
		System.out.println("4. 회원 탈퇴");
		System.out.println("9. 프로그램 종료");
		
		System.out.println("메뉴 번호 : ");
		int mainNo = sc.nextInt();
		sc.nextLine();
		
		switch(mainNo) {
		case 1:
			
			insertMember();
			break;
			
		case 2:
			mc.selectMemberAll();
			break;
		case 3:
			updateMember();
			break;
		case 4:
			deleteMember();
			break;
		case 9:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			
		
		
		}
		
	}
	
	public void deleteMember() {
		System.out.println("====회원 정보 삭제====");
		System.out.println("유저 아이디 입력");
		String userId = sc.nextLine();
		
		System.out.println("비밀번호 확인");
		String userPwd = sc.nextLine();
		
		mc.deleteMember(userId,userPwd);
		
	}
	
	public void updateMember() {
		System.out.println("====회원 정보 변경====");
		//어떤 회원의 정보를 수정할것인지 -> user_id
		//변경할 정보를 입력. 이메일. 전화번호, 주소 , 취미
		System.out.println("유저아이디를 입력");
		String userId = sc.nextLine();
		
		System.out.println("변경할 이메일: ");
		String email = sc.nextLine();
		
		System.out.println("변경할 전화번호: ");
		String phone = sc.nextLine();
		
		System.out.println("변경할 주소: ");
		String address = sc.nextLine();

		System.out.println("변경할 취미(,로 구분): ");
		String hobby = sc.nextLine();
		
		mc.updateMember(userId, email, phone, address, hobby);
		
		
		
	}
	
	public void insertMember() {
		System.out.println("====회원 추가====");
		
		System.out.println("아이디: ");
		String userId = sc.next();
		
		System.out.println("비밀번호: ");
		String userPwd = sc.next();
		
		System.out.println("이름: ");
		String userNm = sc.next();
		
		System.out.println("성별 M/F: ");
		String gender = sc.next();
		
		System.out.println("나이 : ");
		String age = sc.next();
		sc.nextLine();
		
		System.out.println("이메일: ");
		String email = sc.next();
		
		System.out.println("전화번호: ");
		String phone = sc.next();
		
		System.out.println("주소: ");
		String address = sc.next();

		System.out.println("취미(,로 구분): ");
		String hobby = sc.next();

		mc.insertMember(userId, userPwd, userNm, gender, age, email, phone, address, hobby);
		//Member m = new Member(userId,userPwd,userNm,gender,age,email,phone,address,hobby);
	}
	
	//서비스 요청 처리후 성공했을때 사용자가 보게 될 화면
	public void displaySuccess(String msg) {
		
		System.out.println("\n 서비스 요청 성공 :" + msg);
		
	}
	//서비스 요청 처리후 실패했을때 사용자가 보게 될 화면
	public void displayFail(String msg) {
		
		System.out.println("\n 서비스 요청 실패 :" + msg);
		
	}
	
	public void displayNoData(String msg) {
		
		System.out.println("\n 서비스 요청 실패 :" + msg);
		
	}
	
	public void displayList(List<Member> list, String msg) {
		
		System.out.println(msg);
		
		for(Object o : list) {
			System.out.println(o);
		}
		
	}
}
