package com.kh.practice;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int [] white = new int[6];
		int [] black = new int[6];
		black[0] = 1;
		black[1] = 1;
		black[2] = 2;
		black[3] = 2;
		black[4] = 2;
		black[5] = 8;
		
		
		
		for (int i=0; i<6; i++) {
			white[i] = sc.nextInt();
		}
		
		for (int i=0; i<6; i++) {
			
			System.out.print(black[i]-white[i]+" ");
			
		}

	}

}
