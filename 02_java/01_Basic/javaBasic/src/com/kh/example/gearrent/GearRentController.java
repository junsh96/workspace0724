package com.kh.example.gearrent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GearRentController {

	private HashMap<String, Device> catalog = new HashMap<>();
	private HashMap<String, Member> members = new HashMap<>();
	private HashMap<String, Loan> activeLoans = new HashMap<>();
	
	//기기 추가
	public boolean addDevice(Device device) {
		boolean result = false;
		System.out.println(device);
		if (catalog.size() > 0) {
			for (Entry<String, Device> rMap :catalog.entrySet()) {
				// 기기아이디가 중복인지 확인
				System.out.println(rMap.getKey());
				System.out.println(device.getId());
				if (rMap.getKey().equals(device.getId())) {
					
					result = false;
				} else {
					
					result = true;
				}

				
			}
		} else {
			result = true;
		}

		System.out.println(result);
		
		if (result) {
			//카탈로그
			//카메라인지 랩탑인지 구분후 추가.
			
			if (device instanceof Camera) {
				Camera c = new Camera(device.getId(), device.getName(),device.getCategory(), device.getTags());
				catalog.put(device.getId(), c);
			} else {
				Laptop l = new Laptop(device.getId(), device.getName(),device.getCategory(), device.getTags());
				catalog.put(device.getId(), l);
			}
		}
		
		
		return result;
	}
	//멤버 추가
	public boolean addMember(Member member) {
		boolean result = false;
		if (members.size() > 0) {
			for (Entry<String, Member> rMap : members.entrySet()) {
				if (rMap.getKey().equals(member.getId())) {
					result = false;
				} else {
					result = true;
				}
			}
		} else {
			
			result = true;
			
		}
		if (result) {
			//멤버 추가.
			members.put(member.getId(), member);
			Member m = new Member();
			m.setId(member.getId());
			m.setName(m.getName());

		}
		
	
		
		
		
		return result;
	}
	
	public Loan borrow(String memberId, String itemId, LocalDate today) {
		//카메라와 랩탑 구분 필요.
		Device de = catalog.get(itemId);
		int limit = 0;

		if (de instanceof Camera) {
			Camera c = new Camera(itemId,de.getName(),de.getCategory(),de.getTags());
			
			
			limit = c.getBorrowLimitDays();
			c.getBorrowCount();
		
		} else {
			Laptop l = new Laptop(itemId, de.getName(), de.getCategory(), de.getTags());
			
			
			limit = l.getBorrowLimitDays();
			l.getBorrowCount();
		}
		
		Loan l = new Loan(itemId, memberId, today, today.plusDays(limit));
		activeLoans.put(itemId, l);
		
		return l;
	}
	
	//카메라 와 랩탑 구분 필요.
	//반납 예정일 구분 필요.
	public int returnItem(String itemId, LocalDate today) {
		
		int limit = 0;
		int fee = 0;
		Device de = catalog.get(itemId);
		Device device = null;
		if (de instanceof Camera) {
			device = new Camera(itemId,de.getName(),de.getCategory(),de.getTags());
			limit = device.getBorrowLimitDays();
			
			
			
		} else {
			device = new Laptop(itemId, de.getName(), de.getCategory(), de.getTags());
			
			limit = device.getBorrowLimitDays();
			
			
		}
		
		Loan active = activeLoans.get(itemId);
		int overday = active.overdueDays(today);
		System.out.println("overday"+overday);
		fee = device.calcLateFee(overday);
		System.out.println("fee"+fee);
		
		//Loan l = new Loan(itemId, memberId, today, today.minusDays(limit));

		activeLoans.remove(itemId);
		return fee;
	}
	
	/// 카메라와 랩탑 구분 필요?
	/// 자식 호출?
	public ArrayList<Device> findByTag(String tag) {
		
		ArrayList<Device> de = new ArrayList<>();
		//Device device = new Device();

		for (Entry<String, Device> rMap :catalog.entrySet()) {
			System.out.println(catalog.get(rMap.getKey()) instanceof Camera);
			if (catalog.get(rMap.getKey()) instanceof Camera) {
				Device device = new Camera(null, null, null, null);
				
				boolean result = device.hasTag(tag);
				
				if (result) {
					de.add(catalog.get(rMap.getKey()));
				}
			} else {
				Device device = new Laptop(null, null, null, null);
				
				boolean result = device.hasTag(tag);
				if (result) {
					de.add(catalog.get(rMap.getKey()));
				}
			}
		}
		
		if (de.size() == 0) {
			return null;
		} else {
			return de;
		}
		
	}
	
	//
	public ArrayList<Device> findByKeyword(String keyword) {
		ArrayList<Device> findKey = new ArrayList<>();
		
		if(keyword == null || keyword == "") {
			return findKey;
		}
		
		for (Entry<String, Device> rMap : catalog.entrySet()) {
			
			if (catalog.get(rMap.getKey()).getName().toLowerCase().equals(keyword.toLowerCase())
					|| catalog.get(rMap.getKey()).getCategory().toLowerCase().equals(keyword.toLowerCase())) {
				findKey.add(catalog.get(rMap.getKey()));
			}
			
		}
		
		for (Device d : catalog.values()) {
			d.hasTag(keyword);
		}
		
		return findKey;
		
		
		
	}
	
	public Collection<Device> getAllDevices() {
		
		
		return catalog.values();
	}
	
	public Collection<Loan> getActiveLoans() {
		
		return activeLoans.values();
	}
	
	
}
