package com.kh.compara;

import java.util.Comparator;

public class NameAscComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);//문자열 비교 (가나다 / 알파벳)
	}

	
	
}
