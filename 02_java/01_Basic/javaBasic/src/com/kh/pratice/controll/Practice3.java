package com.kh.pratice.controll;

import java.util.Scanner;

public class Practice3 {

	/*
	 *	어린이, 청소년, 성인의 구분에 따라 입장료가 다르게 부과되는 **놀이공원 요금 계산기**를 만들어보세요.
	 *	또한, 주말에는 20% 할인이 적용됩니다. 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하세요.");
		
		int age = sc.nextInt();
		System.out.println("요일을 입력하세요.");
		String day = sc.next();
		String grade = "";
		int amount = 0;
		
		if (age < 0) {
			System.out.println("나이를 잘못 입력하셨습니다.");
		} else {
			if (age <= 12) {
				amount = 5000;
				grade = "어린이";
			} else if (age > 12 && age < 19) {
				amount = 7000;
				grade = "청소년";
			} else {
				amount = 10000;
				grade = "성인";
			}
			
			switch(day) {
			case "일" :
			case "토" :
				amount = amount - (amount/100*20);
				break;
			}
			
			if (day.equals("토") || day.equals("일")) {
				System.out.printf("%s 요금입니다. (주말 할인 적용)\n",grade);
			} else {
				System.out.printf("%s 요금입니다.\n",grade);
			}
			
			System.out.printf("최종요금은 %d입니다.",amount);
		}
		
		sc.close();


	}

}
