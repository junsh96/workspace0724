package com.kh.compara;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *  -Comparable : 객체 스스로 기본 정렬 기준을 제공하게 한다.
 *  -Comparator : 필요할때 외부에서 정렬 기준을 제공한다.
 */

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Student> list = new ArrayList<>();

		list.add(new Student("test1", 80, 18));
		list.add(new Student("test2", 90, 15));
		list.add(new Student("test3", 70, 17));
		list.add(new Student("test3", 70, 16));
		list.add(new Student("test5", 100, 19));

		// Comparable : 학생의 정의된 기준으로 정렬(Student 클래스의 CompareTo 기준)
		Collections.sort(list);

		System.out.println(list);

		// comparator : 이름 오름차순
		Collections.sort(list, new NameAscComparator());

		// comparator : 이름, 점수 복합기준 정렬
		Collections.sort(list, new scoreDescAndNameAscComparator());
	}

}
