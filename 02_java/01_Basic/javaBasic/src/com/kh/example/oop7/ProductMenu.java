package com.kh.example.oop7;

import java.util.Scanner;

public class ProductMenu {

	ProductController pc = new ProductController();
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
		System.out.println("======상품 관리 메뉴=======");
		System.out.println("1. 상품 추가");
		System.out.println("2. 상품 전체 조회");
		System.out.println("9. 프로그램 종료");
		System.out.println("메뉴 번호 : ");
		int menuNo = sc.nextInt();
		
		if (menuNo == 1) {
			String pName = sc.next();
			int price = sc.nextInt();
			String brand = sc.next();
			
			pc.insertProduct(pName,price,brand);
			
			mainMenu();
			
		} else if (menuNo == 2 ) {
			Product[] result = pc.selectProduct();
			System.out.println(result.length);
			for (int i=0; i<result.length; i++) {
				if (result[i] == null) {
					break;
				}
				String pName = result[i].getpName();
				int price = result[i].getPrice();
				String brand = result[i].getBrand();
				System.out.printf("상품명 : %s / 가격 : %d / 브랜드 : %s \n",pName,price,brand);
			}
			
			mainMenu();
		} else if(menuNo == 9) {
			System.out.println("프로그램을 종료합니다.");
		} else {
			System.out.println("잘못 입력하셧습니다.");
		}
		
	}
	
}
