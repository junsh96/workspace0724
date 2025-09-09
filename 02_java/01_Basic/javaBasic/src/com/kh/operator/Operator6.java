package com.kh.operator;

import java.util.Scanner;

public class Operator6 {

	/*
	 * 상향 연산자
	 * 
	 *  조건식 ? 조건이 참일경우 : 조건이 거짓일경우
	 *  
	 *  이때, 조건식은 반드시 true or false로 반환해야함
	 *  주로 비교 / 논리연산자를 통해 작성.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = (3 < 10) ? 10: 20;
		
		//입력받은 정수값이 양수인지 판별
		
		System.out.println("정수값 입력");
		int num2 = sc.nextInt();
		String result = (num2 > 0) ? "양수"  : "음수";
		System.out.println(result);

	}

}
