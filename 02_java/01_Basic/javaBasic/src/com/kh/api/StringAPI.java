package com.kh.api;

import java.util.StringTokenizer;

public class StringAPI {

	public void metohd01() {
		//1, 생성자를 통해서 문자열 생성.
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println(str1);
		System.out.println(str2);
		//String 클래스에는 이미 toString 메서드가 오버라이딩 되어있음.
		//그래서 참조변수 출력시 object 의 toString형식이 반환된다.
		
		System.out.println(str1 == (str2)); // 주소값을 비교하기 때문에 false
		
		System.out.println(str1.equals(str2)); // String 클래스에서 이미 equals가 이미 오버라이딩
		//주소값 비교가 아닌 문자열 값을 비교.
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		//String클래스에서 hashCode메서드도 이미 오버라이딩 되어있음.
		//주소값이 아닌 문자열을 가지고 해시값을 만들도록
		
		
		//해당 참조변수의 메모리값읋 기반으로한 해시값을 반환
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		
		
		//----------------------------------------
		//2. 문자열을 리터럴값으로 생성
		String str3 = "hello";
		String str4 = "hello";
		
		System.out.println(str3 == str4);
		//문자열 리터럴을 사용시 상수풀 영역에 문자열을 생성한다.
		//String pool : 동일한 문자열을 중복해서 가지지 않습니다.
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		
		str3 = "bye";
		System.out.println(System.identityHashCode(str3));
		//String 리터럴의 특성상 참조변수에 값을 변경하는 순간 기존의 문자열 메모리에 값을 변경하는게 아니라
		//상수이기 때문에 새로운 값을 String Pool에만들고 참조.
		
	}
	
	public void method02() {
		
		String str1 = "Hello World";
		
		//문자열.charAt(int) : char
		//문자열에서 전달받은 index위치를 추출.
		char ch = str1.charAt(0);
		System.out.println(ch);
		
		//문자열.contains(찾고자 하는 문자열) : boolean
		//문자열에 전달된 문자열이 포함되어있는지 확인
		System.out.println(str1.contains("ello"));
		
		//문자열.concat(String str)
		//문자열과 전달된 또다른 문자열을 하나로 합쳐 새로운 문자열 리턴
		String str2 = str1.concat("!!!");
		System.out.println(str2);
		
		//문자열.subString(시작위치, 끝위치)
		//문자열을 시작위치에서 끝위치 -1 위치까지 추출
		System.out.println(str2.substring(6));
		
		//문자열.replace(대상문자, 변경할 문자)
		//문자열에서 대상문자를 찾아서 변경할 문자로 대체한다.
		String str4 = str1.replace("l", "c");
		System.out.println(str4);
		
		//toUpperCase / toLowerCase 
		//문자열을 모두 대문자 / 소문자
		System.out.println(str2.toUpperCase());
		System.out.println(str2.toLowerCase());
		
		//문자열.trim()
		//문자열 앞뒤 공백 제거
		String str5  = "    j   a v  a";
		System.out.println(str5.trim());
		
		//문자열.toCharArray();
		//문자열을 문자배열로 변경
		char[] arr = str1.toCharArray();
		for (char c : arr) {
			System.out.println(c+ " ");
		}
	}
	
	public void method03() {
		
			String str ="java,oracle,sql,html,css,js,spring";
			
			//구분자를 기준으로 문자열을 분리.
			//방법 1. 분리된 문자열을 String 배열에 담는다.
			//split사용.
			
			String [] strArray = str.split(",");
			for (String s : strArray) {
				System.out.println(s);
			}
			
			//분리된 문자열을 다시 String으로 연결하는 법
			//String.join
			String str2 = String.join(",", strArray);
			System.out.println(str2);
		
			//방법2. 분리된 문자열은 각각 토큰으로써 관리가능.
			//StringTokenizer
			StringTokenizer stn = new StringTokenizer(str,",");
			
			System.out.println(stn.countTokens());
			System.out.println(stn.nextToken());//정해진 갯수만큼만 호출 가능. 그 이상 호출시 예외 발생.
	
			stn = new StringTokenizer(str,",");
			int size = stn.countTokens();
			for (int i=0; i>size; i++) {
				System.out.println(stn.nextToken());
			}
			
			stn.hasMoreElements(); // 남은 토큰이 있는지 체크
			
	}
	
}
