package com.kh.thread.multi;

public class Task2 extends Thread{

	//20이하의  홀수만 출력
	@Override
	public void run() {

		for (int i=1; i<=20; i++) {
			if(i % 2 == 1) {
				System.out.print(i + " ");
			}
			
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	
}
