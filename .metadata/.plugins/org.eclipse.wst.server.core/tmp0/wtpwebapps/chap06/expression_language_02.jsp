<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("scope", "page");
	request.setAttribute("scope", "request");
	session.setAttribute("scope", "session");
	application.setAttribute("scope", "application");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>laguage02</title>
</head>
<body>
	<ul>
		<!-- <li>scope</li> 범위가 작은 것부터 출력 -->
		<li>${pageScope.scope }</li>
		<li>${requestScope.scope }</li>
		<li>${sessionScope.scope }</li>
		<li>${applicationScope.scope }</li>
	</ul>
</body>
</html>