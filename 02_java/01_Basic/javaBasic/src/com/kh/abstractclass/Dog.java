package com.kh.abstractclass;

public class Dog extends Animal{

	@Override
	public void speak() {
		
		System.out.println("멍멍!");
		
	}
	
	@Override
	public void move() {
		System.out.println("강아지가가 움직입니다.");
	}
	
	
	
}
