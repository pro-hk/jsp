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
		// pageContext (단일 페이지)
		// request     (forward로 넘긴 페이지)
		// session	   (session이 유지되는 페이지)
		// application (전역)
		pageContext.setAttribute("name", "나는 pageContext입니다.");
		request.setAttribute("name", "나는 request입니다.");
		session.setAttribute("name", "나는 session입니다.");
		application.setAttribute("name", "나는 application.");
		
		System.out.println("scope_first=====");
		System.out.println("pageContext====="+pageContext.getAttribute("name"));
		System.out.println("request====="+request.getAttribute("name"));
		System.out.println("session====="+session.getAttribute("name"));
		System.out.println("application====="+application.getAttribute("name"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("scope_second.jsp");
		dispatcher.forward(request, response);		
	%>
</body>
</html>