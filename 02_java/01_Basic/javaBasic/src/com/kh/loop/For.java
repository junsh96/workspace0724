package com.kh.loop;

import java.util.Scanner;

public class For {

	/*
	 * 반복문
	 * 반복문은 특정 코드를 여러번 반복해서 실행하고자 할때 실행하는 제어몬.
	 * 
	 *  대표적으로 for, while ,d0-while
	 *  
	 *  for문
	 *  반복횟수가 명확할때 가장 많이 사용.
	 *  for(초기식; 조건식; 증감식) {
	 *   반복 실행할 코드
	 *   }
	 *   초기식 : 반복을 시작하기 전 변수를 선언하고 초기값 설정, 처음 딱 한번만 실행.
	 *   조건식 : 반복을 계속 진행할지 여부를 판단하는 조건, 조건이 true면 진행
	 *   		매번 반복문의 코드를 실행하기 전에 확인하며 보통 초기식에 제시된 변수를 활용.
	 *   증감식 : 매번 반복문이 끝난후 변수값을 증가/감소시키는 부분
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int  i =0; i< 5; i++) {
			System.out.println("안녕하세요".charAt(i));
		}
		//1~5 순차적으로 출력
		
		for (int i=1; i<6; i++) {
			System.out.print(i+"\t");
		}
		
		/*
		 * 자바의 지역변수
		 *  - 특정 메서드나 블록 내부에서 선언 가능하고 내부에서만 접근 가능.
		 *  - 해당 블록이 종료되면 블록내부의 변수도 함께 사라진다. 
		 */
		
		//정수 n을 입력받아 1부터 n까지 1씩 증가시키면서 출력
		Scanner sc = new Scanner(System.in);
		//System.out.println("정수 입력");
		//int j= sc.nextInt();
//		for(int i=1; i<j+1; i++) {
//			System.out.print(i+ " ");
//		}
		
		/*
		 *	커피 주문 키오스크
		 *
		 * 	아메리카노를 몇잔 구매하시겠습니까?(1100원) : 
		 *  결제하실 금액은 xxxx원입니다.
		 */
		System.out.println("아메리카노를 몇잔 구매하시겠습니까?(1100원) : ");
		int coffe = sc.nextInt();
		int pay = 0;
		for(int i=0; i<coffe; i++) {
			pay += 1100;
		}
		System.out.println("결제하실 금액은"+pay+"원 입니다.");
		
		//1. 아메리카노 1000 / 카페라떼 1500 를 선택(종료는 0)
		//위의 주문대로 주문을 받고 종료를 입력하면 
		//아메리카노 x잔
		//카레파떼 x잔
		//결제하실 금액 : xxxx
		
		
		//1~10숫자중 홀수만 출력
		for (int i=1; i<11; i++) {
			if (i%2 == 1) {
				System.out.println(i+" ");
			}
		}
		
		//1~100까지의 수중 짝수의 합
		//1~100까지의 짝수 합 : 
		int sum = 0;
		for (int i=1; i<101; i++) {
			if (i%2==0) {
				sum+=i;
			}
		}
		System.out.println("1~100까지의 짝수합 : " +sum);
		
		
		/*
		 * Math.random()
		 * java.lang.Math 클래스에 기본적으로 제공하는 함수로 호출하면 매번 다른 랜덤값을 호출
		 * ->	1미만의 소수값을 호출 
		 * (int)Math.random() - > 0
		 * (int)(Math.random()*10)+1 - >1~10;
		 * (int)(Math.random() *(최대값 +1 - 최소값)) + 최소값; - > 최소값~최대값 
		 */
		
		//random(1~10)중 한 숫자를 생성해서 1부터 n까지의 합을 구하라
		int n = (int)(Math.random()*10 +1);
		int sum2 = 0;
		for (int i=1; i<=n; i++) {
			sum2 += i;
		}
		System.out.println("총합 : "+sum2);
		
		//각 인덱스별 문자 출력 : str.charAt(i);	
		
		String str = sc.next();
		System.out.println("문자열 길이"+str.length());
		
		for (int i=0; i<str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		
		//문자열을 입력받아 해당 문자열의 짝수열만 출력
		System.out.println("문자열 :");
		String str1 = sc.next();
		
		for (int i=0; i<str1.length(); i++) {
			if (i%2==0) {
				System.out.println("짝수열 : "+str1.charAt(i));
			}
		}
		
		//이중 for문 구구단
		for (int i=2; i<10; i++) {
			for (int j=1; j<10; j++) {
				System.out.println(i+"단 : "+i*j);
			}
		}
	}
	
	

}
