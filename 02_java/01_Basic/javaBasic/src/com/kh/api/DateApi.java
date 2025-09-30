package com.kh.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateApi {

	public void method() {
		Date date1 = new Date(); // 매개변수 없는 생성자 생성시 코드 실행시점의 시간이 생성
		
		System.out.println(date1);
		
		//원하는 날짜 
		//1. 생성자를 통해서 생성
		// 년 : (생성년도 - 1900),월(생성월 - 1), 일
		Date date2 = new Date(2026- 1900,3 - 1,3); //2026년 3월 3일
		
		//2. 기본 생성자로 생성후 setter
		date1.setYear(2026-1900);
		date1.setMonth(2);
		date1.setDate(3);
		
		//LocalDateTime
		//java8에 도입된 클래스
		//날짜와 시간을 같이 표현하는 객체
		//시차 / 타임존을 고려x -> 순수하게 지금 내 시간을 다룸
		
		//1. 현재 날짜와 시간
		LocalDateTime now = LocalDateTime.now();
		
		//2.특정 날짜 시간
		LocalDateTime date3 = LocalDateTime.of(2026,3,3,0,0,0);
		
		//3.날짜 연산
		date3.plusDays(10);//date3기준 10일뒤
		
		date3.minusHours(5);//date3기준 5시간전
		
		//4.날짜와 시간 분린
		date3.toLocalDate();//날짜
		date3.toLocalTime();//시간
		
		//5.포맷 변경
		DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
		
		date3.format(fomatter);
		
	}
	
}
