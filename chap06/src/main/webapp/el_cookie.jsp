<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("elCookie","elCookie맛있어요");
	cookie.setMaxAge(60*3);
	cookie.setPath("/");
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${cookie.elCookie.value }
</body>
</html>