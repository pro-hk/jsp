<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user_ID= request.getParameter("user_id");
	String user_PW = request.getParameter("user_pw");
	//String favorites[] = request.get
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= user_ID %><br>
	<%= user_PW %><br>
	${param.user_id }<br>
	${param.user_pw }<br>
	아이디 일치 확인 : ${param.user_id == "prohk"}<br>
	패스워드 일치 확인 : ${param.user_pw == 1234 }	
</body>
</html>