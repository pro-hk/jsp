<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- radio 9개 추가해서 table에 구구단 출력하기 -->
	<form action="CheckGugudan" method="get">
		<label><input type="checkbox" name="checkdan" value="2">2</label>
		<label><input type="checkbox" name="checkdan" value="3">3</label>
		<label><input type="checkbox" name="checkdan" value="4">4</label>
		<label><input type="checkbox" name="checkdan" value="5">5</label>
		<label><input type="checkbox" name="checkdan" value="6">6</label>
		<label><input type="checkbox" name="checkdan" value="7">7</label>
		<label><input type="checkbox" name="checkdan" value="8">8</label>
		<label><input type="checkbox" name="checkdan" value="9">9</label>
		<div><button>전송</button></div>
	</form>
</body>
</html>