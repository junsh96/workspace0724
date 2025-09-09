package com.kh.compara;

import java.util.Comparator;

public class scoreDescAndNameAscComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		//점수 내림차순
		int sort = o2.score = o1.score;
		
		if (sort == 0) {
			//이름 오름차순
			sort = o1.name.compareTo(o2.name);
		}
		
		return sort;
	}

	
	
}
