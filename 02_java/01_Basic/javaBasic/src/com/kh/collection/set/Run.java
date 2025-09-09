package com.kh.collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Run {

	
	/**
	 * Set
	 * 순서가 없고, 중복을 허용하지 않는 자료구조.
	 * index 개념이 없어서 위치 기반 접근이 불가
	 * -HashSet : 일반적인 해시 알고리즘이 적용된 set
	 * -LinkedHashSet : HashSet + 순서 유지
	 * -TreeSet : 자동정렬 기능 제공.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Human> set = new HashSet<>();
		
		set.add(new Human("test",20));
		set.add(new Human("test1",22));
		set.add(new Human("test2",25));
		
		//set에 저장해서 사용하는 객체는 equals와 hashcode를 오버라이딩 해야한다.
		//set은 hashcode()로 분류후 equalse()로 비교해서 중복값을 검사함.
		
		//동일 객체 : (h1.equals(h2) && h1.hashcode() == h2.hashcode())
		//객체마다의 정의된 hashcode와 equals의 결과가 모두 일치하는 객체
		//equals와 hashcode를 오버라이딩 하지 않으면 object의 equals와 hashcode를 사용함.
		///object / equalse -> 주소값 비교
		/// -> hashcode => 주소값을 가지고 10진수형 해시값을 구한것.
		
		//contains() : 요소에 포함 여부 확인
		Human h1 = new Human("test",20);
		System.out.println(set.contains(h1));
		
		//remove(E e) 요소를 통해 요소 제거
		
		//set의 모든 요소에 순차적으로 접근하는 방법
		//set은 index 가 없기 때문에 get()사용 불가.
		
		//1. for each
		for (Human h : set) {
			System.out.println(h);
		}
		
		//2. arraylist에 담아서 반복 -> addAll(Collection e)
		ArrayList list = new ArrayList();
		list.addAll(list);
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//3. Iterator(반복자 인터페이스)를 사용.
		//컬렉션에 저장된 요소를 순차적으로 접근하기 위한 인터페이스
		//순서가 없는 set같은 자료구조를 탐색할때 반드시 필요.
		//hasNext() : 다음 읽을 요소가 있으면 true, 없으면 false
		//next() : 다음요소 반환
		
		Iterator it =  set.iterator();
		
		
		while(it.hasNext()) {
			Human h = (Human) it.next();
		}
		
	}

}
