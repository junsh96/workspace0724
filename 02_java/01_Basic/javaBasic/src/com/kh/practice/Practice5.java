package com.kh.practice;

import java.util.Scanner;

public class Practice5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		int [] grpArr = new int[cnt];
		int grpCnt = 0;
		for (int i=0; i<grpArr.length; i++) {
			
			grpArr[i] = 0;
			
		}
		
		for (int i=0; i<cnt; i++) {
			String str = sc.next();
			
			for (int j=0; j<str.length(); j++) {
				
				if (j != 0 ) {
					
					if (str.charAt(j) != str.charAt(j-1)) {
					
						for (int k=0; k < j; k++) {
							
							if (str.charAt(j) == str.charAt(k)) {
								
								grpArr[i] = 1;
								break;
							}
							
						}
					
					
					}
				} 
				
				
				
			}
			
			
		}
		
		
		for (int i=0; i<grpArr.length; i++) {
			if (grpArr[i] == 0) {
				grpCnt++;	
			}
		}

		System.out.println(grpCnt);
		
	}

}
