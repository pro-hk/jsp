<%@page import="java.net.URLEncoder"%>
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
		request.setCharacterEncoding("utf-8");
		String db_id="hyeok";
		String db_pw="1234";
		String db_name="장혁";
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		if(user_id.equals(db_id) && user_pw.equals(db_pw)) {
			// 로그인 정보가 db에 있다.
			response.sendRedirect("login_success.jsp?user_name="+URLEncoder.encode(db_name,"utf-8"));
			//request.getRequestDispatcher(path);
		} else {
			// 로그인 정보가 db에 없다.
			// history.go(-1);
			out.println("<script>alert('아이디 또는 비밀번호가 맞지 않습니다');history.back()</script>");
			//response.sendRedirect("login_form.jsp");
		}
	%>
</body>
</html>