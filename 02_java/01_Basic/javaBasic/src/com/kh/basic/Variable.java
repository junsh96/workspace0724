package com.kh.basic;

public class Variable {
	/*
	 * 변수 : 값을 기록하고 사용하기위한 메모리 공간 
	 * [표현식] 
	 * 자료형 변수이름;
	 * 
	 * 자료형 : 변수가 사용할 메모리 크기에 따라서 지정 
	 * 변수 이름 : 변수를 식별하기 위해 붙여주는 이름
	 */
	public static void main(String[] args) {
		//정수형 변수 num 선언
		int num;
		//정수형 변수 num에 10이라는 값을 대입
		num = 10;
		System.out.println(num);
		//참과 거짓을 표현하는 자료형으로 isTrue 라는 이름의 변수 선언
		boolean isTrue = false;
		System.out.println(isTrue);
		
		//실수형(소수점 6자리까지 사용) 자료형으로 num2 선언
		float num2;
		num2 = 3.14159265358979323846f;
		System.out.printf("%.6f",num2);
		//-------------------------------------------
		
		//원시타입 : 가장 기본적인 데이터 타입, 값 자체를 저장하며 추가적인 속성이 없다.
		
		/*
		 * 정수 자료형
		 * 
		 *  byte(1) short(2) int(4) long(8)
		 *  모두 정수를 저장하는 자료형, 각 자료형마다 저장할수있는 수의 범위가 다름.
		 *  
		 *  정수 리터럴의 기본값은 int
		 *  byte, short은 범위내에 있을 경우 자동 형변환
		 *  
		 */
		int in =10;
		byte by = 10;
		short sh = 10;
		long lo = 10;
		System.out.println("정수자료형");
		System.out.printf("%d %d %d %d",in,by,sh,lo);
		/*
		 * 실수 자료형
		 * float(4) double(8)
		 * 실수를 저장하는 자료형 float보다 double이 더 정밀하게 표현
		 *  
		 */
		float fl = 4.24f;
		double dou = 4.24;
		System.out.println("실수자료형");
		
		System.out.println(fl+","+dou);
		
		/*
		 * 문자 자료형
		 * char(2)
		 * 문자 하나를 담을수 있는 자료형 ''
		 * 자바는 2바이트 유니코드를 사용
		 */
		
		char ch1 = '전'; // 저장될때 2바이트의 유니코드로.
		char ch2 = '수';
		char ch3 = '환';
		System.out.println("문자자료형");
		System.out.println(""+ch1+ch2+ch3); //기본적으로 char은 연산시 int로 변경됨
		
		System.out.println(ch1);
		
		/*
		 * 논리 자료형
		 * boolean(1)
		 * true/ false를 저장하는 자료형 
		 */
		
		boolean b1 = 10 > 5;
		boolean b2 = 20 == 10;
		System.out.println("논리 자료형");
		System.out.println(b1);
		System.out.println(b2);
		
		/*
		 * 문자열
		 * String
		 * 문자열 같은 경우 할당할 메모리크기가 가변적 이므로 원시타입이 아닌 객체 타입으로 변수를 만들어 사용한다.
		 * 
		 * 원래 객체를 만드는 방식
		 * String 변수명 = new 클래스명(초기값);
		 * 
		 * 문자열은 특별한 객체로 원시타입과 동일하게 사용가능.
		 */
		
		String str1 = "안녕하세요.";
		System.out.println(str1);
		
		String str2;
		str2 = "??";
		str2 = "전수환입니다.";
		str2 = null; //String 변수는 참조변수이기때문에 기본값이 null이고 빈값을 표현하기 위해 null을 대입할수있다.
		
		/*
		 * 이스케이프 시퀀스
		 * 문자열내에서 탭, 백슬러시, 작은 따옴표등을 사용하기 위한 방식
		 * 
		 * 
		 * 
		 */
		//탭문자 \t
		//가로로 일정간격을 띄운다
		System.out.println("이름\t나이\t주소");
		
		// 백슬래시 \\
		// 문자 자체로 출력
		System.out.println("경로 : C:\\devtool\\jdk-17");
		
		// \'    \"
		// 문자형에서 '을 그대로 쓰면 구문 오류
		System.out.println("오늘은 \"금요일\"입니다.");
		System.out.println('\'');
		
		// \n
		//개행
		System.out.println("오늘은 \n금요일입니다.");
		
		/*
		 * 상수
		 * 변하지 않는 값
		 * 프로그래밍 -> 한번만 쓸수 있는 메모리
		 * 
		 * [표현법]
		 * final 자료형 변수 이름;
		 * 
		 * 상수의 변수명은 모두 대문자로 짓는 것이 일반적이다.
		 * 대문자로 작성하되 스네이크 케이스를 사용.
		 */
		
		final int MY_AGE;
		MY_AGE = 300;
		// 값을 한번 초기화하면 더이상 선언 불가.
		
		/*
		 * 프로그래밍에서 이름 짓는 방식
		 * 카멜 케이스
		 * 단어를 나열하며 이름을 짓되 두번째 단어는 첫글자를 대문자로.
		 * ex)메서드,변수명 userName
		 * 
		 * 파스칼케이스
		 * 카멜 케이스에서 첫 글자도 대문자로.
		 * ex)클래스명 UserName
		 * 
		 *  
		 *  스네이크 케이스
		 *  문자와 문자사이를 언더바를 통해 이어주는것.
		 *  ex)파이썬에서 주로 사용 user_name
		 *  
		 *  대문자 스네이크 케이스
		 *  스네이크케이스 + 모두 대문자
		 *  ex)상수명
		 *  
		 *  케밥 케이스
		 *  단어를 소문자로 작성하되 문자와 문자사이를 하이픈으로 이어주는것.
		 *  ex)html 속성,url,설정파일. user-name
		 */
		
		
		
		
		
		
		
		
		
		
		
	}

}
