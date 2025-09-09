package com.kh.array;

import java.util.Scanner;

public class Practice3 {

	//N개의 바구니(1~N번)가 있고, M개의 공 넣기 작업이 주어집니다. 
	//각 작업은 i번 바구니부터 j번 바구니까지 숫자 k가 적힌 공을 넣는 것을 의미합니다. 
	//그 후 각 바구니에 어떤 공이 들어 있는지 출력하세요. 공이 없는 경우 0으로 출력합니다. 
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("바구니 갯수");
		int n = sc.nextInt();
		int [] basket = new int[n]; 
		System.out.println("공 갯수");
		int m = sc.nextInt();
		
		System.out.println("공을 넣을 바구니 번호");
		int i = sc.nextInt();
		int j = sc.nextInt();
		
		for (int l = 0; l < n; l++) {
			if (l >= i && l <= j) {
				System.out.println("공 번호");
				basket[l] = sc.nextInt();
			}
		}
		
		for (int o = 0; o < basket.length; o++) {
			System.out.print(basket[o] + " ");
		}

	}

}
