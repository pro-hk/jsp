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
	<h1>format 설정</h1>
	<c:set var="num01" value="12345" />
	<ul>
		<li>콤마 : <fmt:formatNumber value="${num01 }" /></li>
		<li>콤마 : <fmt:formatNumber value="${num01 }" groupingUsed="false" /></li>
	</ul>
	
	<fmt:formatNumber value="${num01 }" type="currency" var="currencyNum01" />
	<h1>통화기호</h1>
	<ul>
		<li>${currencyNum01 }</li>
	</ul>
	
	<fmt:formatNumber value="0.03" type="percent" var="percentNum02" />
	<h1>퍼센트</h1>
	<ul>
		<li>${percentNum02 }</li>
	</ul>
	
	<c:set value="6,789.01" var="num02" />
	<fmt:parseNumber value="${num02 }" pattern="00,000.00" var="parseNum02" />
	<fmt:parseNumber value="${num02 }" integerOnly="true" var="parseNum03" />
	<h1>문자를 숫자로</h1>
	<ul>
		<li>${parseNum02 }</li>
		<li>${parseNum03 }</li>
		<li><fmt:formatNumber value="${parseNum02 }" pattern="0,000.00" /></li>
		<!-- parseNumber로 문자를 숫자로 바꾼 뒤 formatNumber로 패턴 적용 -->
	</ul>
</body>
</html>