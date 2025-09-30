package com.kh.loop;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i=1; i< 10; i++) {
			System.out.printf("%d * %d = %d\n",n,i,n*i );
		}

		sc.close();
	}

}
