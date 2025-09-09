package com.kh.generic;

public class Box<T> {

	private T value;
	private T[] arr;
	private int num;
	public Box(T value, T[] arr) {
		super();
		this.value = value;
		this.arr = arr;
		this.num = num;
	}
	public Box() {
		super();
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public T[] getArr() {
		return arr;
	}
	public void setArr(T[] arr) {
		this.arr = arr;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
