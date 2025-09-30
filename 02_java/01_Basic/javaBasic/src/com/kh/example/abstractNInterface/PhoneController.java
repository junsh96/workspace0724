package com.kh.example.abstractNInterface;

public class PhoneController {

	String[] result = new String[2];
	
	
	public String[] method() {
		
		Phone[] phone = new Phone[2];
		
		GalaxyNote9 gl = new GalaxyNote9();
		V40 v40 = new V40();
		phone[0] = gl;
		phone[1] = v40;
		String str = "";
		for (int i=0; i<phone.length; i++) {
			
			if (phone[i] instanceof SmartPhone) {
				str = ((SmartPhone)phone[i]).printInformation();
			}
			
//			if (phone[i] instanceof GalaxyNote9) {
//				str = ((GalaxyNote9)phone[i]).printInformation();
//			} else {
//				str = ((V40)phone[i]).printInformation();
//			}
		
			
			result[i] = str;
		}
		
		return result;
	}
	
}
