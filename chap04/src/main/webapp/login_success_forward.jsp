<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String user_name = (String)request.getAttribute("user_name");
		int user_age = (int)request.getAttribute("user_age");
	%>
	<p>user_name : <%= user_name %></p>
	<p>user_age : <%= user_age %></p>
</body>
</html>