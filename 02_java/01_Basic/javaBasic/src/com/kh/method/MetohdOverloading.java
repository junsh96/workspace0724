package com.kh.method;

public class MetohdOverloading {

	/**
	 * 메서드 오버 로딩
	 * 오버 로딩 : 같은 이름의 메서드를 매개변수의 갯수 타입 순서 가 다르게 여러개 정의.
	 * 			반환형은 오버로딩의 구분 기준이 아니다.
	 * 
	 * 함수의 이름  = 기능의 이름.
	 * 매개 변수 = 함수에서 이용하는 데이터
	 * 반환형 = 결과
	 * 
	 * 오버로딩을 사용하는 목적
	 * 동일한 기능을 다양한 입력형태로 편하게 사용하기 위함.
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
	public static int adder(int n1, int n2) {
		
		return n1+n2;
	}
	
	public static int adder(int n1, int n2, int n3) {
		
		return n1+n2+n3;
	}

	
	//매개변수의 이름이 다르다해서 오버로딩 성립 X
	
	//반환형이 다르다해서 호출 시점의 메소드를 구분 X 오버로드 성립 X
}
