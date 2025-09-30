package com.kh.example.collection2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class LotteryController {

	HashSet<Lottery> lottery = new HashSet<>();
	
	HashSet<Lottery> win = new HashSet<>();
	
	public boolean insertObject(Lottery l) {
		
		
		
		
		return lottery.add(l);
	}
	
	public boolean deleteObject(Lottery l) {
		boolean isRemove = lottery.remove(l);
		if (win != null && isRemove) {
			win.remove(l);			
		}
		
		return isRemove;
	}
	
	
	public HashSet winObject() {
		
		if(win.size() < 4) {
			Random rand = new Random();
			ArrayList<Lottery> list = new ArrayList<>();
			while(win.size() < 4 && win.size() != lottery.size()) {
				int index = rand.nextInt(list.size());
				win.add(list.get(index));
			}
			
			
		
		
		}
		return win;
		
		
	}
	
//	public TreeSet sortedWinobject () {
//		
//	}

	public boolean searchWinner(Lottery l) {
		return win.contains(l);
	}
	
	
	
}
