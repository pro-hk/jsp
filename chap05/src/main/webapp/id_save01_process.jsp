<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String id_check = request.getParameter("id_check");
	if(user_id.equals("prohk") && user_pw.equals("1234")) {
		if(id_check!=null && id_check.equals("yes")){
			//out.print("<script>alert('체크되어있음')</script>");
			Cookie cookie = new Cookie("id_save",user_id);
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("id_save","");
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		session.setAttribute("loginID", user_id);
		out.print("<script>alert('로그인되었습니다.');location.href='main01.jsp';</script>");
	} else {
		out.print("<script>alert('아이디 또는 비밀번호를 확인하세요.');location.href='id_save01.jsp'</script>");
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>