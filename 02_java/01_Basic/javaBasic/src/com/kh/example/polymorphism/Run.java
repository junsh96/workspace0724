package com.kh.example.polymorphism;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * 		클래스 참조 변수  =  new 클래스 생성자();
		 * (부모 클래스가 위칠할 수 있음) = (자식 클래스가 위치 할수 있음) -> 업 캐스팅
		 * 실제로 어디까지 접근이 가능한가 = 실제로 어떤 형태의 메모리가 생성되는가.
		 */
		Cake c1 = new CheeseCake();
		//cake까지 접근이 가능하며 메모리 공간은 실제 cheese cake공간까지 존재함.
		c1.sweet();
		//오버라이딩시에는 실제 메모리에 있는 재정의된 메서드가 호출
		c1.yummy();
		//다운 캐스팅 : 자식의 참조변수로 타입을 변경(엌캐스팅관계에 있을 경우에
		((CheeseCake)c1).milky();
		
		//CheeseCake c2 = new Cake();
		//실제 메모리가 cake이므로 CheeseCake공간에 접근 할수 없음.
		//-> 접근 범위가 실제메모리의 크기보다 클 수 없음.
		
		
		
		
		
		//1. 부모타입의 래퍼런스(참조변수)로 부모객체를 다루는 경우
		Car c2 = new Car("빨간색","가솔린",2021);
		c2.drive();
		
		
		//2. 자식타입 래퍼런스 자식객체를 다루는 경우
		Avante c3 = new Avante("흰색","lpg",2022);
		c3.drive();
		c3.moveAvante();
		//부모 참조 변수로 업캐스팅 가능 -> 오버라이딩 된 메서드는 생성된 메모리를 기준으로 호출됨.
		((Car)c3).drive();
		//((Car)c3).moveAvante // 업캐스팅시 자식 메모리 접근이 불가.
		
		//3. 부모 타입 래퍼런스로 자식 객체를 다루는 경우(업캐스팅)
		Car c4 = new Sonata("검정", "디젤", 2023);
		//c4.moveSonta 부모타입의 참조변수이기 때문에 자식 요소의 메서드에 접근 불가.
		((Sonata)c4).moveSonata();
		
		
		/**
		 * 상속 구조의 클래스들 간의 형변환 가능
		 * 1. UpCasting
		 * 		자식 타입 -> 부모타입으로 형변환
		 * 		자동 형변환
		 * 		ex) Car c = new Sonata();
		 * 
		 * 2. DownCasting
		 * 		부모타입 -> 자식 타입으로 형변환
		 * 		강제형변환. / 업캐스팅 관계에 있을때만 가능하다.
		 * 		ex) ((Sonata)c).moveSonata();
		 * 
		 */
		System.out.println("----------------");
		c3.driverCar(c2); // -> 실제 메모리 car
		c3.driverCar(c3); // -> 실제 메모리 Avante
		c3.driverCar(c4); // -> 실제 메모리 Sonata
		
	}

}
