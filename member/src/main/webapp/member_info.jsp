<%@page import="javax.naming.spi.DirectoryManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp"%>

<%
// 드라이버 연결
String driver = "oracle.jdbc.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "tis";
String pw = "1234";
%>

<%
// Injection
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
%>

<%
	String sessionId = (String)session.getAttribute("id");	
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
						<% 
							String user_id = request.getParameter("user_id");
							String sql = "select * from member where id = ?";
							try{
								Class.forName(driver);
								conn = DriverManager.getConnection(url,id,pw);
								pstmt = conn.prepareStatement(sql);
								pstmt.setString(1, user_id);
								rs = pstmt.executeQuery();
								while(rs.next()) {
									out.print("<tr>");
										out.print("<th>ID</th>");
										out.print("<td>"+rs.getString("id")+"</td>");
									out.print("</tr>");
									out.print("<tr>");
										out.print("<th>NAME</th>");
										out.print("<td>"+rs.getString("name")+"</td>");
									out.print("</tr>");
									out.print("<tr>");
										out.print("<th>E-MAIL</th>");
										out.print("<td>"+rs.getString("email")+"</td>");
									out.print("</tr>");
									out.print("<tr>");
										out.print("<th>PHONE</th>");
										out.print("<td>"+rs.getString("phone")+"</td>");
									out.print("</tr>");
									out.print("<tr>");
										out.print("<th>우편번호</th>");
										out.print("<td>"+rs.getString("zipcode")+"</td>");
									out.print("</tr>");
									out.print("<tr>");
										out.print("<th>주소</th>");
										out.print("<td>"+rs.getString("address")+"</td>");
									out.print("</tr>");
								}
							} catch(Exception e) {
								e.printStackTrace();
							} finally {
								if(rs!=null) rs.close();
								if(pstmt!=null) pstmt.close();
								if(conn!=null) conn.close();
							}
						%>
					</tbody>
				</table>
				<div class="btns">
					<a href="update.jsp" class="btn btnConfirm">회원정보 수정</a>
					<a href="delete.jsp?user_id=<%= sessionId %>" class="btn btnCancel">회원탈퇴</a>
				</div>
			</div>
		</div>
	</div>
</main>
<%@ include file="./include/footer.jsp"%>