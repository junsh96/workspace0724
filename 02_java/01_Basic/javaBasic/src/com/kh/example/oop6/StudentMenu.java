package com.kh.example.oop6;

public class StudentMenu {
	StudentController ssm = new StudentController();

	public StudentMenu() {
		super();
		Student [] sArr = ssm.printStudent();
		
		double[] avg = ssm.avgScore();
		System.out.println("=====학생 정보 출력=============");
		
		
		for (int i=0; i<sArr.length; i++) {
			String aName = sArr[i].getName();
			String aSub = sArr[i].getSubject();
			int aSco = sArr[i].getScore();
			
			System.out.printf("이름 : %s / 과목 : %s / 점수 : %d \n",aName,aSub,aSco);
			
		}
		
		System.out.println("===========학생 성적 출력===============");
		
		System.out.println("학생 점수 합계 : " + avg[0]);
		System.out.println("학생 점수 평균 : " + avg[1]);
		
		System.out.println("==========성적 결과 출력==============");
		
		for (int i=0; i<sArr.length; i++) {
			
			String aName = sArr[i].getName();
			int aSco = sArr[i].getScore();
			
			if (aSco < ssm.CUT_LINE) {
				System.out.printf("%s 학생은 재시험 대상입니다.\n",aName);
			} else {
				System.out.printf("%s 학생은 통과입니다.\n",aName);
			}
			
		}
		
		
	}
	
	
}
