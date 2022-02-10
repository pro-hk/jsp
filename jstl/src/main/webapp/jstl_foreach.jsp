<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.prohk.common.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>for each</h1>
	<pre> <!-- 있는 그대로 쓰기 -->
		for(int i=1; i<=10; i++){
			i번째 입니다.
		} 
	</pre>
	<c:forEach var="i" begin="1" end="10" step="1"> <!-- step 안쓰면 1씩 증가 -->
		<p>${i }번째 입니다.</p>
	</c:forEach>
	
	<h2>varStatus의 값 출력해보기</h2>
	<table border="1">
		<c:forEach var="i" begin="3" end="5" varStatus="loop">
			<tr>
				<td>count : ${loop.count }</td>
				<td>index : ${loop.index }</td>
				<td>current : ${loop.current }</td>
				<td>first : ${loop.first }</td>
				<td>last : ${loop.last }</td>
			</tr>
		</c:forEach>
	</table>
	
	<h2>for 02</h2>
	<%
		String fruits[] = {"banana","apple","kiwi","peach"};
		
		// el(${})문법은 속성값만 쓸 수 있다.
		String colors[] = {"red", "green", "blue", "black", "magenta"};
		request.setAttribute("colors", colors);
		
		List<Person> lists = new ArrayList<>();
		lists.add(new Person("아이언맨",45));
		lists.add(new Person("헐크",50));
		lists.add(new Person("토르",1900));
		
		Map<String, Person> maps = new HashMap<>();
		maps.put("ironman", new Person("아이언맨",45));
		maps.put("hulk", new Person("헐크",50));
		maps.put("thor", new Person("토르",1900));
		// 속성에 담거나 c:set 으로 값을 지정하면 ${}를 쓸 수 있다.
	%>
	<ul>
	<c:forEach items="<%= fruits  %>" var="f">
		<li>${f }</li>		
	</c:forEach>
	</ul>
	
	<ul>
	<%-- <c:forEach items="${colors }" var="c" begin="1" end="3"> --%>
	<c:forEach items="${colors }" var="c">
		<li style="color:${c}; font-size:20px">${c }</li>		
	</c:forEach>
	</ul>
	
	<c:set var="avengers" value="<%= lists %>" />
	<ul>
	<c:forEach items="${avengers }" var="a">
		<li>이름 : ${a.name } / 나이 : ${a.age }</li>
	</c:forEach>
	</ul>
	
	<c:set var="avengersMap" value="<%= maps %>" />
	<ul>
	<c:forEach items="${avengersMap }" var="m">
		<li>
			key ==> ${m.key } <br>
			value ==> 이름 : ${m.value.name } / 나이 : ${m.value.age } 
		</li>
	</c:forEach>
	</ul>
</body>
</html>