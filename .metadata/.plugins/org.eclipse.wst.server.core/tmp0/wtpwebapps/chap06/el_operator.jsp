<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num01 = 3;
	pageContext.setAttribute("num02", 4);
	pageContext.setAttribute("num03", "5");
	pageContext.setAttribute("num04", "6");
	
	pageContext.setAttribute("nullString", null);
	pageContext.setAttribute("emptyString", "");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>el operator</h1>
	<ul>
		<li>${num01 = 7 }</li>
		<li>${num05 = 10;'' }==${num05 }</li>
		<li>${num02 }</li>
		<li>${num02 + num03 }</li>
		<li>${num02 / num03 } == ${num02 div num03 }</li>
		<li>${num02 * num03 }</li>
		<li>${num02 % num03 } == ${num02 mod num03 }</li>
		<li>${num02 > num03 } == ${num02 gt num03 }</li>
		<li>${num02 < num03 } == ${num02 lt num03 }</li>
		<li>${num02 >= num03 } == ${num02 ge num03 }</li>
		<li>${num02 <= num03 } == ${num02 le num03 }</li>
		<li>${num02 == num03 } == ${num02 eq num03 }</li>
		<li>${nullString }</li>
		<li>${empty nullString }</li>
		<li>${empty emptyString }</li>
		<li>${nullString + 10 }</li>
		<li>${nullString > 10 }</li>
	</ul>
</body>
</html>