package com.kh.example.abstractNInterface;

public abstract class SmartPhone {

	private String maker;

	public SmartPhone() {
		super();
	}
	//추상 메서드.
	//자식에서 구현.
	public abstract String printInformation();
	
	public void setMaker(String maker) {
		
		this.maker = maker;
		
	}
	
	public String getMaker() {
		
		return maker;	
	}
	
	
}
