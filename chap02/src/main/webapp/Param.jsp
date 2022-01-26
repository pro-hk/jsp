<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Params</title>
</head>
<body>
	<form action="ParamServlet" method="get">
		<div><label>아이디 : <input type="text" name ="user_id" placeholder="아이디를 입력하세요."></label></div>
		<div><label>나이 : <input type="text" name ="user_age" placeholder="나이를 입력하세요."></label></div>
		<!-- <input type="submit" value="전송"> -->
		<button>전송</button>
	</form>
	<form action="ParamServlet" method="post">
		<div><label>아이디 : <input type="text" name ="user_id" placeholder="아이디를 입력하세요."></label></div>
		<div><label>나이 : <input type="text" name ="user_age" placeholder="나이를 입력하세요."></label></div>
		<!-- <input type="submit" value="전송"> -->
		<button>전송</button>
	</form>
</body>
</html>