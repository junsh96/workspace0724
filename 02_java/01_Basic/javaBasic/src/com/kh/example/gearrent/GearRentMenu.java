package com.kh.example.gearrent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GearRentMenu {

	GearRentController gc = new GearRentController();
	
	Scanner sc = new Scanner(System.in);
	
	
	public void mainMenu() {
		
		int mainNo = 0;
		
		while(mainNo < 9) {
			System.out.println("====메인 메뉴====");
			System.out.print("1) 장비등록  ");
			System.out.print("2) 회원등록  ");
			System.out.print("3) 대여  ");
			System.out.print("4) 반납  ");
			System.out.print("5) 태그검색");
			System.out.println("6) 키워드검색 ");
			System.out.print("7) 전체장비  ");
			System.out.print("8) 대여중목록  ");
			System.out.print("9) 종료  ");
			
			System.out.println("메뉴: ");
			mainNo = sc.nextInt();
			
			switch(mainNo) {
			case 1:
				addDevice();
				break;
			case 2:
				addMember();
				break;
			case 3:
				borrow();
				break;
			case 4:
				returnItem();
				break;
			case 5:
				findByTag();
				break;
			case 6:
				findByKeyword();
				break;
			case 7:
				printAllDevices();
				break;
			case 8: 
				printActiveLoans();
				break;
			case 9:
				System.out.println("프로그램이 종료됩니다.");
				break;
			default : 
				System.out.println("잘못입력하셨습니다.");
				break;
			
			}
		}
		
	}
	
	
	public void addDevice() {
		System.out.println("유형(1:Camera, 2:Laptop) :");
		int kind = sc.nextInt();
		System.out.print("id : ");
		String id = sc.next();
		System.out.print("name : ");
		String name = sc.next();
		System.out.print("category : ");
		String category = sc.next();
		System.out.print("tags(쉼표로 구분) : ");
		String tags = sc.next();
		Set<String> tag = new HashSet<>();
		String [] strArray = tags.split(",");
		for (String s : strArray) {
			tag.add(s);
		}
		
		Device device = null;
		if (kind == 1) {
			device = new Camera(id, name, category, tag);
			
		} else {
			device = new Laptop(id, name, category, tag);
		}
		System.out.println(device);
		boolean restult = gc.addDevice(device);
		
		if(restult) {
			System.out.println("등록이 완료되었습니다.");
		} else {
			System.out.println("중복된 아이디 입니다.");
		}
		
		
	}
	
	public void addMember() {
		System.out.print("member id : ");
		String id = sc.next();
		System.out.print("name : ");
		String name = sc.next();
		
		Member m = new Member();
		m.setId(id);
		m.setName(name);
		boolean result = gc.addMember(m);
		
		if (result) {
			System.out.println("가입완료");
		} else {
			System.out.println("가입 실패 아이디를 확인해주세요.");
		}
	}
	
	public void borrow() {
		System.out.print("memberId : ");
		String id = sc.next();
		System.out.print("itemId : ");
		String itemId = sc.next();
		System.out.print("대여일(YYYY-MM-DD) : ");
		String day = sc.next();
		LocalDate date = LocalDate.parse(day);
		
		
		Loan result = gc.borrow(id, itemId, date);
		
		System.out.println("대여완료 : " +result.toString());
		
		
		
	}
	
	public void returnItem() {
		System.out.println("itemId : ");
		String itemId = sc.next();
		System.out.println("반납일(YYYY-MM-DD) : ");
		String day = sc.next();
		LocalDate date = LocalDate.parse(day);
		
		int fee = gc.returnItem(itemId, date);
		if (fee < 0 ) {
			System.out.println("대여 기록이 없습니다.");
		} else {
			System.out.println("반납완료 연체료 " +fee+"원");			
		}
		
	}
	
	public void findByTag() {
		System.out.println("검색할 태그 문자.");
		String tag = sc.next();
		
		ArrayList<Device> result = gc.findByTag(tag);
		
		if (result.size() > 0) {
			for (int i=0; i<result.size(); i++) {
				System.out.println(result.get(i));
			}
		} else {
			System.out.println("결과 없음");
		}
		
		
	}
	
	public void findByKeyword() {
		System.out.println("검색할 단어를 입력해주세요.");
		String keyWord = sc.next();
		
		ArrayList<Device> result =gc.findByKeyword(keyWord);
		
		if (result.size() > 0) {
			for (int i=0; i<result.size(); i++) {
				System.out.println(result.get(i));
			}
		} else {
			System.out.println("결과 없음");
		}
	}
	
	public void printAllDevices() {
		Collection<Device> result = gc.getAllDevices();
		
		for (Device device : result) {
			System.out.println(device);
		}
		
	}
	
	public void printActiveLoans() {
		Collection<Loan> result = gc.getActiveLoans();
		
		for (Loan loan : result) {
			System.out.println(loan);
		}
	}
	
}
