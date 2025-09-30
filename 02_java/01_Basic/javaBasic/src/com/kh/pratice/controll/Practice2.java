package com.kh.pratice.controll;

import java.util.Scanner;

public class Practice2 {

	/*
	 *	1부터 6까지 눈이 있는 세 개의 주사위를 던졌을 때, 아래 규칙에 따라 상금을 계산하는 프로그램을 작성하세요. 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("#입력 :");
		int score1 = sc.nextInt();
		int score2 = sc.nextInt();
		int score3 = sc.nextInt();
		int money = 0;
		
		//3개 모두 같은 경우 10000 + 점수*1000
		if (score1 == score2 && score2 == score3) {
			money = 10000 + (score1*1000);
		} else {
			//2개가 같은경우 1000 + 같은주사위수 * 100
			//1번주사위와 같은 주사위가 한개있는경우
			if (score1 == score2 || score1 == score3 ) {
				money = 1000 + (score1 *100);
			//2번주사위와 3번주사위가 같은경우
			} else if (score2 == score3) {
				money = 1000 + (score2*100);
			//한개도 같은 주사위가 없는 경우 나온 주사위 최대값 * 100
			} else {
				//1번이 최대값인경우
				if (score1 > score2 && score1 > score3) {
					money = score1 * 100;
				//2번이 최대값인경우
				} else if (score2 > score1 && score2 > score3) {
					money = score2 * 100;
				//3번이 최대값인경우
				} else {
					money = score3 * 100;
				}
			}
		}
		
		System.out.println("#출력 : ");
		System.out.println(money);
		
		// int Math.max(n1,n2) -> 둘중 큰값을 반환
		//ex) int max = Math.max(n1,n2);
		//   max = Math.max(max,n3);
		sc.close();
	}

}
