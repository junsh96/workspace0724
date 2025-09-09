package com.kh.method;


public class MethodLocalVariable {

	/*
	 * 지역변수는
	 * - 블록({}) 내부에서 선언된 변수
	 * - 해당 블록을 벗어나면 메모리에서 제거됨.
	 * - 선언시 반드시 초기화 후 사용해야함.
	 * 
	 * - 매개 변수
	 * - 메서드 호출시 외부에서 전달 받는 값을 저장하는 지역 변수.
	 * - 메서드 선언부에 정의 됨.
	 * - 메서드 실행시 생성되고, 메서드 종료시 사라짐.	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "철수";
		int age = 20;
		
		System.out.println("say실행");
		
		say(name,age);
		
		//call by value(값에 의한 호출)
		
		//메모리에 담긴 값 자체를 전달
		// 기본형 -> 값(데이터) 자체가 복사됨
		/// 참조형 -> 참조값(주소)이 복사됨
		/// 주소값을 복사해서 같은 객체를 가르키게 되므로 내부데이터를 변경하면 원본에도 영향을 줌.

		//기본형
		int num = 10;
		changeValue(num);
		System.out.println("호출후 val : " + num);
		
		
		//참조형
		int[] arr = {1,2,3};
		
		changeReference(arr);
		
		System.out.println("호출후 array : ");
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		//참조형을 전달하면 실제 값 자체를 전달하는게 아니라
		//참조형에 담긴 주소값을 전달하기 때문에
		//해당 주소로 접근해서 원본 데이터를 변경할수 있다.
		
	}
	
	public static void changeReference(int[] array) {
		System.out.println("전달 받은 array : ");
		for (int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
		
		array[0] = 100;
		
		System.out.println("0번 변경된 array : ");
		for (int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void changeValue(int value) {
		System.out.println("전달받은 val : "+ value);
		value = 100;
		System.out.println("변경된 val : " + value);
	}
	
	public static void say(String name, int age) {
		name = "지원";
		System.out.println("say 내부 name:"+name);
	}

}
