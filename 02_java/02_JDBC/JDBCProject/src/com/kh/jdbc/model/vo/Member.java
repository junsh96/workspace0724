package com.kh.jdbc.model.vo;

import java.time.LocalDateTime;

/*
 * VO(Value Object)
 * DB 테이블 정보를 Java에서 사용하기 위해 담아주는 객체
 * 한명의 회원(db테이블의 한 행의 데이터)에 대한 데이터를 기록할수있는 저장용 객체
 */
public class Member {
	private int userNo;
	private String userId;
	private String userPwd;
	private String userNm;
	private String gen;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private LocalDateTime enrollDate;
	public Member() {
		super();
	}
	public Member(int userNo, String userId, String userPwd, String userNm, String gen, int age, String email,
			String phone, String address, String hobby, LocalDateTime enrollDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userNm = userNm;
		this.gen = gen;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.enrollDate = enrollDate;
	}
	public Member( String userId, String userPwd, String userNm, String gen, int age, String email,
			String phone, String address, String hobby ) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userNm = userNm;
		this.gen = gen;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
	}
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public LocalDateTime getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(LocalDateTime enrollDate) {
		this.enrollDate = enrollDate;
	}
	@Override
	public String toString() {
		return "[userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userNm=" + userNm
				+ ", gen=" + gen + ", age=" + age + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", hobby=" + hobby + ", enrollDate=" + enrollDate + "]";
	}

	
	
}
