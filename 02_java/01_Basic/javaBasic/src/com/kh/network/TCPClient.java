package com.kh.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		PrintWriter pw  = null;
		//요청하고자 하는 서버의 위치를 알아야한다.
		String serverIP = "192.168.10.36";
		int port = 3000;
		
		try {
			//2. 서버로 연결 요청
			Socket socket = new Socket(serverIP, port);
			
			if(socket != null) {
				System.out.println("서버와 연결 성공");
				
				br = new BufferedReader(new InputStreamReader( socket.getInputStream()));
				
				pw = new PrintWriter(socket.getOutputStream());
				
				while(true) {
					System.out.println("서버로 보낼 내용");
					String sendMessage = sc.nextLine();
					pw.println(sendMessage);
					pw.flush();
					
					String message = br.readLine();
					
					System.out.println("서버로 부터 전달 받은 메세지 : "+  message);					
				}
				
			} 
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
			
			
		}
		
		
	}

}
