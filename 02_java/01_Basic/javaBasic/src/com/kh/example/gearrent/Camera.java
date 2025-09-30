package com.kh.example.gearrent;

import java.util.Set;

public class Camera extends Device {
	
	

	public Camera(String id, String name, String category, Set<String> tags) {
		super(id, name, category, tags);
		
		
	}

	public int getBorrowLimitDays() {
		
		
		return 7;
	}
	
	public int calcLateFee(int d) {
		System.out.println("?????");
		
		return 300 * d;
	}
	
}
