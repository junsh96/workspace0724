package com.kh.example.poly2;

import java.util.Scanner;

public class LibraryMenu {

	LibraryController lc = new LibraryController();
	
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		Member mList = lc.myInfo();
		System.out.println(mList);
		System.out.println(mList == null);
		if (mList.getName() == null) {
			Member mem = new Member();
			System.out.println("이름 :");
			String name = sc.next();
			System.out.println("나이 :");
			int age = sc.nextInt();
			System.out.println("성별 :");
			String gen = sc.next();
			
			mem.setName(name);
			mem.setAge(age);
			mem.setGender(gen.charAt(0));
			
			lc.insertMember(mem);
		}
		
		
		int mainMenu = 0;
		
		while(mainMenu !=5){
			System.out.println("====메인 메뉴====");
			System.out.println("1. 마이 페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("5. 프로그램 종료");
			mainMenu = sc.nextInt();
			switch(mainMenu) {
			case 1 :
				Member memList = lc.myInfo();
				System.out.println(memList);
				break;
			case 2 :
				selectAll();
				break;
			case 3 : 
				searchBook();
				break;
			case 4 : 
				rentBook();
				break;
			case 5 : 
				System.out.println("프로그램을 종료합니다.");
				break;
			default :
				System.out.println("잘못입력하셨습니다.");
				break;
			} 
			
		}
		
		
	}
	
	public void selectAll() {
		Book[] bList = lc.selectAll();
		
		for (int i=0; i<bList.length; i++) {
			System.out.println(i+"번 도서 :"+bList[i]);
		}
		
	}
	
	public void searchBook() {
		System.out.println("검색할 키워드 입력 : ");
		String keyword = sc.next();
		Book[] newList = lc.serachBook(keyword);
		for (int i=0; i<newList.length; i++) {
			System.out.println(newList[i]);
		}
	}
	
	
	public void rentBook() {
		selectAll();
		System.out.println("대여할 도서 번호 선택 : ");
		Book[] bList = lc.selectAll();
		int rentNo = sc.nextInt();
		if(rentNo > bList.length || rentNo < 0) {
			System.out.println("도서번호를 확인해주세요.");
			rentBook();
		} else {
			int result = lc.rentBook(rentNo);
			
			if (result == 0) {
				System.out.println("성공적으로 대여되었습니다.");
			} else if (result == 1) {
				System.out.println("나이제한으로 대여가 불가능 합니다.");
			} else if (result == 2) {
				System.out.println("성공적으로 대여되었습니다.  요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요");
			}
		}
		
		
	}
	
	
}
