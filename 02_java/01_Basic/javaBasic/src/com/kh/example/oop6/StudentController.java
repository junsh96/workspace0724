package com.kh.example.oop6;

public class StudentController {

	Student [] sArr = new Student[5];
	
	static final int CUT_LINE = 60;
	
	
	
	
	public StudentController() {
		super();
		String[] stu = {"김길동","박길동","이길동","장길동","홍길동"};
		String[] sub = {"자바","디비","화면","서버","자바"};
		int[] sco = {100,50,85,60,20};
		
		for (int i=0; i<sArr.length; i++) {
			//초기화 안 할시 에러.
			sArr[i] = new Student();
			sArr[i].setName(stu[i]);
			sArr[i].setSubject(sub[i]);
			sArr[i].setScore(sco[i]);
			
			//sArr[i] = new Student(stu[i],sub[i],sco[i]);
		}
	}

	public Student [] printStudent() {
		
		return sArr;
	}
	
	public int sumScore() {
		int sum=0;
		for (int i=0; i<sArr.length; i++) {
			
			sum += sArr[i].getScore();
			
		}
		
		return sum;
	}
	
	public double[] avgScore() {
		int sum=0;
		for (int i=0; i<sArr.length; i++) {
			
			sum += sArr[i].getScore();
			
		}
		
		int avg = sum / sArr.length;
		
		double[] result = {sum,avg};
		
		return result;
	}
	
	
}
