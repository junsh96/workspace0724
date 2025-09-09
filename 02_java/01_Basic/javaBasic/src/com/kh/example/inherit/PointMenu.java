package com.kh.example.inherit;

import java.util.Scanner;

public class PointMenu {

	Scanner sc = new Scanner(System.in);
	
	CircleController cc = new CircleController();
	
	RectangleController rc = new RectangleController();
	//메인 메뉴
	public void mainMenu() {
		System.out.println("=====메인 메뉴====");
		System.out.println("1. 원");
		System.out.println("2. 사각형");
		System.out.println("9. 종료");
		int mainNo = sc.nextInt();
		
		System.out.print("메뉴번호 : "+mainNo);
		
		
		if (mainNo == 1) {
			
			circleMenu();
			
		} else if (mainNo == 2) {
			
			rectangleMenu();
			
		} else if (mainNo == 9) {
			
			System.out.println("프로그램이 종료되었습니다.");
			
		} else {
			
			System.out.println("잘못입력하셨습니다.");
			mainMenu();
			
		}
	}
	
	//원메뉴
	public void circleMenu() {
		System.out.println("====원 메뉴====");
		System.out.println("1. 둘레");
		System.out.println("2. 넓이");
		System.out.println("3. 메인");
		int cirNo = sc.nextInt();
		
		System.out.print("메뉴번호 : "+cirNo);
		
		if (cirNo == 1) {
			
			calcCircum();
			
		} else if(cirNo == 2) {
			
			calcCircleArea();
			
		} else if (cirNo == 3) {
			
			mainMenu();
			
		} else {
			
			System.out.println("잘못입력하셨습니다.");
			circleMenu();
			
		}
	}
	//사각형 메뉴
	public void rectangleMenu() {
		System.out.println("====사각형 메뉴====");
		System.out.println("1. 둘레");
		System.out.println("2. 넓이");
		System.out.println("3. 메인으로");
		
		int recNo = sc.nextInt();
		
		System.out.print("메뉴번호 : "+recNo);
		
		if (recNo == 1) {
			
			calcPerimeter();
			
		} else if (recNo ==2) {
			
			calcRectArea();
			
		} else if (recNo ==3) {
			
			mainMenu();
			
		} else {
			
			System.out.println("잘못입력하셨습니다.");
			rectangleMenu();
			
		}
	}
	//원 둘레
	public void calcCircum() {
		//좌표
		System.out.print("x좌표 : ");
		int x = sc.nextInt();

		System.out.print("y좌표 : ");
		int y = sc.nextInt();

		
		//반지름
		System.out.println("반지름 : ");
		int radius = sc.nextInt();

		
		String result = cc.calcCircum(x, y, radius);
		System.out.println(result);
		
		mainMenu();
		
	}
	//원 넓이
	public void calcCircleArea() {
		//좌표
		System.out.print("x좌표 : ");
		int x = sc.nextInt();

		System.out.print("y좌표 : ");
		int y = sc.nextInt();

		
		//반지름
		System.out.print("반지름 : ");
		int radius = sc.nextInt();

		
		String result = cc.calcArea(x, y, radius);
		System.out.println(result);
		
		
		mainMenu();
	}
	
	//사각형 둘레
	public void calcPerimeter() {
		//좌표
		System.out.print("x좌표 : ");
		int x = sc.nextInt();

		
		System.out.print("y좌표 : ");
		int y = sc.nextInt();

		
		System.out.print("너비 : ");
		int width = sc.nextInt();

		
		System.out.print("높이 : ");
		int height = sc.nextInt();

		
		String result = rc.calcPerimeter(x, y, height, width);
		
		System.out.println(result);
		
		mainMenu();
		
	}
	
	//사각형 넓이
	public void calcRectArea() {
		//좌표
		System.out.print("x좌표 : ");
		int x = sc.nextInt();

		
		System.out.print("y좌표 : ");
		int y = sc.nextInt();

		
		System.out.print("너비 : ");
		int width = sc.nextInt();

		
		System.out.print("높이 : ");
		int height = sc.nextInt();

		
		String result = rc.calcArea(x, y, height, width);
		
		System.out.println(result);
		
		mainMenu();
	}
	
	
}
