<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri= "http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="today" value="<%= new Date() %>" />
	<h1>날짜 포맷</h1>
	<ul>
		<li>full : <fmt:formatDate value="${today }" type="date" dateStyle="full" /></li>
		<li>short : <fmt:formatDate value="${today }" type="date" dateStyle="short" /></li>
		<li>long : <fmt:formatDate value="${today }" type="date" dateStyle="long" /></li>
		<li>default : <fmt:formatDate value="${today }" type="date" dateStyle="default" /></li>
		<li>기본 : <fmt:formatDate value="${today }" type="date" /></li>
	</ul>
	
	<h1>시간 포맷</h1>
	<ul>
		<li>full : <fmt:formatDate value="${today }" type="time" timeStyle="full" /></li>
		<li>short : <fmt:formatDate value="${today }" type="time" timeStyle="short" /></li>
		<li>long : <fmt:formatDate value="${today }" type="time" timeStyle="long" /></li>
		<li>default : <fmt:formatDate value="${today }" type="time" timeStyle="default" /></li>
		<li>기본 : <fmt:formatDate value="${today }" type="time" /></li>
	</ul>
	
	<h1>날짜 / 시간 포맷</h1>
	<ul>
		<li>full : <fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full" /></li>
		<li>short : <fmt:formatDate value="${today }" type="both" dateStyle="short" timeStyle="short" /></li>
		<li>long : <fmt:formatDate value="${today }" type="both" dateStyle="long" timeStyle="long" /></li>
		<li>default : <fmt:formatDate value="${today }" type="both" dateStyle="default" timeStyle="default" /></li>
		<li>기본 : <fmt:formatDate value="${today }" type="both" /></li>
	</ul>
	
	<h1>날짜 / 시간 패턴</h1>
	<ul>
		<li>pattern : <fmt:formatDate value="${today }" type="both" pattern="yyyy-MM-dd hh:mm:ss" /></li>
		<li>pattern : <fmt:formatDate value="${today }" type="both" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초" /></li>
	</ul>
</body>
</html>