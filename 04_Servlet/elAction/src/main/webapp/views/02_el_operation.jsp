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
    <h3>1. 산술 연산자</h3>
    기존 : 10 + 3 = <%=(Integer)request.getAttribute("big") + (Integer)request.getAttribute("small") %>
    
    <br><br>
    
    EL방식 <br>
    10 + 3 = ${big + small} <br>
    10 / 3 =  ${big / small} 또는 ${big div small}<br>
    10 % 3 = ${big % small} 또는 ${big mod small}<br>
    
    <h3>2.대소 비교</h3>
    10 &gt; 3 = ${big > small} or ${big gt small} <br>
    10 &lt; 3 = ${big < small} or ${big lt small} <br>
    10 &gt;= 3 = ${big >= small} or ${big ge small} <br>
    10 &lt;= 3 = ${big <= small} or ${big le small}  <br>
    
    <h3>3. 동등비교</h3>
    <p>
    	el에서는 == 비교는 자바에서의 equals()와 동일
    </p>
    strOne과 strTwo가 일치하는가? ${strONe == strTwo} or ${strOne eq strTwo} <br>
    strOne과 strTwo가 일치하지 않는가? ${strONe != strTwo} or ${strOne ne strTwo} <br>
    
    <%--el구문 안에서 문자열 리터럴 값은 ''와 ""를 구분하지 않음 --%>
    strThree와 "hello"가 일치 하는가? ${strThree == "hello"} or ${strThree eq 'hello'} <br>
    
    <h3>4. 객체가 null인지 , list가 비어있는지 확인</h3>
    personOne이 null인가? ${personOne == null} or ${personOne eq null} or ${ empty personOne }
    <br>
    personTwo이 null인가? ${personTwo == null} or ${personTwo eq null} or ${ empty personTwo }
    <br>
    personTwo이 null이 아닌가? ${personTwo != null} or ${personTwo ne null} or ${ not empty personTwo }
    
    <br>
    arrOne이 비어있는가> ${ empty arrOne } <br>
    arrTwo이 비어있는가> ${ empty arrTwo } <br>
    
    
    <h4>5. 논리 연산자</h4>
    true && true : ${true && true} or ${true and true}<br>
    fasle || false : ${flase || fasle} or ${false or false} <br> 
    
    
</body>
</html>