package com.kh.array;

import java.util.Scanner;

public class ArrayCopy {

	public static void main(String[] args) {
		//
		Scanner sc = new Scanner(System.in);
		
		int [] origin = {1,2,3,4,5};
		
		for(int n : origin) {
			System.out.print(n+" ");
		}
		
		//origin을 copy에 단순 대입해서 생성
		int [] copy = origin;
		
		
		// copy배열의 값을 수정해도 원본의 값이 변경된
		// 원본과 copy배열이 모두 같은 메모리를 참조중이기 때문
		//얕은 복사 : 주소값 복사
		
		// 배열 복사 방법.
		
		/*
		 * 1. for 문을 사용하여 새로운 배열 생성.
		 * 
		 * 완벽한 깊은 복사 : 서로 독립적인 배열 생성.	
		 */

		
		/*
		 *	clone()
		 *	java에서 제공하는 메서드.
		 *	배열의 모든 요소를 새로운 배열로 복사
		 *	기본적으로 얕은 복사를 진행, 단 기본형 배열은 깊은 복사로 동작 
		 */
		
		int [] origin3 = {1,2,3,4,5};
		int [] copy3 = origin3.clone();
	}

}
