package com.kh.object.ex1;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//class명 객체 이름; -> 해당 class타입의 참조변수 생성
		Student choi;
		//객체 이름은 = new class병() -> 새로운 class타입의 메모리 공간을 할당해서 주소를 참조해라.
		choi = new Student();
		
		Student kim = new Student();
		
		choi.name = "최지원";
		choi.age = 55;
		
		kim.name = "김민수";
		kim.age = 30;
		
		choi.myInfo();
		
	}

}
