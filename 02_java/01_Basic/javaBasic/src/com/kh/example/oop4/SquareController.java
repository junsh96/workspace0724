package com.kh.example.oop4;

public class SquareController {
	Shape s = new Shape();
	public static void main(String[] args) {
		
		
		

	}
	
	public double calcPerimeter(double height, double width) {
		
		s = new Shape(4,height,width);
		
		return width*2 + height*2;
	}
	
	
	public double calcArea(double height, double width) {
		s = new Shape(4,height,width);
		return width * height;
	}
	
	public void paintColor(String color) {
		s.setColor(color);
		
	}
	
	public String print() {
		
		return "사각형" + s.informationg();
	}

}
