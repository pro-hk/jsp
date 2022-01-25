<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie cookie = new Cookie("id","hyeok");
		cookie.setMaxAge(60*60*24);   // 초 개념.. 60(초) * 60(분) * 24(시간) -- 하루
		response.addCookie(cookie);
		response.addCookie(new Cookie("age","20"));
		response.addCookie(new Cookie("pw","1234"));
	%>
	<h1>쿠키 보내기..</h1>
	<%
		Cookie cookies[] = request.getCookies();
		if(cookies!=null){
			for(Cookie c : cookies){
				String cookieName = c.getName();
				String cookieValue = c.getValue();
				out.println(cookieName+" : "+cookieValue+"<br>");
			}
		}
	%>
</body>
</html>