<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String save_check = request.getParameter("save_check");
	System.out.println(user_id+"==="+user_pw+"==="+save_check);
	if(user_id.equals("prohk") && user_pw.equals("1234")) {
		if(save_check!=null && save_check.equals("yes")){
			// 쿠키세팅.. loginID, prohk
			Cookie cookie = new Cookie("loginID",user_id);
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
		} else {
			// 쿠키지우기.. 값 비우고, maxage:0
			Cookie cookie = new Cookie("loginID","");
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		out.println("<script>alert('로그인되었습니다.');location.href='id_save.jsp';</script>");
	};
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