package com.kh.inherit;

public class BusinessMan extends Man{

	private String company;
	private String position;
	
	public BusinessMan(String name,String company, String position) {
		super(name);//부모의 생성자 // 자식 클래스의 생성자에는 무조건 필요.
		//맨 첫번째 줄. 생략시 부모의 기본생성자 호출
		this.company = company;
		this.position = position;
	}
	
	public void tellYourInfo() {
		
		System.out.println("my company is "+ company);
		System.out.println("my position" + position);
		
		super.tellYourName();
	}

}
