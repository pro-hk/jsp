<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과</h1>
	<%
	request.setCharacterEncoding("utf-8");
	String user_name = request.getParameter("user_name");
	String gender = request.getParameter("gender");
	String season[] = request.getParameterValues("season");
	out.println("<p>당신의 이름은 : "+user_name+"</p>");
	out.println("<p>당신의 성별은 : "+gender+"</p>");
	out.print("<p>당신이 좋아하는 계절은 : ");
	for(int i=0; i< season.length; i++) {
		out.print(season[i]+", ");
	}
	out.print("입니다.</p>");
	%>
</body>
</html>