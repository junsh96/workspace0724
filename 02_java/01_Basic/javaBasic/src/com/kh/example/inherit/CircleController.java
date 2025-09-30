package com.kh.example.inherit;

public class CircleController {
	Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		c= new Circle(x,y,radius);
		double res = Math.PI * radius * radius;
		
		String result = c.toString()+"/"+res;
		
		return result;
	}
	
	public String calcCircum(int x, int y, int radius) {
		
		c= new Circle(x,y,radius);
		
		double res = Math.PI * radius * 2;
		
		String result = c.toString()+"/"+res;
		
		return result;
		
	}
}
