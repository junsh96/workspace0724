package com.kh.loop;

import java.util.Scanner;

public class Practice4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<=100; i++) {
			if (i % 7 ==0) {
				if (i%2 == 0) {
					continue;
				}
				System.out.print(i+ " ");
			}
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자입력");
		int a =0;
		int sum = 0;
		while(true) {
			a = sc.nextInt();
			if (a<0) {
				
				break;
			}
			sum += a;
		};
		System.out.println("총합 : "+sum);

	}

	
	
}
