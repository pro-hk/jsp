<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String loginID="";
	String isSave ="";
	
	Cookie cookies[] = request.getCookies();
	for(Cookie cookie : cookies){
		String cookieName = cookie.getName();
		if(cookieName.equals("id_save")){
			loginID = cookie.getValue();
			isSave = "checked";
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ID 저장해두기</h1>
	<form action="id_save01_process.jsp" method="get">
		<div>
			<label>
				<span>아이디</span>
				<input type="text" name="user_id" value="<%= loginID %>" placeholder="아이디를 입력하세요.">
			</label>
			<label>
				<input type="checkbox" name="id_check" value="yes" <%= isSave %>>아이디 저장하기
			</label>
		</div>
		<div>
			<label>
				<span>패스워드</span><input type="password" name="user_pw" placeholder="비밀번호를 입력하세요.">	
			</label>
		</div>
		<button>로그인</button>
	</form>
</body>
</html>