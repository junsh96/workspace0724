<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>피자 결제 페이지</h1>
    <br>
    <h2>주문 내역</h2>
    <h3>[ 주문자 정보 ]</h3>
    <br>
    <%
 		 //주문자 정보
  		String userName = (String) request.getAttribute("userName");
  		String phone =(String) request.getAttribute("phone");
  		String address = (String)request.getAttribute("address");
  		String message = (String)request.getAttribute("message");
  		//주문 정보
  		String pizza = (String) request.getAttribute("pizza");
  		String[] toppings = new String[0];
  		String topping = "";
  		if (request.getAttribute("topping") != "") {
	  		toppings = (String[]) request.getAttribute("topping");
	  		topping = String.join(", ", toppings);
  		}
  		String[] sides =  new String[0];
  		String side = "";
  		if (request.getAttribute("side") != "") {
  			sides =  (String[])request.getAttribute("side");
  			side = String.join(", ", sides);
  		}
  		
  		String payment =  (String)request.getAttribute("payment");
    	int sum = (Integer) request.getAttribute("sum");
    	
    	
    	
    %>
    <ul>
    	<li>성함 : <%=userName %></li>
    	<li>전화번호 : <%=phone %></li>
    	<li>주소 : <%=address %></li>
    	<li>요청사황 : <%=message %></li>
    </ul>
    
    <br>
    <h3>[ 주문 정보 ]</h3>
    <br>
    <ul>
    	<li>피자 : <%=pizza %></li>
    	<li>토핑 : <%=topping %></li>
    	<li>사이드 : <%=side %></li>
    	<li>결제 방식 : <%=payment %></li>
    </ul>
    
    <br>
    <h3>위와 같이 주문하셨습니다.</h3>
    <br>
    <h2>총 가격 : <%=sum %> 원</h2>
</body>
</html>