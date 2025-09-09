package com.kh.operator;

import java.util.Scanner;

public class Pratice1 {

	/*
	 * 키보드로 가로, 세로값을 실수형으로 입력받아 사각형의 면적과 둘레를 계산하여 출력
	 * 면적 : 가로 * 세로
	 * 둘레 : (가로 + 세로) * 2
	 * 
	 *  [출력]
	 *  가로 : (키보드로 입력)
	 *  세로 : (키보드로 입력)
	 *  
	 *  면적 : ~
	 *  둘레 : ~
	 *  소수점 두자리까지
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		float a = sc.nextInt();
		float b = sc.nextInt();
		
		float c = a*b;
		float d = (a+b) *2;
		
		System.out.printf("가로 : %.1f" +a);
		System.out.printf("세로 : %.1f" +b);
		System.out.printf("면적 : %.1f " +c);
		System.out.printf("둘레 : %.1f" +d);

	}

}
