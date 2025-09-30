package com.kh.pratice.controll;

import java.util.Scanner;

public class Practice1 {

	/*
	 * 0점부터 100점 사이의 정수를 입력받아 아래 조건에 따라 **등급(학점)**을 출력하는 프로그램을 작성하세요.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		int score = sc.nextInt();
		String grade  ="F";
		if (score >=90) {
			grade = "A";
		} else if (score < 90 && score >= 80) {
			grade = "B";
		} else if (score < 80 && score >= 70) {
			grade = "C"; 
		} else if(score < 70 && score >= 60) {
			grade = "D";
		} else {
			grade ="F";
		}
		System.out.printf("당신의 성적은 %s입니다",grade);
		sc.close();
		
	}

}

