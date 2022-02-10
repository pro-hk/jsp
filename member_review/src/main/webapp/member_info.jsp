<%@page import="com.prohk.jdbc.JDBC_Connection"%>
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

	JDBC_Connection jdbc = new JDBC_Connection();
	Connection conn = jdbc.conn;
	ResultSet rs = null;
	String sql = "select * from member where id = ?";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, user_id);
	
	rs = pstmt.executeQuery();
	
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
						<% while(rs.next()) { %>
						<tr>
							<th>ID</th>
							<td><%= rs.getString("id") %></td>
						</tr>
						<tr>
							<th>NAME</th>
					 		<td><%= rs.getString("name") %></td>
						</tr>
						<tr>
							<th>E-MAIL</th>
							<td><%= rs.getString("email") %></td>
						</tr>
						<tr>
							<th>PHONE</th>
							<td><%= rs.getString("phone") %></td>
						</tr>
						<tr>
							<th>우편번호</th>
							<td><%= rs.getString("zipcode") %></td>
						</tr>
						<tr>
							<th>주소</th>
							<td><%= rs.getString("address") %></td>
						</tr>
						<% } %>
					</tbody>
				</table>
				<div class="btns">
					<a href="update.jsp" class="btn btnConfirm">회원정보 수정</a>
					<a href="delete.jsp?user_id=<%= user_id %>" class="btn btnCancel">회원탈퇴</a>
				</div>
			</div>
		</div>
	</div>
</main>
<% jdbc.close(); %>
<%@ include file="./include/footer.jsp"%>