package com.kh.array;

import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		//1. 크기가 10인 정수형 배열 생성
		int [] arr = new int[10];
		//2. 반복문을 통해서 0번인덱스부터 마지막 인덱스까지 10으로 초기화
		for (int i=0; i<arr.length; i++) {
			arr[i] = 10;
		}
		//3, for-each를 통해서 모든배열의 요소를 출력
		for (int j : arr) {
			System.out.println("arr : " + j);
		}
		//4. 사용자에게 배열의 길이를 입력받아서  해당 크기의 문자열 배열 nameArr을 생성
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력");
		int k = sc.nextInt();
		String[] nameArr = new String[k];
		//5. 사용자에게 사람의 이름을 입력받아서 nameArr에 할당. 모든 요소만큼 실행.
		System.out.println("이름 입력");
		
		for (int l = 0; l< nameArr.length; l++) {
			String name = sc.next();
			nameArr[l] = name;
		}
		//6. 사용자에게 이름을 하나 입력받아 nameArr에 동일한 이름이 있다면 
		// 동일한 이름이 존재합니다. /동일한 이름이 존재하지 않습니다 출력.

		System.out.println("이름 입력2");
		String name2 = sc.next();
		int p =0;
		for (int o = 0; o< nameArr.length; o++) {
			if(nameArr[o].equals(name2)) {
				System.out.println("동일한 이름이 존재합니다.");
				p++;
			}
			if (o == nameArr.length-1) {
				if (p == 0) {
					System.out.println("동일한 이름이 존재하지 않습니다.");
				}
			}
		}
		
	}

}
