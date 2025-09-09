package com.kh.example.api;

import java.util.Scanner;

public class TokenMenu {

	Scanner sc = new Scanner(System.in);
	
	TokenController tc = new TokenController();
	
	public void mainMenu() {
		
		System.out.println("====메인 메뉴====");
		System.out.println("1. 지정 문자열");
		System.out.println("2. 입력 문자열");
		System.out.println("3. 프로그램 종료");
		int mainNo = sc.nextInt();
		
		if (mainNo == 1) {
			tokenMenu();
			mainMenu();
		} else if (mainNo == 2) {
			inputMenu();
			mainMenu();
		} else if (mainNo == 3) {
			System.out.println("프로그램이 종료되었습니다.");
		} else {
			System.out.println("잘못입력하셨습니다.");
			mainMenu();
		}
		
	}
	
	
	public void tokenMenu() {
		String str = "J a v a P r o g r a m ";
		System.out.println("토큰 처리전 문자갯수 : "+str.length());
		System.out.println(str);
		
		String str2 = tc.afterToken(str);
		System.out.println("토큰 처리후 문자갯수 : "+str2.length());
		System.out.println("토큰 처리후 문자 : " +str2);
		System.out.println("대문자로 변환 : "+str2.toUpperCase());
	}
	
	public void inputMenu() {
		System.out.println("문자열을 입력하세요 : ");
		String str = sc.next();
		
		String str2 = tc.firstCap(str);
		System.out.println("첫글자 대문자 : " + str2);
		
		System.out.println("찾을 문자를 입력하세요 : ");
		char one = sc.next().charAt(0);
		
		int cnt = tc.findChar(str, one);
		System.out.println("문자가 들어간 갯수 : " + cnt);
	}
	
}
