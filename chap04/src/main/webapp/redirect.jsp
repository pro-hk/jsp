<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect</title>
</head>
<body>
	<p>redirect는 그냥 페이지를 다른 곳으로 넘겨주는 역할만 합니다.</p>
	<%
	String name = "다음";
	//if(name.equals("다음"))  response.sendRedirect("http://daum.net");
	//else response.sendRedirect("http://naver.com");
	out.println("<script>alert('로그인 되었습니다.');location.href='http://daum.net'</script>");
	%>
</body>
</html>