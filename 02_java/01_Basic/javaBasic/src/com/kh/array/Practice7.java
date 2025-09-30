package com.kh.array;

import java.util.Scanner;

public class Practice7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int m = sc.nextInt();
		
		int [][] arr = new int[n][m];
		
		for (int i=0; i<arr.length; i++) {
			
			for (int j=0; j<arr[i].length; j++) {
				
				arr[i][j] = sc.nextInt();
				
			}
			
		}
		
		
		int max = 0;
		int a = 0;
		int b = 0;
		
		for (int i=0; i<arr.length; i++) {
			
			for (int j=0; j<arr[i].length; j++) {
				
				if (i==0 && j==0) {
					max = arr[i][j];
				} else {
					
					if (max < arr[i][j]) {
						max = arr[i][j];
						a = i+1;
						b = j+1;
					}
					
				}
				
			}
			
		}
		
		System.out.println(max);
		System.out.print(a+" "+b);
		
		
		
		

	}

}
