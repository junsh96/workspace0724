package com.kh.example.exception1;

import java.util.Scanner;

public class CharacterMenu {

	public void menu() {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		CharacterController ch = new CharacterController();
		try {
			int cnt = ch.countAlpha(str);
			
		} catch (CharCheckException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}
}
