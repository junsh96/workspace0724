package com.kh.inherit;


public class Product {

	private String pName;
	private int price;
	private String brand;
	
	
	public Product() {
		super();
	}


	public Product(String pName, int price, String brand) {
		super();
		this.pName = pName;
		this.price = price;
		this.brand = brand;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	//오버라이딩
	//부모 클래스에 있는 메서드를 자식 클래스에서 내용만 재정의 하는것.
	public String inform() {
		
		String result = "상품명 : {"+pName+"} 가격 : {"+price+"} 브랜드 : {"+brand+"}"; 
		
		return result;
	}
	
	
	
	
}
