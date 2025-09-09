package com.kh.example.collection1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicView {

	Scanner sc = new Scanner(System.in);
	
	MusicController mc = new MusicController();
	
	public void mainMenu() {
		int mainNo =1;
		
		while(mainNo > 0) {
			System.out.println("====메인 메뉴====");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬");
			System.out.println("9. 종료");
			
			mainNo = sc.nextInt();
			
			switch(mainNo) {
			case 1 :
				addList();
				break;
			case 2 :
				addAtZero();
				break;
			case 3 :
				printAll();
				break;
			case 4 : 
				searchMusic();
				break;
			case 5 :
				removeMusic();
				break;
			case 6 : 
				setMusic();
				break;
			case 7 : 
				ascTitle();
				break;
			case 8 : 
				descSinger();
				break;
			case 9 : 
				System.out.println("프로그램이 종료 됩니다.");
				mainNo = 0;
				break;
			default : 
				System.out.println("잘못입력하셨습니다.");
				break;
				
				}
			
			}
			
			
	}
	
	public void addList() {
		
		Music music = new Music();
		System.out.println("가수를 입력해주세요 : ");
		music.setSinger(sc.next());
		System.out.println("노래제목을 입력해주세요 : ");
		music.setTitle(sc.next());
		
		int result = mc.addList(music);
		if (result == 1) {
			System.out.println("저장되었습니다.");
		} else {
			System.out.println("저장에 실패하였습니다. 데이터를 확인해주세요.");
		}
	}
	
	public void addAtZero() {
		Music music = new Music();
		System.out.println("가수를 입력해주세요 : ");
		music.setSinger(sc.next());
		System.out.println("노래제목을 입력해주세요 : ");
		music.setTitle(sc.next());
		
		int result = mc.addAtZero(music);
		if (result == 1) {
			System.out.println("저장되었습니다.");
		} else {
			System.out.println("저장에 실패하였습니다. 데이터를 확인해주세요.");
		}
		
	}
	
	public void printAll() {
		
		List<Music> musicList = new ArrayList<>();
		
		musicList = mc.printAll();
		
		for (int i=0; i<musicList.size(); i++) {
			System.out.println(musicList.get(i));
		}
		
	}
	
	public void searchMusic() {
		System.out.println("제목을 입력해주세요");
		String title = sc.next();
		
		Music result = new Music();
		result = mc.searchMusic(title);
		if (result.getTitle() != null) {
			System.out.println(result);
			
		} else {
			System.out.println("검색한 곡이 없습니다.");
		}
		
		
	}
	
	public void removeMusic() {
		System.out.println("삭제할 제목을 입력해주세요");
		String title = sc.next();
		
		Music result = new Music();
		result = mc.removeMusic(title);
		if (result.getTitle() != null) {
			System.out.println("삭제된 음악 : "+result);
			
		} else {
			System.out.println("검색한 곡이 없습니다.");
		}
		
		
		
	}
	
	public void setMusic() {
		System.out.println("수정할 음악의 제목을 입력해주세요.");
		String title = sc.next();
		
		Music newMusic = new Music();
		System.out.println("가수를 입력해주세요.");
		newMusic.setSinger(sc.next());
		System.out.println("제목을 입력해주세요.");
		newMusic.setTitle(sc.next());
		
		Music oldM = new Music();
		oldM = mc.setMusic(title, newMusic);
		
		if (oldM.getTitle() != null) {
			System.out.println("수정 전 정보 : "+ oldM);
			
		} else {
			System.out.println("수정할 곡이 없습니다.");
		}
		
	}
	
	public void ascTitle() {
	
		mc.ascTitle();
	}
	
	public void descSinger() {
		
		mc.descSinger();
	}
	
	
}
