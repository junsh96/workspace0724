package com.kh.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Run2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//3. PreparedStatement 객체 사용 -> sql문 형태를 먼저 정의하고 각 데이터는 추후 적용
		Scanner sc = new Scanner(System.in);
		Connection conn = null;//DB연결 정보 보관
		PreparedStatement pstmt = null;//sql문을 전달후 실행후 결과를 받아옴
		int result = 0;
		
		System.out.println("수정할 번호를 입력하세요. : ");
		int tno =sc.nextInt();
		
		System.out.println("새로운 이름을 입력하세요.");
		String name = sc.next();
		
		System.out.println("새로운 날짜를 입력하세요.(YYYY-MM-DD)");
		String newDate = sc.next();
		
		String sql = "update TEST set TNAME = ?, TDATE=TO_DATE(?,'YYYY-MM-DD') where TNO =?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//127.0.0.1 -> 로컬
			//2. Connection생성(url, 꼐정명,비밀번호)
			conn =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##JDBC","JDBC");
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, newDate);
			pstmt.setInt(3, tno);
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
				sc.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		if(result > 0) {
			System.out.println(result+"개의 행이 수정되었습니다.");
		} else {
			System.out.println("아이디를 확인하세요. 수정된 행이 없습니다.");
		}
	}

}
