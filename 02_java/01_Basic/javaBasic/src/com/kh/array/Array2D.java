package com.kh.array;

import java.util.Scanner;

public class Array2D {
	
	/*
	 * 2차원 배열
	 * 자료형이 같은 1차원 배열의 묶음.
	 * 
	 * ex) int[행][열] arr -> ~열의 1차원배열이 행만큼 존재.
	 * 2차원 배열은 할당된 공간마다 index를 2개 부여(앞은 행 : 몇번째 1차원 배열인지, 뒤는 열 : 1차원 배열의 갯수)
	 * 
	 * 선언된 공간마다 같은 길이의 1차원 배열을 사용할수도 있고,
	 * 각각 다른 길이의 1차원 배열을 할당 할 수도 있음.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//2차원 배열
		int [][] arr;
		
		//2차원 배열의 메모리 할당
		//배열명 = new 자료형 [n][m];
		// -> n행 m열 생성
		//배열명 = new 자료형 [n][];
		// -> 1차원 배열의 참조변수만 n개 생성;
		// -> arr[0] = new int[5];
		// -> arr[1] = new int[3];
		
	}

}
