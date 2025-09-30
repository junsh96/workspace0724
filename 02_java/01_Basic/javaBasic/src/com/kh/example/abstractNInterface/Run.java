package com.kh.example.abstractNInterface;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneController pc = new PhoneController();
		
		String[] result = pc.method();
		
		for (int i=0; i<result.length; i++) {
			
			System.out.println(result[i]);
			System.out.println("");
			
		}
	}

}
