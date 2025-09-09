package com.kh.loop;

import java.util.Scanner;

public class Break {

	/*
	 * break 반복문,switch문 안에서 사용되는 분기문
	 * break가 실행되는 순간 가장 가까운 반복문, switch를 강제로 탈출한다.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//랜덤값을 발생시켜 출력
		//단 랜덤값이 3의 배수 일경우 반복문 중지
//		while(true) {
//			int num = (int)(Math.random() * 100) +1;
//			System.out.println(num);
//			if (num % 3 == 0) {
//				break;
//			}
//		}
		
		//로또 번호 추첨 1~45까지 중 랜덤하게
		for (int i=0; ;i++) {
			int num = (int)(Math.random() * 45) +1;
			System.out.print(num + " ");
			if (i>=5) {
				break;
			}
		}
		
		//사용자에게 문자열을 입력받아 해당 문자열의 길이를 출력하는 프로그램
		//단 사용자가 exit를 입력할때 까지 해당 행위 반복
		
		String str;
		while(true) {
			System.out.print("문자열 입력");
			str = sc.next();
			
			if (str.equals("exit")) {
				break;
			}
			System.out.println("길이:" +str.length());
		}

	}

}
