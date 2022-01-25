<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
	String pw = (String)session.getAttribute("pw");
	int age = (int)session.getAttribute("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>id: <%= id %></li>
		<li>pw: <%= pw %></li>
		<li>age: <%= age %></li>
	</ul>
	<h2>세션의 여러가지 정보들</h2>
	<ul>
		<li>세션 유지 시간 : <%= session.getMaxInactiveInterval() %></li>
		<li>세션 ID : <%= session.getId() %></li>		
		<li>세션 최초 요청 시간 : <%= session.getCreationTime() %></li>
	</ul>
</body>
</html>