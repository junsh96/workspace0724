package com.kh.loop;

public class Continue {

	/*
	 * continue : 반복문 안에 기술되는 구문
	 * 코드 실행시 그 뒤에 코드를 실행하지 않고 곧바로 다시 반복문 상단으로 진행 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1부터 50까지의 수중 5의 배수만 출력
		
		for(int i=1; i<51; i++) {
			if (i % 5 !=0) {
				continue;
			}
			System.out.print(i+" ");
		}

	}

}
