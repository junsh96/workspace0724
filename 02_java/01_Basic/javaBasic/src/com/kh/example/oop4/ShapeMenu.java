package com.kh.example.oop4;

import java.util.Scanner;

public class ShapeMenu {

	Scanner sc = new Scanner(System.in);
	SquareController scr = new SquareController();
	TriangleController tc = new TriangleController();
	
	
	public void inputMenu() {
		System.out.println("=====도형 프로그램======");
		System.out.println("3: 삼각형\n 4: 사각형 \n5 : 종료");
		int mainMenu = sc.nextInt();
		if (mainMenu == 3) {
			triangleMenu();
		} else if(mainMenu == 4) {
			squareMenu();
		} else {
			
		}
	}
	
	public void triangleMenu() {
		System.out.println("=====삼각형=====");
		System.out.println("1. 면적계산 \n 2. 색칠 \n 3.정보보기\n 4.메인으로");
		int triMenu = sc.nextInt();
		double result;
		if (triMenu == 1) {
			System.out.println("높이와 넓이를 입력하세요.");
			double height = sc.nextInt();
			double width = sc.nextInt();
			result = tc.calcArea(height,width);
			System.out.println(result);
			triangleMenu();
		} else if (triMenu ==2) {
			System.out.println("색을 입력하세요");
			String color = sc.next();
			tc.paintColor(color);
			triangleMenu();
		} else if (triMenu ==3) {
			tc.print();
			triangleMenu();
		} else {
			inputMenu();
		}
		
		
		
	}
	
	public void squareMenu() {
		System.out.println("=====사각형=====");
		System.out.println("1. 둘레계산 \n 2. 면적계산 \n 3.색칠\n 4.정보 보기 \n 5. 메인으로");
		int sqMenu = sc.nextInt();
		double result;
		if (sqMenu == 1) {
			System.out.println("높이와 넓이를 입력하세요.");
			double height = sc.nextInt();
			double width = sc.nextInt();
			
			result = scr.calcPerimeter(height, width);
			System.out.println(result);
			squareMenu();
		} else if (sqMenu == 2) {
			System.out.println("높이와 넓이를 입력하세요.");
			double height = sc.nextInt();
			double width = sc.nextInt();
			
			
			result = scr.calcArea(height,width);
			System.out.println(result);
			squareMenu();
		} else if (sqMenu == 3) {
			System.out.println("색을 입력하세요");
			String color = sc.next();
			scr.paintColor(color);
			squareMenu();
		} else if (sqMenu == 4) {
			scr.print();
			squareMenu();
		} else {
			inputMenu();
		}
		
		
	}
	
	public void inputSize(int type, int menuNum) {
		// type = 3 / 4
		//menuNum = 1 둘레 / 2 너비 3 생상
		

			
		switch(menuNum) {
		case 1 :{
			System.out.println("높이 너비 입력");
			double height = sc.nextDouble();
			double width = sc.nextDouble();
			
			scr.calcPerimeter(height, width);
			break;
		}
		case 2:{
			System.out.println("높이 너비 입력");
			double height = sc.nextDouble();
			double width = sc.nextDouble();
			
			
			if (type == 3) {
				tc.calcArea(height,width);
				
			} else {
				scr.calcArea(height,width);
				
			}
			break;
		}
		case 3 :{
			System.out.println("색상 입력");
			String color = sc.next();
			
			if(type == 3) {
				tc.paintColor(color);
				
			} else {
				scr.paintColor(color);
			}
			break;
			
		}
			
			
		}
		
	}
	
	public void printInformation(int type) {
		
		if (type == 3) {
			tc.print();
		} else {
			scr.print();
		}
		
		
	}
	
	
}
