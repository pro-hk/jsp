<%@page import="com.prohk.model.MemberDto"%>
<%@page import="com.prohk.model.MemberDao"%>
<%@page import="javax.naming.spi.DirectoryManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp"%>
<%
	String user_id = request.getParameter("user_id");
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = memberDao.getSelectOne(user_id);
	// el을 통해서 출력하려고 하면 setAttribute로 담아야 한다.
	request.setAttribute("memberInfo", memberDto);
%>

<main>
	<div class="container">
		<h2 class="subTitle">MEMBER LIST</h2>
		<div id=contents>
			<div class="tableBox">
				<table>
					<colgroup>
						<col style="width: 150px">
						<col>
					</colgroup>
					<tbody>
						<tr>
							<th>ID</th>
							<td>${memberInfo.id }</td>
						</tr>
						<tr>
							<th>이름</th>
							<td>${memberInfo.name }</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>${memberInfo.email }</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td>${memberInfo.phone }</td>
						</tr>
						<tr>
							<th>우편번호</th>
							<td>${memberInfo.zipCode }</td>
						</tr>
						<tr>
							<th>주소</th>
							<td>${memberInfo.address }</td>
						</tr>
						<tr>
							<th>가입일</th>
							<td>${memberInfo.regDate }</td>
						</tr>
					</tbody>
				</table>
				<div class="btns">
					<a href="update.jsp?user_id=${memberInfo.id }&user_name=${memberInfo.name }" class="btn btnConfirm">회원정보 수정</a> 
					<a href="delete.jsp?user_id=${memberInfo.id }" class="btn btnCancel">회원탈퇴</a>
				</div>
			</div>
		</div>
	</div>
</main>
<%@ include file="./include/footer.jsp"%>