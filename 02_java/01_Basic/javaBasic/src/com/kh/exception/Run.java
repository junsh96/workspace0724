package com.kh.exception;

public class Run {

	/**
	 * 에러의 종류
	 * 시스템 에러 : 하드웨어/os장애 -> 코드로 해결 x
	 * 컴파일 에러 : 문법 오류 -> 컴파일러가 발견하면 개발자가 수정.
	 * 런타임 에러(= 예외 Exception) : 실행중 발생하기 때문에 개발자가 바로 처리해서 대응.
	 * 논리 에러 : 실행은 되지만 의도와 다른 결과 = 발견이 어려움. 
	 * 
	 * 예외 처리를 하는 이유
	 * 
	 * 프로그램의 비정상적인 종료를 방지하고 복구가 가능한 흐름을 만들어 사용자의 경험을 보호하기 위해
	 * 
	 * 예외 처리방법
	 * 1. try - catch
	 * 2. throws 
	 * 
	 * 사용한 리소스를 반납 방법 2가지
	 * 1. finally
	 * 2. try-with-resource문법 사용
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunException re = new RunException();
		re.method1();
		
		
	}

}
