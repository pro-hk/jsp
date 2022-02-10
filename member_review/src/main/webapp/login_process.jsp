<%@page import="javax.websocket.SendResult"%>
<%@page import="com.prohk.util.ScriptWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.prohk.jdbc.JDBC_Connection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");

	JDBC_Connection jdbc = new JDBC_Connection();
	Connection conn = jdbc.conn;
	ResultSet rs = null;
	String sql = "select * from member where id = ? and password = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, user_id);
	pstmt.setString(2, user_pw);
	rs = pstmt.executeQuery();
	if(rs.next()) {
		// session에 값 담기
		session.setAttribute("name", rs.getString("name"));
		session.setAttribute("id", rs.getString("id"));
		// 인덱스로
		
		response.sendRedirect("/member_review");
	} else {
		ScriptWriter.alertAndBack(response, "아이디 또는 비밀번호가 맞지 않습니다.");
	}
	jdbc.close();
%>