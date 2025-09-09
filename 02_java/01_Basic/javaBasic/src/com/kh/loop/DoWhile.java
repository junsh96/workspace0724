package com.kh.loop;

import java.util.Scanner;

public class DoWhile {

	/*
	 *	 do - while문
	 *
	 *  처음에 무조건 실행코드가 실행되고 조건문 검사
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = 0;
		do {
			System.out.println("서비스 번호를 입력해주세요");
			System.out.println("1추가");
			System.out.println("2삭제");
			System.out.println("3종료");
			
			System.out.println("입력");
			
			num  = sc.nextInt();
			
			switch(num) {
			case 1 : 
				System.out.println("추가되었습니다.");
				break;
			case 2 : 
				System.out.println("삭제되었습니다.");
				break;
			case 3 :
				System.out.println("종료되었습니다.");
				break;
				
			default :
				System.out.println("error.");
			}
			
			
		} while(num !=3);
		
		//사용자가 입력한 수를 계속 더하는 프로그램 작성
		//단 사용자가 0을 입력하면 종료
		int a = 0;;
		int sum = 0;
		
		do {
			a = sc.nextInt();
			sum += a;
			
		} while(a == 0);
		System.out.println(sum);
	}

}
