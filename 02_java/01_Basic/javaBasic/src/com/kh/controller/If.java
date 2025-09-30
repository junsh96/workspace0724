package com.kh.controller;

import java.util.Scanner;

public class If {

	/*
	 * 기본적으로 프로그램의 진행은 순차적으로 이루어진다.
	 * 
	 *  특정 코드를 선택적으로 실행시키고 싶을때 - > 조건문
	 *  특정 코드를 반복적으로 실행시키고 싶을때 -> 반복문
	 *  
	 *   조건문
	 * 	 조건식을 통해 true 또는 false 를 판단하고 true일 경우 그에 해당하는 코드를 실행	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		/*
		 * if 문을 단독으로 사용하는 경우
		 * if (조건식) {
		 * 		실행할 구문
		 *  }
		 *  
		 *  조건 식이 true면 {} 안의 구문 실행
		 *          false 면 {}안의 구문 무시.
		 */

		System.out.print("정수입력");
		int num = sc.nextInt();
		
		
//		 if (num > 0) { 
//			 System.out.println("양수입니다."); 
//		 }
		 
		
		/*
		 *	else 를 함께 사용하는 경우
		 *	if () {
		 *		실행할 코드
		 *	} else {
		 *		실행할 코드
		 *	}
		 *
		 *	 조건식이 ture ->  if의 실행 코드 실행
		 *   		false => else의 실행코드 실행
		 */

//		if (num > 0) { 
//			System.out.println("양수입니다."); 
//		} else {
//			if (num == 0) {
//				System.out.println("0입니다."); 
//			} else {
//				System.out.println("음수입니다."); 
//			}
//		}
		
		//조건을 나열할 경우 if _ else if _ else가능
		
		/*
		 * 	if() {
		 * 
		 *  } else if (){
		 *  
		 *  } else {
		 *  
		 *  }
		 *  
		 *  각 if 문에 들어있는 다른 조건을 확인하며 블록 안의 코드를 실행할수 있고 모든 조건이 연동되어있음.	
		 */
		 
		if (num > 0) { 
			System.out.println("양수입니다."); 
		} else if(num == 0){
			System.out.println("0입니다."); 			
		} else {
			System.out.println("음수입니다."); 
		}
		
		
	}

}
