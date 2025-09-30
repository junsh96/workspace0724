package com.kh.controller;

import java.util.Scanner;

public class Practice3 {

	/*
	 *	정수를 입력받아 짝수인지 홀수인지 출력하는 프로그램 	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		String str = "";
		if (num < 0) {
			System.out.println("양수가아니다.");
		} else {
			int num2 = num%2;
			
			switch(num2) {
			case 1 :
				str = "홀수";
				break;
			case 0 :
				str = "짝수";
				break;
			
				
			}
			System.out.printf("%d입니다.",str);
		}
		
		
//		if (num%2 ==0 && num < 0) {
//			str = "짝수";
//		} else if (num %2 == 1 &&num < 0) {
//			str = "홀수";
//		}
//		
//		if (str.equals("짝수") || str.equals("홀수")) {
//			System.out.printf("%d입니다.",str);			
//		} else {
//			System.out.println("양수가아니다.");
//		}

	}

}
