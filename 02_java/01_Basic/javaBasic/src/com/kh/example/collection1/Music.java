package com.kh.example.collection1;

import java.util.Objects;

import com.kh.collection.list.Human;

public class Music {

	private String title;
	private String singer;
	public Music() {
		super();
	}
	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(title,singer); 
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Music) {
			Music m = (Music)obj;
			return this.title.equals(m.getTitle()) && this.singer.equals(m.getSinger());
		}
		return super.equals(obj);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "title : "+title + " singer : " + singer;
	}
	
	
	
	
	
	
	
}
