package com.kh.compara;

public class Student implements Comparable<Student> {
    String name;
    int score;
    int age;
    
    Student(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    //정렬 기준 : 클래스가 책임지고 언제나 일관되게 정렬을 함.
    @Override
    public int compareTo(Student other) {
        // this가 작으면 음수, 같으면 0, 크면 양수
    	
    	int sort = this.score - other.score;//점수 오름차순
    	
    	if (sort == 0) { // 동일점수일경우 
    		sort = this.name.compareTo(other.name); //이름 오름차순
    	}
    	
    	if (sort ==0 ) {//이름 까지 동일할 경우 나이 오름차순
			sort = this.age - other.age;
		}
    	
    	return sort;
    	
        //return this.score - other.score;
    }

    @Override
    public String toString() {
        return name + " (" +age +") : "+ score;
    }
}

