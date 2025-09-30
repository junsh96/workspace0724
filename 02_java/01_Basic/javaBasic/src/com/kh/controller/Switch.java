package com.kh.controller;

import java.util.Scanner;

public class Switch {

	/*
	 *	switch문도 조건문
	 *
	 * 	다만 switch문은 값이 정확하게 일치하는 경우에만 사용
	 * 
	 * switch(비교대상 (정수 문자 문자열)) {
	 * 	case 값1 : 실행코드
	 * 	case 값2 : 실행코드
	 *  .
	 *  . 
	 *  .
	 * 	default : 기본값.
	 * }
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 정수를 입력받아
		 * 1 = 빨강
		 * 2 = 파랑
		 * 3 = 초록
		 * other 잘못입력했습니다. 
		 */

		Scanner sc = new Scanner(System.in);
		
		int num;
		//System.out.println("정수입력 : ");
		//num = sc.nextInt();
		
//		switch(num) {
//		case 1 : 
//			System.out.println("빨간색입니다.");
//		case 2 : 
//			System.out.println("파랑색입니다.");
//		case 3 : 
//			System.out.println("초록색입니다.");
//		default : 
//			System.out.println("잘못입력했습니다.");
//		}
//		break -> switch문 내에서 사용하면 해당 코드가 실행되고 가장 가까운 switc문이 종료
		
		
//		switch(num) {
//		case 1 : 
//			System.out.println("빨간색입니다.");
//			break;
//		case 2 : 
//			System.out.println("파랑색입니다.");
//			break;
//		case 3 : 
//			System.out.println("초록색입니다.");
//			break;
//		default : 
//			System.out.println("잘못입력했습니다.");
//		}
		
		/*
		 * 과일을 구매하는 프로그램을 작성
		 * 구매하고자 하는 과일을 입력하면
		 * 그에 맞는 가격이 출력되는 프로그램
		 * 
		 *  [출력]
		 *  구매하고자 하는 과일(사과(2000),바나나(3000),딸기(5000)
		 *  xxx의 가격은 xxx입니다. /잘못입력하셧습니다.
		 */
//		System.out.println("과일입력 : ");
//		String str1 = sc.nextLine();
//		int price = 0;
//		switch(str1) {
//		case "사과" :
//			price = 2000;
//			System.out.println(str1+"의 가격은 "+price+"원입니다.");
//			break;
//		case "바나나" :
//			price = 3000;
//			System.out.println(str1+"의 가격은 "+price+"원입니다.");
//			break;
//		case "딸기" :
//			price = 5000;
//			System.out.println(str1+"의 가격은 "+price+"원입니다.");
//			break;
//		default :
//			System.out.println("잘못입력하셧습니다.");
//		}
		
		/*
		 * 월을 입력받아서 해당월의 마지막 일이 며칠인지를 출력하는 프로그램
		 * 
		 *  [출력]
		 *  월을 입력하세요 : xx
		 *  xx월은 xx일까지 있습니다.
		 *  
		 *  
		 */
		System.out.println("월입력 : ");
		int mon = sc.nextInt();
		int day = 0;
		switch(mon) {
		case 1 :
		case 3 :
		case 5 : 
		case 7 :
		case 8 : 
		case 10 :
		case 12 :
			day = 31;
			break;
		case 2 :
			day = 28;
			break;
		case 4 :
		case 6 : 
		case 9 :
		case 11 : 
			day = 30;
			break;
		
		}
		if (day == 0 ) {
			System.out.println("잘못입력하셧습니다.");			
		} else {
			System.out.println(mon+"월은"+day+"일까지 있습니다.");
		}
		
	}

}
