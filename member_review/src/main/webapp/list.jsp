<%@page import="com.prohk.jdbc.JDBC_Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp"%>

<%
	JDBC_Connection jdbc = new JDBC_Connection();
	Connection conn = jdbc.conn;
	ResultSet rs = null;
	String sql = "select * from member";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
%>

<main>
	<div class="container">
		<h2 class="subTitle">MEMBER LIST</h2>
		<div id=contents>
			<div class="tableBox">
				<table>
					<colgroup>
						<col style="width: 30px">
						<col style="width: 100px">
						<col style="width: 100px">
						<col style="width: 200px">
						<col style="width: 150px">
						<col style="width: 100px">
						<col>
						<col style="width: 150px">
					</colgroup>
					<thead>
						<tr>
							<th>NO</th>
							<th>ID</th>
							<th>NAME</th>
							<th>EMAIL</th>
							<th>PHONE</th>
							<th>우편번호</th>
							<th>주소</th>
							<th>DATE</th>
						</tr>
					</thead>
					<tbody>
					<% while(rs.next()) { %>
						<tr>
							<td><%= rs.getString("no") %></td>
							<td><a href="member_info.jsp?user_id=<%= rs.getString("id") %>"><%= rs.getString("id") %></a></td>
							<td><%= rs.getString("name") %></td>
							<td><%= rs.getString("email") %></td>
							<td><%= rs.getString("phone") %></td>
							<td><%= rs.getString("zipcode") %></td>
							<td><%= rs.getString("address") %></td>
							<td><%= rs.getString("regdate") %></td>
						</tr>
						<% } %>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</main>
<% jdbc.close(); %>
<%@ include file="./include/footer.jsp"%>