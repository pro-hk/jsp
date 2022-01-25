<%@page import="java.util.ArrayList"%>
<%@page import="chap06.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MemberDto> memberList = new ArrayList<>();
	memberList.add(new MemberDto("토르","thor"));
	memberList.add(new MemberDto("토니스타크","ironman"));
	pageContext.setAttribute("avengers", memberList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>${avengers[0].name } === ${avengers[0].getName() }</li>
		<li>${avengers[1].name } === ${avengers[1].getName() }</li>
		<li>${avengers[0].id } === ${avengers[0].getId() }</li>
		<li>${avengers[1].id } === ${avengers[1].getId() }</li>
	</ul>
</body>
</html>