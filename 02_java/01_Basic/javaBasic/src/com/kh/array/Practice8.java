package com.kh.array;

import java.util.Scanner;

public class Practice8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		int [][] paper = new int[100][100];
		
		for (int i=0; i<paper.length; i++) {
			
			for (int j=0; j<paper[i].length; j++) {
				
				paper[i][j] = 0;
				
			}
			
		}
		
		for (int i=0; i<cnt; i++) {
			
			int x = sc.nextInt();
			
			int y = sc.nextInt();
			
			
			for (int k=0; k<paper.length; k++) {
				
				for (int j=0; j<paper[k].length; j++) {
					
					if (k >= x && k < x+10) {
						
						if (j >= y && j < y+10) {
							
							paper[k][j] = 1;
						}
						
					}
					
				}
				
			}

		}
		
		int size = 0;
		
		for (int i=0; i<paper.length; i++) {
			
			for (int j=0; j<paper[i].length; j++) {
				
				if (paper[i][j] == 1) {
					size ++;
				}
				
			}
			
		}
		
		System.out.println(size);
		
		
		

	}

}
