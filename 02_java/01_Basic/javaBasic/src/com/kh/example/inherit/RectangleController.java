package com.kh.example.inherit;

public class RectangleController {

	Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {
		
		 r = new Rectangle(x,y,width,height);
		 
		 int res = width * height;
		 
		 String result = r.toString()+"/"+res;
		 
		 return result;
		
		
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		
		r = new Rectangle(x,y,width,height);
		
		int res = 2*(width + height);
		
		String result = r.toString()+"/"+res;
		
		return result;
		
	}
	
	
}
