package com.kh.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Run {

	
	/*
	 * 컬렉션
	 * 자료구조 개념이 내장되어있는 클래스로 자바에서 제공하는 라이브러리
	 * 
	 *  - 자료구조 : 데이터를 보다 효율적으로 관리(추가,삭제,조회,정렬,수정) 할수있도록 해주는 구조
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//list(순서 O , 중복 허용)
		//ArrayList (배열기반), LinkedList(노드 기반), Vector, Stack(vector기반 lifo구조)
		
		List list = new ArrayList<>(); // 크기를 지정하지 않아도 됨
		
		//1. add(E e) : 리스트 공간 끝에 전달된 데이터를 추가
		
		list.add(new Human("test",25));
		
		System.out.println(list);
		
		//지정된 크기보다 더 많이 추가해도 에러가 발생하지 않음, 장점1
		//다양한 타입의 데이터를 담을 수 있음 . 장점 2
		
		//2, add(int , E  e) : 직접 인덱스를 지정해서 해당 위치에 데이터를 추가
		list.add(1, new Human("???",20));
		
		//3. remove(int) 해당 인덱스 위치에 데이터를 삭제시켜주는 메소드
		
		//4.remove(E e) : 객체를 직접 지정해서 삭제.(사용을 위해선 객체의 equals를 오버라이딩 해야 한다.)
		
		//5. set(int, E e) : 해당 인덱스의 값을 전달받은 e로 덮어 씌움
		
		//6 size() : 리스트의 사용중인 사이즈를 반환
		
		//7 get(int) : 해당 인덱스의 객체를 반환
		
		//8.addAll(Collection c) : 컬렉션을 통째로 뒤에 추가할수 있다.
		
		//9. isEmpty() : boolean -> 컬렉션이 비어있는지 확인
		
		//10. clear() 컬렉션의 내용을 전부 비워버리는 메서드
		
		//리스트 전체 접근 방법
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for(Object h : list) {
			System.out.println(h);
		}
		
		//Stack
		
		Stack<String> stack = new Stack<>();
		
		//데이터 추가
		stack.push("첫번째");
		stack.push("두번째");
		stack.push("세번째");
		
		System.out.println(stack);
	
		//.peek() 맨 위 데이터를 확인
		
		//pop() 데이터 꺼낵기
		
		//검색 Search(E e) 데이터 검색후 위치 반환(위에서부터)
		
		//stack 전체 꺼내기
		//while(!stack.isEmpty()) {
		//	System.out.println(stack.pop());
		//}
		
		
	}
	

}
