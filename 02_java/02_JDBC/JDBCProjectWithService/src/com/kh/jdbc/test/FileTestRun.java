package com.kh.jdbc.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class FileTestRun {

	public static void main(String[] args) {
		// Properties
		// Properties 클래스는 map계열의 컬랙션.
		// 특히 외부 파일 (.Properties / xml)을 통해 데이터를 쉽게 관리하고 불러올 수 있음
		// db연결 정보, 프로그램 설정 정보. sql쿼리문등을 코드와 분리해서 관리 할때 주로 사용.
		
		//파일로 출력.
		/*
		Properties prop = new Properties();
		prop.setProperty("C", "insert");
		prop.setProperty("R", "select");
		prop.setProperty("U", "update");
		prop.setProperty("D", "delete");
		
		try {
			//prop.store -> .properties파일로 객체를 저장하겠다.
			//.properties파일 -> 단순 텍스트 파일(key/value)
			prop.store(new FileOutputStream("resources/driver,properties"), "properties test");
			//prop.storeToXML .xml파일로 객체의 정보를 저장하겠다.
			//xml -> xml형식 문서(태그구조)
			// -> dtd : xml 문서의 구조와 규칙을 정의한 문서
			prop.storeToXML(new FileOutputStream("resources/query.xml"), "");
		} catch (Exception e) {
			// TODO: handle exception
		}
	*/
		
		//파일로 부터 값을 읽어오기
		Properties prop = new Properties();
		
		Properties propXml = new Properties();
		
		try {
			prop.load(new FileInputStream("resources/driver,properties"));
			
			System.out.println(prop.getProperty("driver"));
			System.out.println(prop.getProperty("url"));
			System.out.println(prop.getProperty("userName"));
			System.out.println(prop.getProperty("password"));
			
			propXml.loadFromXML(new FileInputStream("resources/query.xml"));
			System.out.println(propXml.getProperty("C"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
