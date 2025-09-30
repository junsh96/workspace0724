package com.kh.api;

public class Run {

	/**
	 * API(Application Programming Interface)
	 * : 프로그램을 만들때 사용할 수 있도록 제공되는 미리 만들어진 기능의 모음.
	 * -> 미리 작성된 인터페이스(명령어, 클래스 메서드 등등)
	 * 
	 * 자바 api = 자바 표준 라이브러리
	 * -> 자바 언어는 기본 문법(변수 제어문, 클래스)만 제공을 함.
	 * -> 실제 개발에서는 문자열 처리, 날짜 계산, 입출력, 네트워크 통신,자료구조 사용	등 수 많은 기능이 필요
	 * -> 이런 기능을 자바 개발팀에서 미리 구현해둔 클래스/인터페이스 집합을 java 표준 api.
	 * 
	 * java.lang.String, java.io.File.....
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MathAPI ma = new MathAPI();
//		
//		ma.method();
		StringAPI sa = new StringAPI();
		
		sa.metohd01();
	}

}
