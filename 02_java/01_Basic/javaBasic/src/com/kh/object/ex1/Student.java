package com.kh.object.ex1;

public class Student {

	
	/**
	 * 클래스의 구조
	 * 
	 * 접근 제한자 class 클래스명 {
	 * 		//필드 영역
	 * 			: 사용할 데이터를 선언
	 * 		//생성자 영역
	 * 			: 데이터를 초기화 하기 위한 특수 목적의 메소드를 정의
	 * 		//메서드 영역
	 * 			: 클래스의 기능을 정의
	 * }
	 * @param args
	 */
	String name;
	int age;
	double height;
	
	
	void myInfo() {
		System.out.printf("안녕하세요 저는 %d살의 %s입니다.",age,name);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
