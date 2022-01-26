<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String msg = "안녕하세요";
		int num01 = 10;
		int num02 = 20;
		public int abs(int num) {
			if(num < 0) {
				return -num;
			} else {
				return num;
			}
		}
	%>
		<!-- html 주석 -->
		<%-- jsp 주석 --%>
		<%-- 표현식 --%>
		<p><%=msg%></p>
		<p><%=num01%></p>
		<p><%=num02%></p>
		<p>-5의 절대값은 <%=abs(-5)%></p>
</body>
</html>