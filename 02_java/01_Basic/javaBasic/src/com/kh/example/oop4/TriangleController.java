package com.kh.example.oop4;
	
public class TriangleController {
	Shape s = new Shape();
	
	
	public double calcArea(double height, double width) {
		s = new Shape(3,height,width);
		
		
		return (width * height / 2);
	}
	
	public void paintColor(String Color) {
		
		s.setColor(Color);
		
	}
	
	public String print() {
		
		return "삼각형" + s.informationg();
	}

}
