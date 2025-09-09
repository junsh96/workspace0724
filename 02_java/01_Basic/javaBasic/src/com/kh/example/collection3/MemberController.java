package com.kh.example.collection3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class MemberController {

	HashMap<String, Member> map = new HashMap<>();
	
	public boolean joinMembership(String id, Member m) {
		
		boolean result = false;
		
		if (!map.containsKey(id)) {
			map.put(id, m);
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}
	
	public String logIn(String id, String password) {
		String name = "";
		if (map.containsKey(id) && map.get(id).getPassword().equals(password)) {
			
			name = map.get(id).getName();
		
			return name;
		} else {
			return null;
			
		}
		
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		boolean result = false;
		
		if (map.get(id).getPassword().equals(oldPw)) {
			
			map.get(id).setPassword(newPw);
			
			result = true;
		} 
		
		return result;
		
	}
	
	public void changeName(String id, String newName) {
		
		map.get(id).setName(newName);
		
	}
	
	public TreeMap<String, String> sameName(String name) {
		TreeMap<String, String> result = new TreeMap<>();
		
		for (String key : map.keySet()) {
			
			if (map.get(key).getName().equals(name)) {
				result.put(key, map.get(key).getName());
			}
			
		}
		
		return result;
		
	}
	
}
