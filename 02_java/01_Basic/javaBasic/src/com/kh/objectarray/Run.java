package com.kh.objectarray;

public class Run {

	/**
	 * 객체 배열
	 * 같은 타입의 객체 여러개를 하나의 배열에 저장해 관리하는것.
	 * 배열의 각 요소가 객체 자체를 저장하는게 아니라 객체의 주소(참조값)을 저장.
	 * 		배열 생성시 객체까지 자동으로 생성되는것이 아니라. 각 요소에 객체를 직접 생성해서 넣어야함.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. 객체 배열 선언 및 생성
		Book[] books = new Book[3]; //= Book book1, book2, book3
		
		for (Book b : books) 
					System.out.println(b);

		
	}

}
