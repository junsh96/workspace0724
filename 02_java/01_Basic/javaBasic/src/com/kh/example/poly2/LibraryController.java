package com.kh.example.poly2;

public class LibraryController {

	Member mem = new Member();
	
	Book[] bList = new Book[5];
	
	{
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
		
	}
	
	public void insertMember(Member mem) {
		
		this.mem = new Member(mem.getName(),mem.getAge(),mem.getGender());
		
	}
	
	public Member myInfo() {
		
		return mem;
	}
	
	public Book[] selectAll() {
		
		return bList;
	}
	
	public Book[] serachBook(String keyword) {
		
		int newCnt = 0;
		int newSize = 0;
		for (int i=0; i<bList.length; i++) {
			if (bList[i].getTitle().contains(keyword)) {
				newSize++;
			}
			
		}
		
		Book[] newList = new Book[newSize];
	
		for (int i=0; i<bList.length; i++) {
			
			if (bList[i].getTitle().contains(keyword)) {
				newList[newCnt] = bList[i];
				newCnt++;
			}
			
		}
		
		return newList;
		
	}
	
	public int rentBook(int index) {
		int result = 0;
		
		if ( bList[index] instanceof AniBook && 
				this.mem.getAge() < ((AniBook)bList[index]).getAccessAge()) {
			result = 1;
			
		} else if (bList[index] instanceof CookBook &&
				((CookBook)bList[index]).isCoupon()){
			int newCoup = this.mem.getCouponCount();
			newCoup +=1;
			this.mem.setCouponCount(newCoup);
			
			result= 2;
		} else {
			result = 0;
		}
		
		
		
		
		return result;
		
	}
	
	
}
