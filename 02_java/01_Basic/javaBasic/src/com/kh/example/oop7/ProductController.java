package com.kh.example.oop7;

public class ProductController {
	Product [] pro = new Product[10];

	public ProductController() {
		super();
		String [] name = {"갤럭시","아이폰","아이패드"};
		int [] price = {1200000,1300000,800000};
		String [] brand = {"삼성","애플","애플"};
		
		for (int i=0; i<3; i++) {
			pro[i] = new Product();
			pro[i].setpName(name[i]);
			pro[i].setPrice(price[i]);
			pro[i].setBrand(brand[i]);
		}
		
	}
	
	public void insertProduct(String pName, int price, String brand) {
		for (int i=0; i<pro.length; i++) {
			if (pro[i] == null) {
				pro[i] = new Product();
				pro[i].setpName(pName);
				pro[i].setPrice(price);
				pro[i].setBrand(brand);
				break;
			}
		}

		
	}
	
	public Product[] selectProduct() {
		
		return pro;
	}
	
	
}
