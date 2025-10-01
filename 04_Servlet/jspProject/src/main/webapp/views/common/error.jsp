<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
    	.error-msg {
    		color : red;
    		text-align: center;
    		margin-top: 52px;
    	}
    </style>
</head>
<body>
    <jsp:include page="/views/common/menubar.jsp"/>
    
    <h1 class="error-msg">
    	<c:out value="${errorMsg}" default="알수 없는 오류가 발생하였습니다."/>	
    </h1>
</body>
</html>