package com.kh.example.gearrent;

import java.util.Set;

public class Laptop extends Device {

	public Laptop(String id, String name, String category, Set<String> tags) {
		super(id, name, category, tags);
	}

	public int getBorrowLimitDays() {
		
		return 14;
	}
	
	public int calcLateFee(int d) {
		
		return 500 * d;
	}
	
	
}
