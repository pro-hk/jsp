<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	request.setCharacterEncoding("utf-8");
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
%>

<% // 드라이버 연결
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "tis";
	String pw = "1234";
%>

<% // Injection
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select * from member where id = ? and password = ?";
%>

<%
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url,id,pw);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
		pstmt.setString(2, user_pw);
		rs = pstmt.executeQuery();
		if(rs.next()) {  // 로그인 성공
			session.setAttribute("name", rs.getString("name"));
			session.setAttribute("id", rs.getString("id"));
			response.sendRedirect("/member");
		} else {  // 로그인 실패
%>
			<script>
				alert("아이디 비밀번호를 확인해주세요");
				history.back();
			</script>
<%
		} 
	} catch(Exception e) {
			
	} finally {
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
%>