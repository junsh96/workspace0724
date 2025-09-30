package com.kh.practice;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int t = 0;
		
		for (int i=0; i<str.length(); i++) {
			
			if (i < (str.length()/2)) {
				
				if (str.charAt(i) == str.charAt(str.length()-1-i)) {
					t = 1;
				} else {
					t = 0;
					break;
				}
				
			} else {
				
				break;
				
			}
			
			
			
			
		}
		
		System.out.println(t);
		
	}

}
