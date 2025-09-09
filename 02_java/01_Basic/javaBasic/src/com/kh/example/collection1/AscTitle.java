package com.kh.example.collection1;

import java.util.Comparator;

public class AscTitle implements Comparator{
	
	public int compare(Object o1, Object o2) {
		
		if( ((Music)o1).getTitle().equals(((Music)o2).getTitle()) ) {
			
			return ((Music)o1).getTitle().compareTo(((Music)o2).getTitle());
		} else {
			
			return ((Music)o1).getSinger().compareTo(((Music)o2).getSinger());
		}
		
		
	}
	
}
