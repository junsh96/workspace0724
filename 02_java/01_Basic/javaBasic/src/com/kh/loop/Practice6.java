package com.kh.loop;

import java.util.Scanner;

public class Practice6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		for (int i=1; i<=a; i++) {
			for (int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println("");
			
		}
	}

}
