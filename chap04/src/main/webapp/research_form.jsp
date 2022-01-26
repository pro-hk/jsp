<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="research_ok.jsp">
	<table border="1" width="600px">
		<tr>
			<th>이름</th>
			<label><td><input type="text" name="user_name" placeholder="이름을 적으세요."></td></label>
		</tr>
		<tr>
			<th>성별</th>
			<label><td><input type="radio" name="gender" value="male">남자</td></label>
			<label><td><input type="radio" name="gender" value="female">여자</td></label>
		</tr>
		<tr>
			<th>좋아하는 계절</th>
			<label><td><input type="checkbox" name="season" value="spring">봄</td></label>
			<label><td><input type="checkbox" name="season" value="summer">여름</td></label>
			<label><td><input type="checkbox" name="season" value="fall">가을</td></label>
			<label><td><input type="checkbox" name="season" value="winter">겨울</td></label>
		</tr>
	</table>
	<button type="submit">전송</button>
	<button type="reset">취소</button>
	</form>
</body>
</html>