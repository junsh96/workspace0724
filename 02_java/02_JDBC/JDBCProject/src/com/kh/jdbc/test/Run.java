package com.kh.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * JDBC를 사용하기 위해서는 자바프로젝트에 jdbc드라이버를 추가해줘야 한다.
 * 프로젝트 우클릭 -? properties -> java build path -> 라이브러리ㅏ -> add external jar
 * 
 * JDBC용 객체 
 *  - Connection : DB의 연결정보를 담고있는 객체
 *  - Statement : 연결된 dB에 sql문을 전달해서 실행하고 결과를 담아오는 객체
 *  - ResultSet : SELECT 문 실행후 조회된 결과를 담는 객체
 */
public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;//DB연결 정보 보관
		Statement stmt = null;//sql문을 전달후 실행후 결과를 받아옴
		int result = 0;
		
		System.out.println("번호 입력");
		int tno = sc.nextInt();
		System.out.println("이름 입력");	
		String tname = sc.next();
		
		//실행할 sql문(완전한 상태로 만듬, sql뒤에 세미콜론x)
		String sql = "INSERT INTO TEST VALUES(" + tno +",'"+ tname + "',SYSDATE)";
		//System.out.println("");
		
		//1. jdbc 드라이버 등록
		try {
			//Class.forName() -> 문자열로 주어진 클래스 이름을 찾아서 JVM에 로드함.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//127.0.0.1 -> 로컬
			//2. Connection생성(url, 꼐정명,비밀번호)
			conn =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##JDBC","JDBC");
			conn.setAutoCommit(false);
			
			//3. Statement 생성
			stmt = conn.createStatement();
			
			//4./5. sql문 전달 /  결과 리턴(insert,update,delete => 처리된 행의 수가 반환)
			result = stmt.executeUpdate(sql);
			//insert , update, delete => stmt.executeUpdate
			//select => stmt.executeQuery
			//6. 트랜잭션 처리
			if (result >0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//7. 다쓴 자원 반납.(생성 역순)
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
		sc.close();
		
		if(result > 0) {
			System.out.println("데이터 추가 성송");
		} else {
			System.out.println("데이터 추가 실패");
		}
	}
	
	
	//각자의 pc에 jdbc연결후 test테이블에 데이터 insert
	//select
	//select -> 결과 : ResultSet ->  데이터 추출
	
	
	
}
