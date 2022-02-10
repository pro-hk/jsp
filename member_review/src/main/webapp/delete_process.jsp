<%@page import="com.prohk.util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.prohk.jdbc.JDBC_Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	
	JDBC_Connection jdbc = new JDBC_Connection();
	Connection conn = jdbc.conn;
	String sql = "delete from member where id = ? and password = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, user_id);
	pstmt.setString(2, user_pw);
	int result = pstmt.executeUpdate();
	if(result > 0 ) {
		ScriptWriter.alertAndNext(response, "회원탈퇴 되었습니다.", "/member_review");
		session.invalidate();
	} else {
		ScriptWriter.alertAndBack(response, "아이디 또는 패스워드를 확인하세요.");
	}
	jdbc.close();
%>