package com.kh.example.polymorphism;

public class Avante extends Car {

	
	
	public Avante(String color, String fuel, int year) {
		super(color, fuel, year);
	}

	public void drive() {
		System.out.println("슝 -ava");
	}
	
	public void moveAvante() {
		System.out.println("빵빵 ava ");
	}
	
	public void driverCar(Car car) {
		//매개 변수로 넘어온 car가 실제 메모리 공간에 Avante를 구형하고있어야 사용가능
		if (car instanceof Avante) {
			((Avante)car).moveAvante();			
		}
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Avante) {
			
		}
		return false;
	}
	
	
	
	
}
