package com.kh.array;

import java.util.Scanner;

public class Practice {

	//N개의 정수가 주어질 때, 이들 중 최솟값과 최댓값을 찾는 프로그램을 작성하세요
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력할 정수 갯수");
		int cnt = sc.nextInt();
		System.out.println("비교할 정수");
		int [] numArr = new int[cnt];
		
		for (int i=0; i<cnt; i++) {
			numArr[i] = sc.nextInt();
		}
		
		int max = 0;
		int min = 0;
		for (int i=0; i<numArr.length; i++) {
			
			for (int j = 0; j<numArr.length; j++) {
				if (i==0) {
					if(numArr[i] > numArr[j]) {
						max = numArr[i];
					}else if(numArr[i] < numArr[j]) {
						min = numArr[i];
					}
				} else {
					if(numArr[j] > max) {
						max = numArr[j];
					}else if( numArr[j] < min) {
						min = numArr[j];
					}
				}
				
			}
			
			
			
		}
		System.out.print(min +" " + max);

	}

}
