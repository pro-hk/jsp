<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL if</h1>
	
	<c:set var="num" value="100" /> <!-- 1줄로 가능 -->
	<c:set var="str" value="java" />
	
	<h2>if 숫자비교</h2>
	<c:if test="${num % 2 == 0 }" var="result">
		${num }은 짝수입니다.
	</c:if>  <!-- test : 조건 -->
	<p>num result : ${result }</p>
	
	<h2>if 문자비교</h2>
	<c:if test="${str eq 'jstl' }" var="result02">
		${str }은 jstl이 맞습니다.
	</c:if>
	<c:if test="${not result02}" var="result02">
		${str }은 jstl이 아닙니다.
	</c:if>
	<p>str result : ${result02 }</p>
	
	<h2>주의할 점</h2>
	<c:if test="100" var="result03">
		test에 일반값이 들어오면 false입니다.
	</c:if>
	<p>result03 : ${result03 }</p>
	<c:if test="true" var="result04">
		test에 true가 들어오면 true입니다.
	</c:if>
	<p>result04 : ${result04 }</p>
	<c:if test="${ true}" var="result05">
		test에 el문법을 쓴 true가 들어오면 true입니다. 단 ""와 el문법 사이에 공백이 있으면 false
	</c:if>
	<p>result05 : ${result05 }</p>
</body>
</html>