package com.kh.inherit;

import java.util.Scanner;

public class Run {

	/**
	 * 상속이란
	 * 부모 클래스의 필드와 메서드를 자식클래스가 물려받아 재사용하는것.
	 * -> 객체 생성시 부모 부분 -> 자식 부분 순으로 메모리에 구성되며 자식객체 내부에 부모객체가 존재하는 것 처럼 실행.
	 * 
	 * 장점
	 * 재사용성/생산성 : 코드를 재사용하여 새로운 클래스를 정의할수있음.
	 * 유지보수성 : 공통 코드를 상위에 두어 변경이 용이
	 * 확장성 : 하위에서 오버라이딩으로 동작을 재정의.
	 * 
	 * 
	 * 특징
	 * 단일 상속 : 다중 상속은 불가
	 * 오버라이딩 : 부모 메서드의 선언부를 동일하게 하되 구현을 재정의
	 * 			- 접근 범위는 축소 불가
	 * 			- 반환형도 동일.
	 * 
	 * super와 생성자
	 *  - 자식 생성자 첫줄에는 super()키워드를 통한 부모생성자 호출이 가능하다
	 *  - 생략시 부모의 기본 생성자가 자동 호출
	 *  Object의 후손 : 
	 *  - 모든 클래스는 Object라는 최상위 클래스를 상속 받는다.
	 *  - toString(), equals(), hashCode() 등 오버라이딩 가능 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
//		Man m1 = new Man();
//		BusinessMan m2 = new BusinessMan("ㅎㅇㅇ", "ㅎㅇㅇ2", "ㅎㅇㅇ3");
//		
//		m2.tellYourInfo();
		
		Desktop d1 = new Desktop();
		Desktop d2 = new Desktop("d-100",1000000,"LG",false);
		
		TV t1 = new TV();
		TV t2 = new TV("t-100",1000000,"LG",65);
		
		System.out.println(t2.inform());
		System.out.println(d2.inform());
	}

}
