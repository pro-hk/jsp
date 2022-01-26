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
		int age = Integer.parseInt(request.getParameter("user_age"));
		if(age<=19) {
	%>
	<script>
	alert("19세 미만입니다.");
	history.back();
	</script>
	<%
		} else {
			request.setAttribute("user_name", "장혁");
			request.setAttribute("user_age", age);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login_success_forward.jsp");
			dispatcher.forward(request, response);
		}
	%>
</body>
</html>