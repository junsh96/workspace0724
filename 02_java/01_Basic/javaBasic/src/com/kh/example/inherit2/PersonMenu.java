package com.kh.example.inherit2;

import java.util.Scanner;

public class PersonMenu {

	Scanner sc = new Scanner(System.in);
	PersonControll pc = new PersonControll();
	
	public void mainMenu() {
		
		System.out.println("====메인 메뉴====");
		
		int[] cnt =  pc.personCount();
		
		System.out.println("학생은 최대 3명까지 저장할수 있습니다. \n 현재 저장된 학생은"+cnt[0]+"명 입니다");
		System.out.println("사원은 최대 3명까지 저장할수 있습니다. \n 현재 저장된 사원은"+cnt[1]+"명 입니다");
		
		System.out.println("1. 학생메뉴");
		System.out.println("2. 사원메뉴");
		System.out.println("9. 끝내기");
		
		System.out.println("메뉴 번호 : ");
		int menuNo = sc.nextInt();
		
		if (menuNo == 1) {
			studentMenu();
		} else if (menuNo == 2) {
			employeeMenu();
		} else if (menuNo == 9) {
			System.out.println("프로그램이 종료됩니다.");
		} else {
			System.out.println("잘못 입력하셨습니다.");
			mainMenu();
		}
	
	}
	
	public void studentMenu() {
		
		System.out.println("====학생 메뉴====");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 보기");
		System.out.println("9. 메인으로");
		
		int stNo = sc.nextInt();
		
		if (stNo == 1) {
			
			int[] cnt =  pc.personCount();
			if (cnt[0] == 3) {
				System.out.println("학생을 담을수있는 공간이 꽉 찼습니다.");
				studentMenu();
			} else {
				insertStudent();				
			}
		} else if (stNo == 2) {
			printStudent();
		} else if (stNo == 9) {
			mainMenu();
		} else {
			System.out.println("잘못 입력하셨습니다.");
			studentMenu();
		}
		
	}
	
	
	public void employeeMenu() {
		
		System.out.println("====사원 메뉴====");
		
		System.out.println("1. 사원 추가");
		System.out.println("2. 사원 보기");
		System.out.println("9. 메인으로");
		
		int emNo = sc.nextInt();
		int[] cnt =  pc.personCount();
		if (emNo == 1) {
			if (cnt[1] == 10) {
				System.out.println("사원을 담을수있는 공간이 꽉찼습니다.");
				employeeMenu();
			} else {
				insertEmployee();				
			}
		} else if (emNo == 2) {
			printEmployee();
		} else if (emNo == 9) {
			mainMenu();
		} else {
			System.out.println("잘못 입력하셨습니다.");
			employeeMenu();
		}
		
	}
	
	public void insertStudent() {
		System.out.println("학생이름 : ");
		String name = sc.next();
		System.out.println("학생 나이 : ");
		int age = sc.nextInt();
		System.out.println("학생 키 : ");
		double height = sc.nextDouble();
		System.out.println("학생 몸무게 : ");
		double weight = sc.nextDouble();
		System.out.println("학생 학년 : ");
		int grade = sc.nextInt();
		System.out.println("학생 전공 : ");
		String major = sc.next();
		
		pc.insertStudent(name, age, height, weight, grade, major);
		
		System.out.println("그만하시려면 N(또는 n), 이어하시려면 아무키나 누르세요");
		String con = sc.next();
		int[] cnt =  pc.personCount();
		if (con.toUpperCase().equals("N")) {
			studentMenu();
		} else {
			if (cnt[0] == 3) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다.");
				studentMenu();
			} else {
				insertStudent();
			}
			
		}
		
		
	}
	
	
	public void printStudent() {
		Student[] sList = pc.printStudent();
		
		for (int i=0; i<sList.length; i++) {
			
			System.out.println(sList[i]);
			
		}
	}
	
	public void insertEmployee() {
		System.out.println("사원이름 : ");
		String name = sc.next();
		System.out.println("사원 나이 : ");
		int age = sc.nextInt();
		System.out.println("사원 키 : ");
		double height = sc.nextDouble();
		System.out.println("사원 몸무게 : ");
		double weight = sc.nextDouble();
		System.out.println("사원 연봉 : ");
		int salary = sc.nextInt();
		System.out.println("사원 부서 : ");
		String dept = sc.next();
		
		
		pc.insertEmployee(name, age, height, weight, salary, dept);
		
		
		System.out.println("그만하시려면 N(또는 n), 이어하시려면 아무키나 누르세요");
		String con = sc.next();
		int[] cnt =  pc.personCount();
		if (con.toUpperCase().equals("N")) {
			employeeMenu();
		} else {
			if (cnt[1] == 10) {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가를 종료하고 사원 메뉴로 돌아갑니다.");
				employeeMenu();
			} else {
				insertEmployee();
			}
			
		}
		
	}
	
	public void printEmployee() {
		Employee[] eList = pc.printEmployee();
		
		for (int i=0; i<eList.length; i++) {
			
			System.out.println(eList[i]);
			
		}
		
		
	}
	
	
	
}
