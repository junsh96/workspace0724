package com.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kh.jdbc.model.vo.Member;

/*
 * DAo(Data Access Object) :db에 직접적으로 접근해서 사용자의 요청에 맞게 sql문을 실행후 결과를 반환
 */
public class MemberDao {

	public int insertMember(Member m) {
		//JDBC사용
		/*
		 * jdbc사용 순서
		 * 1. JDBC 드라이버 등록 : JDBC내의 다양한 인터페이스가 특정 DBMS가 제공하는 클래스에 의해서 구현됨(사용할수 있도록 등ㄹ고)
		 * 2. Connection 생성 : 연결하고자 하는 DB정보를 입력해서 해당 db와 연결할수있는 객체 생성.
		 * 3. [Prepared]Statement : Connection객체를 이용해서 생성, Sql문을 실행하고 결과를 받아주는 객체
		 * 4. sql문을 전달해서 실행 : Statement 객체를 이용해서 sql문을 실행
		 * 5. 결과 받기 -> select문 실행. -> ResultSet객체(조회된 결과) / update,insert,delete ->  처리된 행의 수가 반환
		 * 6-1. ResultSet 객체에 담겨있는 데이터를 하나씩 추출해서 자바 메모리에 담아 사용.
		 * 6-2. 트랜잭션 처리(성공시 커밋/ 실패시 롤백)
		 * 7. 다 사용한 객체를 반납(close)
		 */
		
		//insertMember -> insert -> 처리된 행의 수
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//sql문
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL,?,?,?,?,?,?,?,?,?,SYSDATE)";
		
		try {
			getClass().forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##KH","KH");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserNm());
			pstmt.setString(4, m.getGen());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			result = pstmt.executeUpdate();
			conn.setAutoCommit(false);
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("????");
		}finally {
			
			try {
				pstmt.close();
				conn.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	public ArrayList<Member> selectMemberLsit() {
		
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM MEMBER";
		try {
			getClass().forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##KH","KH");
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserNm(rset.getString("USER_NAME"));
				m.setGen(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getTimestamp("ENROLL_DATE").toLocalDateTime());
				
				list.add(m);
			}
			
			if (list.size() >0) {
				
			} else {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();

				conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		
		return list;
	}
	
	//Member 객체 m을 통해서 update sql을 전달
	public int updateMember(Member m) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "UPDATE MEMBER SET EMAIL = ? , PHONE = ?, ADDRESS = ?, HOBBY = ? WHERE USER_ID = ?";
		
		try {
			getClass().forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##KH","KH");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getHobby());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
			conn.setAutoCommit(false);
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				pstmt.close();
				conn.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	public int deleteMember(Member m) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?";
		
		
		try {
			getClass().forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##KH","KH");
			
			pstmt = conn.prepareStatement(sql);
			

			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			
			result = pstmt.executeUpdate();
			conn.setAutoCommit(false);
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				pstmt.close();
				conn.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
}
