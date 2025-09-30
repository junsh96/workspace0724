package com.kh.loop;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		
		for (int i=0; i<10; i++) {
			System.out.println("숫자 입력");
			int a = sc.nextInt();
			if (a % 2 == 1) {
				continue;
			}
			System.out.println("짝수의 제곱은"+a*a+"입니다.");
		}

	}

}
