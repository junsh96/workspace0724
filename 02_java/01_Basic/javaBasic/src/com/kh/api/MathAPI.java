package com.kh.api;

public class MathAPI {

	//java.lang.MAth
	///모든 필드가 상수 필드. 모든 메서드가 sstatic.
	public void method() {
		//상수 필드 pi
		System.out.println("PI : "+ Math.PI);
		//랜덤값
		System.out.println("랜덤 : " + Math.random());
		// 절대값
		System.out.println("절대값 : " + Math.abs(-10.5));
		//올림
		System.out.println("올림 : "+ Math.ceil(10.5));
		//반올림
		System.out.println("반올림 : " + Math.round(10.4));
		//버림
		System.out.println("버림 : "+ Math.floor(10.7));
		//제곱
		System.out.println("제곱 : "+ Math.pow(2, 10));
	
	}
	
}
