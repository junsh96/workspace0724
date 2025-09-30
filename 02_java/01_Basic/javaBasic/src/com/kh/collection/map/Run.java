package com.kh.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Run {

	/*
	 * Map
	 * KEy / value를 쌍으로 저장하는 구조
	 * key는 중복 불가 / value는 중복가능
	 * HashMap(가장 보편적이고 속도 향상)
	 * LinkedHashMap(입력 순서 보장)
	 * TreeMap(정렬된 Key순서 유지)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, Human> hMap = new HashMap<>();
		
		//1. put() map에 key value쌍으로 값을 추가
		hMap.put(10, new Human("test",20));
		hMap.put(20, new Human("test2",30));
		hMap.put(30, new Human("test3",40));
		System.out.println(hMap); // 저장시 순서 유지 x
		//동일한 key 사용시 값을 덮어씀
		
		//2. get(key) 해당 키의 value를 반환
		hMap.get(20);
		
		//3.size() 담겨있는 객체수
		hMap.size();
		
		//4.remove(key) :해당 키의 값을 찾아서 제거
		hMap.remove(40);
		
		//map에 전체 요소를 탐색하는 방법
		//Iterator 이용 x
		//for each 이용 x
		
		//다른 자료 구조로 변경 후 반복
		//1. key를 모아 set 자료구조 형태로 반환.
		Set keySet = hMap.keySet();
		
		for (Object key : keySet) {
			hMap.get(key);
		}
		
		//2. enteySet을 이용한 전체탐색
		//Map은 key와 value를 쌍으로 저장하기 때문에 단순하게 keySet,values만으로는
		//한번에 key의 값을 가져올수 없음.
		//Set<Map.Entry<K,V>>
		Set entrySet = hMap.entrySet();
		for (Object entry : entrySet) {
			Entry e = (Entry)entry;
			System.out.println(e.getKey());
		}
		
	}

}
