package com.kh.object.ex2;

public class BankAccount {
	
	int balance = 0;
	
	
	/**
	 * 기본 생성자  : 매개 변수가 없는 생성자
	 * - 생성자를 개발자가 정의하지 않으면 컴파일러가 자동으로 생성
	 * - 단 하나라도 정의할경우 기본 생성자가 생성되지 않음
	 * @param amount
	 */
	
	
	void deposit(int amount) {
		balance += amount;
	}
	
	void withdraw(int amount) {
		balance -= amount;
	}
	
	void checkMyBalance() {
		System.out.println("잔액  "+ balance);
	}
	
	//계좌 이체
	//내 계좌에서 amount금액을 target계좌로 입금
	void transfer(BankAccount target, int amount) {
		balance += amount;
		target.balance -=1000;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
