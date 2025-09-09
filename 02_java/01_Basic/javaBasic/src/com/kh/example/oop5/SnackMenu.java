package com.kh.example.oop5;

import java.util.Scanner;

public class SnackMenu {

	Scanner sc = new Scanner(System.in);
	
	SnackController scr = new SnackController();
	
	public void menu() {
		System.out.println("스낵류를 입력하세요");
		System.out.println("종류 : ");
		String kind = sc.next();
		System.out.println("이름 : ");
		String name = sc.next();
		System.out.println("맛 : ");
		String flavor = sc.next();
		System.out.println("개수 : ");
		int cnt = sc.nextInt();
		System.out.println("가격 : ");
		int price = sc.nextInt();
		
		scr.saveData(kind, name, flavor, cnt, price);
		System.out.println("저장 완료되었습니다.");
		
		System.out.println("저장한 정보를 확인 하시겠습니까?");
		
		String a = sc.next();
		if (a.toUpperCase().equals("Y")) {
			String result = scr.confirmData();	
			System.out.println(result);
		} else {
			menu();
		}
	}
	
}
