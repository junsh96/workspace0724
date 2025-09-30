package com.kh.generic;

public class Run {

	
	/*
	 *제네릭을 사용하지 않고 object와 같은 넓은 범위를 수용할수있는 필드 변수타입을 사용시 
	 *-> 형변환 필요,런타임 오류
	 * 클래스나 메서드가 사용할 데이터 타입을 컴파일 시점에 지정할수있도록 지원하는 문법
	 * -> 매개타입(객체 생성시 타입을 전달받아 결정) 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Box aBox = new Box<>();
		aBox.setValue("value");
		System.out.println(aBox.getValue());
		
		Box<Integer> iBox = new Box<>();
		iBox.setValue(10);
		
		System.out.println(iBox.getValue());
		
		Integer[] arr = new Integer[5];
		iBox.setArr(arr);
		
	}

}
