package com.kh.controller;

import java.util.Scanner;

public class Practice2 {

	/*
	 *	성별을(m/f)(대소문자 상관x)로 입력받아 남학생인지 여학생인지 출력 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//toUpperCase() : 모든 문자열 대문자
		//toLowerCase() : 모든 문자열 소문자
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String str2;
		if (str.equals("m")||str.equals("M")) {
			str2 ="남학생";
		} else if (str.equals("f") || str.equals("F")) {
			str2 = "여학생";
		}
		
		if (str.equals("m") || str.equals("M") || str.equals("f") || str.equals("F")) {
			System.out.printf("%d입니다.",str);			
		} else {
			System.out.println("잘못입력하셨습니다.");
		}
	}

}
