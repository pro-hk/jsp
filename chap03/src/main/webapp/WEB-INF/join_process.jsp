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
    	request.setAttribute("user_id", "id");
    	RequestDispatcher dispatcher = request.getRequestDispatcher("join_success.jsp");
    	dispatcher.forward(request, response);
    	%>
</body>
</html>