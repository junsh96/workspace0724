package com.kh.operator;

import java.util.Scanner;

public class Practice2 {

	/*
	 *	키보드로 정수 두개를 입력받아 두수의 합 차 곱 나누기 값 출력 
	 	첫번째 정수 : 키보드
	 	두번째 정수 : 키보드
	 	
	 	더하기 : 
	 	빼기 : 
	 	곱하기 : 
	 	나누기 :
	 	나머지 : 
	 */
	public static void main(String[] args) {
		// 
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.printf("더하기 : %d"+ (a+b));
		System.out.printf("빼기 : %d"+ (a-b));
		System.out.printf("나누기 : %d" + (a/b));
		System.out.printf("곱하기 : %d" + (a*b));
		System.out.printf("나머지 : %d" + (a%b));

	}

}
