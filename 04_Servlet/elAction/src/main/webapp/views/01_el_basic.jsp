<%@page import="com.kh.el.model.vo.Person"%>
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
    <h1>1. 기존 방식 대로 jsp문법을 사용해서 각 scope의 데이터를 출력</h1>
    
<%--     <%
    	//request
    	String classRoom = (String)request.getAttribute("classRoom");
    	Person stdent = (Person)request.getAttribute("student");
    	
    	//session scope
    	String academy = (String)session.getAttribute("academy");
    	Person lecture = (Person)session.getAttribute("lecture");
    	
    	
    %>
    
    <p>
    	학원명 : <%=academy %>
    	강의장 : <%=classRoom %>
    	강사 : <%=lecture.getName() %>,<%=lecture.getAge() %>,<%=lecture.getGender() %>
    	<br>
    	수강생 정보 
    	<ul>
    		<li>이름 : <%=stdent.getName() %></li>
    		<li>나이 : <%=stdent.getAge() %></li>
    		<li>성별 : <%=stdent.getGender() %></li>
    	</ul>
    </p> --%>
    
    <h2>2. EL 문법을 이용해서 보다 쉽게 scope의 값을 출력할 수 있다.</h2>
    
    <p>
    	El을 이용하여 getter를 통해 가져올 필요 없이 EL구문 내의 키만을 제시하면 바로 접근이 가능하다<br>
    	EL은 JSP의 scope를 구분하지 않고 자동으로 모든 scope의 키를 검색하여 존재하는 경우 그 값을 가져옴
    </p>
    
    
     <p>
    	학원명 : ${academy}
    	강의장 : ${classRoom}
    	강사 : ${lecture.name}, ${lecture.age} , ${lecture.gender}
    	<br>
    	수강생 정보 
    	<ul>
    		<li>이름 : ${student.name}</li>
    		<li>나이 : ${student.age}</li>
    		<li>성별 :${student.gender}</li>
    	</ul>
    </p>
    
    <h3>3. scope의 키가 동일할 경우</h3>
    scope값 : ${scope}
    <p>
    	EL은 공유범위가 가장 작은 scope부터 해당 키값을 검색함(page -> request -> session ->application)
    </p>
    
    <h4>직접 scope를 지정해서 접근도 가능</h4>
    <%
    	pageContext.setAttribute("scope","page");
    %>
    pageScope : ${scope}, ${pageScope.scope} <br>
    requestScope : ${requestScope.scope} <br>
    sessionScope : ${sessionScope.scope} <br>
    applicationScope : ${applicationScope.scope}
    
</body>
</html>