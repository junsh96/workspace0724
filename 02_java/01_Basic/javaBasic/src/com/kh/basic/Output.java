package com.kh.basic;

public class Output {

	public static void main(String[] args) {
		// 코드를 사용하는 영역
		
		//출력문
		//print() ->일반적인 출력문으로 () 내부 값을 화면에 출력함
		System.out.print("안녕하세요");
		System.out.print("안녕하세요\n");
		//println() -> 개행 문자를 포함한 출력문
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		//문자열 포멧을 이용한 출력문.
		//System.out.printf(문자열 포멧,값1,값2,값3.....);
		String name = "전수환";
		int age = 30;
		System.out.println("저는"+name+"이고 나이는"+age+"입니다.");
		System.out.printf("저는 %s이고 나이는 %d입니다",name,age);
		
		/*
		 * 	포멧 안에서 쓸 수 있는 키워드
		 * %d : 정수
		 * %c : 한글자
		 * %s : 문자열
		 * %f : 실수
		 *  
		 * */
	}

}
