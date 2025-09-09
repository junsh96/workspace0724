package com.kh.example.inherit2;

public class PersonControll {

	Student[] s = new Student[3];
	Employee[] e = new Employee[10];
	
	public int[] personCount() {
		
		int[] cnt = new int[2];
		int sCnt = 0;
		int eCnt = 0;
		for (int i = 0; i< s.length; i++) {
			
			if (s[i] == null) {
				break;
			} else {
				sCnt++;
			}
			
		}
		
		for (int i=0; i<e.length; i++) {
			
			if (e[i] == null) {
				break;
			} else {
				eCnt++;
			}
			
		}
		
		
		cnt[0] = sCnt;
		cnt[1] = eCnt;
		
		return cnt;
	}
	
	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		
		for (int i=0; i<s.length; i++) {
			if (s[i] == null) {
			
				s[i] = new Student();
				
				
				s[i].setName(name);
				s[i].setAge(age);
				s[i].setHeight(height);
				s[i].setWeight(weight);
				s[i].setGrade(grade);
				s[i].setMajor(major);
				
				break;
			}
			
			
		}
		
	}
	
	public Student[] printStudent() {
		
		return s;
	}
	
	
	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		for (int i=0; i<e.length; i++) {
			
			if (e[i] == null) {
				
				e[i] = new Employee();
				e[i].setName(name);
				e[i].setAge(age);
				e[i].setHeight(height);
				e[i].setWeight(weight);
				e[i].setSalary(salary);
				e[i].setDept(dept);
				
				break;
				
			}
			
		}
		
	}
	
	public Employee[] printEmployee() {
		
		return e;
	}
	
}
