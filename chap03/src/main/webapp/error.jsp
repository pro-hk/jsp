<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<h1>다음과 같은 에러가 발생하였습니다.</h1>
	<%= exception.getMessage() %>
	<%-- jsp는 결국 java로 컴파일 된다. --%>
</body>
</html>