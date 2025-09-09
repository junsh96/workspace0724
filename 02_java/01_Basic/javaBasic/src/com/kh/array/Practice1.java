package com.kh.array;

import java.util.Scanner;

public class Practice1 {

	//정수 N개로 이루어진 수열 A와 정수 X가 주어집니다.
	//이때, 수열 A에서 X보다 작은 수를 모두 입력된 순서대로 공백 한 칸으로 구분하여 출력하는 프로그램을 작성하세요. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("사이즈 입력");
		int size = sc.nextInt();

		System.out.println("비교할 정수 입력");
		int x = sc.nextInt();
		
		int [] A = new int[size];
		
		for (int i=0; i<size;i++) {
			A[i] = sc.nextInt();
		}
		
		for (int i=0; i<size;i++) {
			if (A[i] < x) {
				System.out.print(A[i]+" ");
			}
		}

		
	}

}
