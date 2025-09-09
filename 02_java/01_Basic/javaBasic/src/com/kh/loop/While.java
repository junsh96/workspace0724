package com.kh.loop;

import java.util.Scanner;

public class While {

	/*
	 * while 문
	 * 
	 *  while(조건식) {
	 *  	반복할 코드
	 *  	[탈출이 가능한 구조]
	 *  }
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i=0; 
		
		while(i <10) {
			System.out.println("안녕하세요");
			i++;
		}
		
		for (int n = sc.nextInt(); n !=0; n=sc.nextInt()) {
			System.out.println(n);
		}
		//1~랜덤값 합
		int random = (int)(Math.random()  *100) +1;
		int sum = 0;
		for (int k=1; k <= random; k++) {
			sum += k;
		}
		
		//사용자가 0을 입력할때까지 랜덤값을 하나씩 생성후 총합
		int choice = sc.nextInt();
		int sum2 = 0;
		while(choice != 0) {
			int random2 = (int)(Math.random()  *100) +1;
			sum2 += random2;
			choice = sc.nextInt();
		}
		
		
	}
}
