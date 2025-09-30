package com.kh.inherit;

public class Desktop extends Product{

	private boolean allinOne;

	public Desktop() {
		super();
	}

	public Desktop(String pName, int price, String brand, boolean allinOne) {
		super(pName, price, brand);
		this.allinOne = allinOne;
	}

	public boolean isAllinOne() {
		return allinOne;
	}

	public void setAllinOne(boolean allinOne) {
		this.allinOne = allinOne;
	}
	
	public String inform() {
		
		String result = super.inform() + "/ 올인원 : "+ allinOne;
		
		return result;
	}
	
}
