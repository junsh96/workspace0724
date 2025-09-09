package com.kh.array;

import java.util.Scanner;

public class Practice5 {

	//1번부터 N번까지 번호가 순서대로 적힌 바구니가 있습니다. M개의 뒤집기 작업이 주어지며,
	//각각은 i번부터 j번 바구니의 순서를 역순으로 바꾸는 작업입니다. 모든 작업 후 최종 바구니의 번호 배열을 출력하세요.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("바구니 번호 입력");
		int basketNum = sc.nextInt();
		System.out.println("뒤집기 입력");
		int under = sc.nextInt();
		
		System.out.println("시작번호");
		int i = sc.nextInt();
		System.out.println("종료번호");
		int j = sc.nextInt();
		int o = j;
		int [] basket2 = new int[basketNum];
		
		int [] basket = new int[basketNum];
		for (int k = 0; k < basket.length; k++) {
			basket[k] = k+1;
		}
		
		for (int k = 0; k < basket.length; k++) {
			
			if (k >= i-1 && k <=j-1) {
				basket2[k] = basket[o-1];
				o--;
			} else {
				basket2[k] = basket[k];
			}
			
		}
		System.out.println("테스트 :");
		
		for (int k =0; k < basket2.length; k++) {
			System.out.print(basket2[k] + " / ");
		}
		
		// m?????????? 문제가 이해가 안됨 3,5번
		//-> 바구니 순서 바꾸기 작업을 m번 반복한다는 의미. 
	}
}
