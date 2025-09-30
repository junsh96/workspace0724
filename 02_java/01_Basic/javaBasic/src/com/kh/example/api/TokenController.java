package com.kh.example.api;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {
		super();
	}

	public String afterToken(String str) {
		StringTokenizer stn = new StringTokenizer(str," ");
		
		int size = stn.countTokens();
		//StringBuilder sb = new StringBuilder;
		String str2 ="";
		for(int i=0; i<size; i++) {
			str2 += stn.nextToken();
			//sb,append(stn.nextToken());
		}
		//return sb.toString();
		return str2;
	}
	
	public String firstCap(String input) {
		
		String str1 = input.substring(0,1);
		
		String str2 = input.substring(1);
		
		String result = str1.toUpperCase() + str2;
		
		return result;
	}
	
	public int findChar(String input, char one) {
		int cnt = 0;
		for (int i=0; i<input.length(); i++) {
			
			if (input.charAt(i) == one) {
				cnt++;
			}
			
		}
		
		return cnt;
	}
	
	
	
}
