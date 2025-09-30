<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h3>1. fmt: formatNumber</h3>
    <p>
    	숫자 데이터의 표시 형식을 지정<br>
    	(fmt:formatNumber value="출력할 값" 
    	[
	    	groupingUsed="true | false" <!-- 천단위 구분 유무 --> 
	    	type="number|percent|currency" <!-- 출력 형식 -->
	    	currencySymbol = "문자" <!-- type = currency인 경우 통화기호를 강제로 지정 -->
	    	currencyCode = "통화" <!--  통화 문자 대신 통화 기호 사용 -->
    	]
    	) <br>
    </p>
    
    <c:set var="num1" value="123456789"/>
    <c:set var="num2" value="0.75"/>
    <c:set var="num3" value="50000"/>
    
    출력 : ${num1} <br> ${num2} <br> ${num3} <br>
    
    세자리 구분 출력 : <fmt:formatNumber value="${num1}"/> <br>
    <fmt:formatNumber value="${num1}" groupingUsed="false"/> <br>
    
    %출력 : <fmt:formatNumber value="${num2}" type="percent"/>
    <br>
    %소수한자리 : <fmt:formatNumber value="${num2}" type="percent" minFractionDigits="1"/>
    
    통화 : <fmt:formatNumber value="${num3}" type="currency" currencySymbol="$"/><br>
    통화 : <fmt:formatNumber value="${num3}" type="currency" currencyCode="KRW"/>
    
    
    <h3>2. formatDate</h3>
    <p>
    	날짜 및 시간 데이터의 포맷 저장(단 java.util.Date객체 사용)
    </p>
    
    <c:set var="current" value="<%=new java.util.Date() %>"/>
    
    출력 : ${current} <br>
    
    <ul>
    	<li>현재 날짜 : <fmt:formatDate value="${current}" type="date"/></li>
    	<li>현재 날짜 : <fmt:formatDate value="${current}" type="time"/></li>
    	<li>현재 날짜 : <fmt:formatDate value="${current}" type="both"/></li>
    	<li>현재 날짜 : <fmt:formatDate value="${current}" type="both" dateStyle="medium" timeStyle="medium"/></li>
    	<li>현재 날짜 : <fmt:formatDate value="${current}" type="both" dateStyle="long" timeStyle="long"/></li>
    	<li>현재 날짜 : <fmt:formatDate value="${current}" type="both" dateStyle="short" timeStyle="short"/></li>
    	<li>현재 날짜 : <fmt:formatDate value="${current}" type="both" dateStyle="full" timeStyle="full"/></li>
    	<li>현재 날짜 : <fmt:formatDate value="${current}" type="both" pattern="yyyy년	MM월 dd일 E요일  a HH:mm:SS"/></li>
    </ul>







    
</body>
</html>