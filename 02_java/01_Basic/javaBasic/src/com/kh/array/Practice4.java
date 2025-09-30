package com.kh.array;

import java.util.Scanner;

public class Practice4 {

	//학생 30명이 있고, 28명이 과제를 제출했습니다. 
	//제출하지 않은 2명의 출석번호를 오름차순으로 출력하는 프로그램을 작성하세요. 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int [] student = new int[30];
		int [] student2 = new int[28];
		for (int i=1; i<31; i++) {
			student[i-1] = i;
		}
		System.out.println("제출한 출석번호 입력");
		for (int i=0; i<28; i++) {
			
			student2[i] = sc.nextInt();
		}
		
		for (int i = 0; i<student.length; i++) {
			
			for (int j=0; j<student2.length; j++) {
				
				if(student[i] == student2[j]) {
					break;
				} else {
					if (j==student2.length-1) {
						System.out.println(student[i]);						
					}
				}
				
			}
			
		}
		
		
	}

}
