package com.kh.operator;

public class Operator2 {

	/*
	 * 증감 연산자
	 * ++ : 변수에 담긴 값을 1증감 시켜주는 연산자
	 * -- : 변수에 담긴 값을 1 감소시켜주는 연산자 
	 * 
	 * (증감연산) 변수 : 전위연산 -> 선증감 후처리
	 * 변수(증감연산) : 후위 연산 -> 선처리 후증감
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		System.out.println(num++); //0 (1)
		System.out.println(++num);//2
		System.out.println(num--);//2 (1)
		System.out.println(++num);//2
		System.out.println(++num);//3
		System.out.println(num++);//3(4)
		System.out.println(num--);//4 (3)
		System.out.println(--num);//2
		System.out.println(--num);//1
		

	}

}
