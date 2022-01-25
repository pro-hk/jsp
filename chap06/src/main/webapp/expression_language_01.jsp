<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><% out.print("hello"); %></h2>
	<h2><%= "hello world" %></h2>
	<h2>${"hello"}</h2>
	<h2>정수 : ${10 }</h2>
	<h2>실수 : ${4.5 }</h2>
	<h2>문자열 : ${"prohk" }</h2>
	<h2>boolean : ${true }</h2>
	<h2>null : ${null }</h2>
	<h2>10+10 연산 : ${10+10 }</h2>
	<h2>10/10 연산 : ${10/10 }</h2>
	<h2>10*10 연산 : ${10*10 }</h2>
	<h2>10-10 연산 : ${10-10 }</h2>
	<h2>10 > 5 연산 : ${10>5 }</h2>
	<h2>(10 > 5) ? 5 : 3 삼항연산 : ${(10 > 5) ? 5 : 3 }</h2>
</body>
</html>