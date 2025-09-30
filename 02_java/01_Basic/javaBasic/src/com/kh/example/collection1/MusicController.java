package com.kh.example.collection1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MusicController {

	List<Music> list = new ArrayList<>();
	
	public int addList(Music music) {
		int result = 0;
		try {
			list.add(music);
			result = 1;
		} catch (Exception e) {
			// TODO: handle exception
			result = 0;
		} finally {
			
			return result;
		}
		
	}
	
	public int addAtZero(Music music)  {
		int result = 0;
		try {
			list.add(0,music);
			result = 1;
		} catch (Exception e) {
			// TODO: handle exception
			result=0;
		} 
		
		return result;
	}
	
	public List<Music> printAll() {
		
		return list;
	}
	
	public Music searchMusic(String title) {
		Music searchM = new Music();
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				searchM = list.get(i);
			}
		}
		
		return searchM;
		
	}
	
	public Music removeMusic(String title) {
		
		Music searchM = new Music();
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				searchM = list.get(i);
				list.remove(i);
			}
		}
		
		return searchM;
	}
	
	public Music setMusic(String title, Music music) {
		Music oldM = new Music();
		
		for (int i=0; i<list.size(); i++) {
			
			if(list.get(i).getTitle().equals(title)) {
				oldM = list.get(i);
				list.set(i, music);
				
			}
			
		}
		
		return oldM;
	}
	
	public int ascTitle() {
		int result = 0;
		
		try {
			AscTitle as = new AscTitle();
		
			as.compare(as, as);
			
			result = 1;
		} catch (Exception e) {
			// TODO: handle exception
			
			result = 0;
		}
		
		return result;
	}
	
	public int descSinger() {
		int result = 0;
		
		try {
			
			result = 1;
		} catch (Exception e) {
			// TODO: handle exception
			
			result = 0;
		}
		
		return result;
	}
	
}
