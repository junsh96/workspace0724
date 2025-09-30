package com.kh.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RunException {

	//1. try - catch
	public void method1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("a/b.... a:");
		int a = sc.nextInt();
		System.out.println("a/b.... b:");
		int b = sc.nextInt();
		
		try {
			System.out.printf("%d / %d = %d",a,b,a/b);		
			System.out.println("계산완료.");
		} catch (ArithmeticException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("계산 오류.");
			
		} finally {
			sc.close();
		}
		
		
	}
	
	//2. throws : 여기서 예외를 처리하지 않고 현재 이 메서드를 호출한 곳으로 예외 처리를 위임한다.
	public void method2() throws IOException {
		//checkedException : 반드시 예외처리를 해야하는 예외들 (강제처리 불가)
		//-> 조건문을 미리 제시할수 없음.(예측 불가)
		//-> 외부 매개체와 입출력이 일어날때 발생할수 있음.
		///Scanner와 같이 입력받은 값을 코드로 가져오는 객체
		///단 문자열만 .
		BufferedReader bt = new BufferedReader(new InputStreamReader(System.in));
		
		String str = null;
		
//		try {
//			이 시점에 바로 예외를 처리해야하거나 예외를 동일하게 위임하면 된다.	
//		} catch (Exception e) {
//			
//		}
		str = bt.readLine();
		
		System.out.println(str);
	}
	
}
