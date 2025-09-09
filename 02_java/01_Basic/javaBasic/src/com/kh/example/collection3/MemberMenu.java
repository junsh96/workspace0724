package com.kh.example.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MemberMenu {

	MemberController m = new MemberController();
	
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
		int mainNo =0;
		
		while (mainNo < 4) {
			
			System.out.println("====메인메뉴====");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 같은 이름 회원 찾기");
			System.out.println("4. 종료");
			
			mainNo = sc.nextInt();
			
			switch(mainNo) {
			case 1:
				joinMembership();
				break;
			case 2:
				login();
				memberMenu();
				break;
			case 3:
				sameName();
				break;
			case 4:
				System.out.println("프로그램이 종료됩니다.");
				break;
			default : 
				System.out.println("잘못 입력하셨습니다.");
				break;
			
			
			}

			
		}
		
		
	}
	
	public void memberMenu() {
		
		int loginNo = 0;
		
		while(loginNo != 3) {
			
			System.out.println("====회원 메뉴====");
			System.out.println("1. 비밀번호 변경");
			System.out.println("2. 이름 변경");
			System.out.println("3. 로그아웃");
			
			loginNo = sc.nextInt();
			
			switch (loginNo) {
			
			case 1:
				changePassword();
				break;
			case 2:
				changeName();
				break;
			case 3:
				mainMenu();
				break;
			default : 
				System.out.println("잘못 입력하셨습니다.");
				break;
				
			}
			
		}
		
	}
	
	public void joinMembership() {
		System.out.println("아이디 : ");
		String id = sc.next();
		System.out.println("비밀번호 : ");
		String password = sc.next();
		System.out.println("이름 : ");
		String name = sc.next();
		
		Member mb = new Member();
		mb.setName(name);
		mb.setPassword(password);
		
		boolean result = m.joinMembership(id,mb);
		
		if (result) {
			System.out.println("가입되셨습니다.");
		} else {
			System.out.println("중복된 아이디가 존재합니다.");
		}
	}
	
	public void login() {
		System.out.println("아이디 : ");
		String id = sc.next();
		System.out.println("비밀번호 : ");
		String password = sc.next();
		
		String name = m.logIn(id, password);
		
		if (name != null) {
			System.out.println(name+"님 환연합니다.");
		} else {
			System.out.println("틀린 아이디 또는 비밀번호 입니다. 다시 입력해주세요.");
			login();
		}
		
	}
	
	public void changePassword() {
		System.out.println("아이디 : ");
		String id = sc.next();
		System.out.println("비밀번호 : ");
		String oldPW = sc.next();
		System.out.println("새로운 비밀번호 : ");
		String newPW = sc.next();
		
		boolean result = m.changePassword(id, oldPW, newPW);
		
		if(result) {
			System.out.println("비밀번호가 변경되었습니다.");
		} else {
			System.out.println("비밀번호 변경에 실패하였습니다. 다시 입력해주세요.");
			changePassword();
		}
		
	}
	
	public void changeName() {
		System.out.println("아이디 : ");
		String id = sc.next();
		System.out.println("비밀번호 : ");
		String password = sc.next();
		System.out.println("새로운 이름 : ");
		String newNm = sc.next();
		
		if (m.map.get(id).getPassword().equals(password)) {
			
			m.changeName(id, newNm);
			
			System.out.println("이름이 변경되었습니다.");
			
		}
		
		
	}
	
	public void sameName() {
		System.out.println("검색할 이름 : ");
		String name = sc.next();
		
		TreeMap<String, String> result = m.sameName(name);
		
		for (Map.Entry<String, String> rMap :result.entrySet()) {
			System.out.printf("이름 : %s 아이디 : %s \n",rMap.getValue(),rMap.getKey());
		}
		
	}
	
}
