package com.kh.method;

public class MethodBasic {

	/*
	 *	메서드란
	 * - class 내부에 정의된 함수를 메서드라 칭함
	 * - 특정 기능을 수행하는 코드블록을 정의하고, 필요할때 호출하여 재사용.
	 * - 중복 코드 제거와 가독성 유지보수성이 향상됨.
	 * 
	 *  [기본 구조]
	 *  
	 *  [접근 제한자] [static] 반환명 메서드 명 (매개 변수) {
	 *  	//함수에서 실행할 코드
	 *  	[리턴값]; // void일경우 생략 / return;으로 생략
	 *  }
	 */
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		hiEveryone(15);
		hiEveryone(20);
		
		System.out.println("프로그램 종료");
	}
	
	public static void hiEveryone(int age) {
		System.out.println("좋은 아침입니다.");
		System.out.println("제 나이는 "+age+"입니다.");
	}

}
