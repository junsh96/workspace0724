package com.kh.basic;

import java.util.Scanner;

public class Input {

	/*
	 * 입력 : 외부에서의 데이터를 코드 내부로 가져오는것
	 * 
	 * Scanner를 사용하면 키보드에 입력값을 가져올수 있음.
	 * (java.util.Scanner 클래스 사용)
	 * 
	 * [사용법]
	 * Scanner 이름 = new Scanner(System.in);
	 */
	public static void main(String[] args) {
		// 
		Scanner sc = new Scanner(System.in);
		//.next()
		//문자열 입력받는 함수(공백 전까지)
		//입력받은 값을 특정 변수에 바로 대입
		String str1, str2;
		System.out.println("입력 : ");
		str1 = sc.next();
		str2 = sc.next();
		
		System.out.println("str1 : "+ str1);
		System.out.println("str2 : "+ str2);
		
		//.nextLine()
		//문자열을 입력받는 함수(공백을 포함한 한줄, 개행 문자 까지)
		
		String str3, str4;
		System.out.println("입력 : ");
		str3 = sc.nextLine();
		str4 = sc.nextLine();
		
		System.out.println("str3 : "+ str3);
		System.out.println("str4 : "+ str4);
		
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("주소 : ");
		String address = sc.nextLine();
		System.out.println("나이 : ");
		String age = sc.nextLine();
		
		System.out.printf("제 이름은 %s이며 %s에 살고있고 %s세 입니다",name,address,age);
		
		//nextInt -- 숫자를 입력받고자 할때
		//sc.nextLine을 한번 더 사용하면 버퍼에 남아있는 nextInt를 입력할때 발생한 개행값을 비워준다.
		
		//문자 이외의 원시타입을 입력받을 때
		//.next타입()
		//ex) nextInt / nextDouble / nextBoolean
		
		sc.close(); // Scanner 자원을 다 쓰고 반납 * 한번 반납하면 재 사용 불가
	}

}
