package com.kh.practice;

import java.util.Scanner;

public class Practice4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		String [] cro = new String[8];
		
		cro[0] = "c=";
		cro[1] = "c-";
		cro[2] = "dz=";
		cro[3] = "d-";
		cro[4] = "lj";
		cro[5] = "nj";
		cro[6] = "s=";
		cro[7] = "z=";
		
		int cnt = 0;
		
		String str2 = "";
		for (int i = 0; i<str.length(); i++) {
			for (int j=0; j<cro.length; j++) {
				if (i < str.length()-1) {
					String a1 = ""+str.charAt(i);
					String a2 = ""+str.charAt(i+1);

					if ((a1+a2).equals(cro[j])) {

						cnt ++;
						i++;
						str2 += (a1+a2);
						break;
					} 
				}
				
				
			}
			
			
			
		}

		System.out.println(cnt+(str.length() - str2.length()));
		//System.out.println(cnt);
		
		
	}

}
//int cnt = 0;
//
//int n = 0;	
//
//for (int j=0; j<cro.length; j++) {
//	
//	if (str.indexOf(cro[j],n) != -1) {
//		n+=2;
//	}
//	
//}