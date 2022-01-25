<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String loginID = ""; 
	String isChecked = "";
	// 쿠키 읽기
	Cookie cookies[] = request.getCookies();
	if(cookies!=null) {
		for(Cookie cookie : cookies) {
			String cookieName = cookie.getName();
			if(cookieName.equals("loginID")) {
				loginID = cookie.getValue();
			}
		}
	}
	if(!loginID.equals("")) isChecked = "checked";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID저장</title>
</head>
<body>
	<h1>ID 저장해두기</h1>
	<form action="id_save_process.jsp" method="post">
		<div>
			<label>
				<span>아이디</span>
				<input type="text" name="user_id" value="<%= loginID %>" placeholder="아이디를 입력하세요.">
			</label>
			<label><input type="checkbox" name="save_check" value="yes" <%= isChecked %>>아이디 저장하기</label>
		</div>
		<div>
			<label><span>패스워드</span><input type="password" name="user_pw" placeholder="비밀번호를 입력하세요."></label>
		</div>
		<div>
			<button>로그인</button>
		</div>
	</form>
</body>
</html>