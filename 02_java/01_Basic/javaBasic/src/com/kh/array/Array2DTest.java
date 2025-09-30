package com.kh.array;

import java.util.Scanner;

public class Array2DTest {

	public static void main(String[] args) {
		//사용자에게 행과 열을 입력받아
		//해당 행과 열의 빙고판을 만들어라.
		//다음 행과 열에 들어갈 문자를 입력받아 저장한뒤
		//출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("행과 열 입력");
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		String [][] arr1 = new String [m][n];
		
		
		for (int i=0; i<arr1.length; i++) {
			
			for (int j=0; j<arr1[i].length; j++) {
				
				System.out.println((i+1)+"행"+(j+1)+"열");
				
				arr1[i][j] = sc.next();
				
			}
			
		}
		
		
		for (int i=0; i<arr1.length; i++) {
			
			for (int j=0; j<arr1[i].length; j++) {
				
				System.out.print(arr1[i][j] + " ");
				
			}
			System.out.println("");
			
		}
		
		sc.close();
		
		
	}
}
