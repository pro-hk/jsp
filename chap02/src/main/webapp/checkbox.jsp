<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkbox</title>
</head>
<body>
	<form action="CheckboxServlet" method="get"> 
		<label><input type="checkbox" name="item" value="java"><span>JAVA</span></label>
		<label><input type="checkbox" name="item" value="html"><span>HTML</span></label>
		<label><input type="checkbox" name="item" value="css"><span>CSS</span></label>
		<label><input type="checkbox" name="item" value="database"><span>DATABASE</span></label>
		<label><input type="checkbox" name="item" value="jsp"><span>JSP</span></label>
		<div><button>전송</button></div>
	</form>
</body>
</html>