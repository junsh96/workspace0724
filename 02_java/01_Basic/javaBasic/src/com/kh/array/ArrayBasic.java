package com.kh.array;

public class ArrayBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr1 = new int[5]; 
		arr1[0] = 0;
		arr1[1] = 1;
		arr1[2] = 2;
		arr1[3] = 3;
		arr1[4] = 4;
		//배열 초기화
		int [] arr2 = {0,1,2,3,4};
		
		//배열 선언 : 자료형 [] 배열명
		int [] arr3;
		//메모리 할당
		arr3 = new int[10];
		
		//값 할당
		for (int i=0; i<arr3.length; i++) {
			arr3[i] = i;
		}
		
		for (int i=0; i<arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		
		//for each문 : 배열을 전체적으로 탐색할때 쉽게 사용할수있는 문법
//		for(배열의 값을 받아줄 변수 : 배열) {
//			반복할 코드
//		}
		
		for (int num : arr3) {
			System.out.print(num+" / ");
		}
	}

}
