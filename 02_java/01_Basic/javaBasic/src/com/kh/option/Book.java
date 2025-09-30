package com.kh.option;

public class Book {

	/**
	 * 접근 제한자 : 클래스, 필드, 메서드등 구성 요소의 접근 범위를 제한 하는 키워드
	 * 			불필요하거나 위험한 접근을 막아 데이터의 무결성과 보안 유지
	 * public > protected > default > private
	 * 
	 * public  : 어디서든 접근 가능
	 * protected : 같은 클래스
	 * default : 같은 패키지
	 * private : 해당 클래스에서만
	 */
	private String title;
	private String genre;
	private String author;
	private int maxPage;
	public Book(String title, String genre, String author, int maxPage) {
		super();
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.maxPage = maxPage;
	}


}
