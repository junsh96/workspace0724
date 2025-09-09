package com.kh.thread.runable;

//스레드를 만드는 방법 1. Runnable 인터페이스를 구현한다.
//run에 스래드에서 실행하고자 하는 코드를 기술
public class MyRunable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int n1 = 20;
		int n2 = 30;
		//현재 실행중인 스레드 정보
		String name = Thread.currentThread().getName();
		System.out.println(name+ " : " + (n1 + n2));
		
	}

	
	
}
