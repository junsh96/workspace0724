package com.kh.array;

import java.util.Scanner;

public class Practice6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		
		int m = sc.nextInt();
		
		int [][] A = new int[n][m];
		int [][] B = new int[n][m];
		
		for (int i =0; i<A.length; i++) {
			
			for (int j=0; j<A[i].length; j++) {
				A[i][j] = sc.nextInt();
			}
			
		}
		
		for (int i=0; i<B.length; i++) {
			
			for (int j= 0; j<B[i].length; j++) {
				B[i][j] = sc.nextInt();
			}
			
		}
		
		for (int i=0; i< A.length; i++) {
			
			for (int j=0; j<A[i].length; j++) {
				
				System.out.print((A[i][j]+B[i][j]) + " ");
				
			}
			
			System.out.println(" ");
			
		}

	}

}
