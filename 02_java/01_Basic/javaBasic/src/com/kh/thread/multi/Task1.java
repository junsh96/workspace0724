package com.kh.thread.multi;

public class Task1 extends Thread{

	//20이하의 짝수만 출력
	@Override
	public void run() {

		for (int i=1; i<=20; i++) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
			//0.4초 동안 스레드 휴식
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	
}
