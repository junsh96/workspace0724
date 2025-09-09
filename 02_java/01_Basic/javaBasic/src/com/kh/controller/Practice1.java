package com.kh.controller;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *	나이를 입력받아
		 *	13세 이하면 어린이
		 *	13세 초과 19세 이하 청소년
		 *	19세 초과 성인 
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력");
		int age=sc.nextInt();
		String str;
		if (age <= 13) {
			str = "어린이";
		} else if (age > 13 && 19 >= age) {
			str = "청소년";
		} else {
			str = "성인";
		}
		System.out.printf("%s는 %d에 속합니다",age,str);
		
		

	}

}
