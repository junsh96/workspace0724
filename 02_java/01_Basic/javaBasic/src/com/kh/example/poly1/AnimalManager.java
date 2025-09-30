package com.kh.example.poly1;

public class AnimalManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal[] Animal = new Animal[5];
		
		Animal[0] = new Dog("진돗개",10,"진돗개");
		Animal[1] = new Cat("고양이",3,"하얀색");
		Animal[2] = new Dog("삽살개",5,"삽살개");
		Animal[3] = new Dog("푸들",15,"푸들");
		Animal[4] = new Cat("고양이",3,"초록색");
		
		for (int i=0; i<Animal.length; i++) {
			
			Animal[i].speak();
			if (Animal[i] instanceof Dog) {
				System.out.println("이 개의 견종은 "+((Dog)Animal[i]).getBreed()+" 입니다.");
			} else {
				System.out.println("이 고양이의 색상은 "+((Cat)Animal[i]).getColor()+" 입니다.");
			}
			
		}
		

	}

}
