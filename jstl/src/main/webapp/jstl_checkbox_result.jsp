<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String avengers[] = request.getParameterValues("avengers");
	request.setAttribute("avengers", avengers);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>선택한 어벤져스</h1>
	<ul>
	<c:forEach items="${avengers }" var="a">
		<li>${a }</li>
	</c:forEach>
	</ul>
	<ul>
	<c:forEach items="${paramValues.avengers }" var="p">
		<li>${p }</li>
	</c:forEach>
	</ul>
	<c:forEach items="${paramValues.avengers }" var="s" varStatus="status">
		${s }<c:if test="${not status.last }">, </c:if>
	</c:forEach>
	<div><a href="jspl_checkbox.jsp">뒤로</a></div>
</body>
</html>