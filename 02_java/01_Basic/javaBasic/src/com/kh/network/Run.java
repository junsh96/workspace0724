package com.kh.network;

import java.net.InetAddress;

public class Run {

	/*
	 * 네트워크 : 여러대의 컴퓨터들이 연결되어있는 통신망
	 * IP 주소 : 네트워크상에 각 컴포터들을 식별할수있는 주소
	 * port : 컴퓨터에서 응용프로그램을 식별하기 위한 코드
	 * 
	 * 서버 - 클아이언트 연결방식
	 * 클라이언트 : 서버에 요청을 보내는 컴퓨터.
	 * 서버 : 클라이언트의 요청을 받아서 고객에게 서비스를 제공해주는 프로그램 또는 컴퓨터
	 * 
	 * 도메인 : 특정 서버에 접근하기 위한 정보(ip, port)를 사람이 읽고 기억하기 어려워서 쉽게 만든 주소
	 * 		-> 실제 도메인으로 요청시 DNS에서 IP로 변경해서 위치를 찾음
	 * 
	 *  서버에 쵸청을 보내기 위해서는 요청하고자 하는 서버의 ip, port주소를 알아야한다.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress localhost = InetAddress.getLocalHost();			
			System.out.println(localhost);
			
			System.out.println("내 pc명 : " +localhost.getHostName());
			System.out.println("내 IP주소 : " +localhost.getHostAddress());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
