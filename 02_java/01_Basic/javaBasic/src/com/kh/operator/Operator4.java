package com.kh.operator;

public class Operator4 {

	/*
	 * 비교 연산자 / 관계 연산자
	 * 
	 * - 두값을 비교하여 조건을 판단하는 연산자
	 * - 비교결과는 항상 boolean 타입
	 * 
	 * 종류
	 *  - 대소 비교 : < > <= >=
	 *  - 동등 비교 : == !=
	 *  
	 *  원시 타입 비교
	 *  - 정수 실수 문자등 기본 변수는 != == 으로 비교가능
	 *  
	 *  참조형 비고(String)
	 *  - String같은 객체는 참조형이므로 ==로 비교시 에러발생.
	 *  (참조형은 일반적으로 연산자를 이용해 비교하면 갑자체가 아닌 주소값을 비교)
	 *  - String 문자열1.equals(문자열2) 로 비교.
	 *  (해당 변수가 가진 실제 값을 비교)
	 *  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 25;
		
		System.out.println("a == b : " + (a ==b));
		System.out.println("a <= b : " + (a <=b));
		
		System.out.println ((a *2) > (b / 5));
		
		String str1 = "hello";
		String str2 = "hello"; //자바에서 문자열 리터럴은 String Pool이라는 메모리 영역에 저장됨
		//만약에 위처럼 동일한 문자열 리터럴이 다시 참조가 되면 기존에 있던 문자열 객체의 주소를 재사용.
		//즉 한번만 리터럴 메모리에 값을 올려 메모리를 효율적으로 사용.

		String str3 = new String("hello");
		System.out.println("str1 == str3" + (str1 == str3) );
		
		System.out.println("str1 == str3" + (str1.equals(str3)) );
		System.out.println("hello == str3" + ("hello".equals(str3)) );
		
		System.out.println('A' > 70);
		
		
	}

}
