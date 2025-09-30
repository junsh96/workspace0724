package com.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/confirmPizza.do")
public class pizzaOrder extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public pizzaOrder() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		//주문자 정보
		String name = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		//주문 정보
		String pizza = request.getParameter("pizza");
		String[] topping = request.getParameterValues("topping");
		String[] side = request.getParameterValues("side");
		String payment = request.getParameter("payment");
		
    	int pizzaPay = 0;
    	if (pizza.equals("콤비네이션")) {
    		pizzaPay = 20000;
    	} else if (pizza.equals("치즈피자") || pizza.equals("포테이토")) {
    		pizzaPay = 23000;
    	} else {
    		pizzaPay = 25000;
    	}
		
    	int toppingPay = 0;
    	
    	if (topping != null) {
    		for (String top : topping) {
    			if (top.equals("베이컨") ||top.equals("파인애플")) {
    				toppingPay = toppingPay + 3000;
    			} else if (top.equals("치즈크러스트") || top.equals("치즈바이트")) {
    				toppingPay = toppingPay + 2000;
    			} else {
    				toppingPay = toppingPay + 1000;
    			}
    		}
    	}
    	int sidePay = 0;
    	if (side != null) {
    		for (String sd : side) {
    			if (sd.equals("콜라") || sd.equals("환타")) {
    				sidePay = sidePay + 3000;
    			} else if (sd.equals("핫소스") || sd.equals("파마산") || sd.equals("피클")) {
    				sidePay = sidePay + 2000;
    			} else {
    				sidePay = sidePay + 1000;
    			}
    		}
    			
  
    	}
    	int sum = pizzaPay + toppingPay + sidePay;
    	
		request.setAttribute("userName", name);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("message", message);
		request.setAttribute("pizza", pizza);
		if (topping != null) {
			request.setAttribute("topping", topping);
		} else {
			request.setAttribute("topping", "");
		}
		if (side != null) {
			request.setAttribute("side", side);			
		} else {
			request.setAttribute("side", "");
		}
		
		request.setAttribute("payment", payment);
		request.setAttribute("sum", sum);
		RequestDispatcher view = request.getRequestDispatcher("/views/pizza/pizzaPayment.jsp");
		view.forward(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
