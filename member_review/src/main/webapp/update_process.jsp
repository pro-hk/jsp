<%@page import="com.prohk.util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.prohk.jdbc.JDBC_Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String user_name = request.getParameter("user_name");
	String user_email = request.getParameter("user_email");
	String user_phone = "";
	String user_phone_first = request.getParameter("user_phone_first");
	String user_phone_middle = request.getParameter("user_phone_middle");
	String user_phone_last = request.getParameter("user_phone_last");
	user_phone = user_phone_first + "-" + user_phone_middle + "-" + user_phone_last;
	int zipcode = Integer.parseInt(request.getParameter("zipcode"));
	String user_address = "";
	String address01 = request.getParameter("address01");
	String address02 = request.getParameter("address02");
	user_address = address01 + address02;

	JDBC_Connection jdbc = new JDBC_Connection();
	Connection conn = jdbc.conn;
	String sql = "update member set (name=?, email=?, phone=?, zipcode=?, address=? where id=? and password=?)";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, user_name);
	pstmt.setString(2, user_email);
	pstmt.setString(3, user_phone);
	pstmt.setInt(4, zipcode);
	pstmt.setString(5, user_address);
	pstmt.setString(6, user_id);
	pstmt.setString(7, user_pw);
	int result = pstmt.executeUpdate();
	if(result > 0) {
		ScriptWriter.alertAndNext(response, "회원정보가 변경되었습니다.", "member_info.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "회원정보가 변경되지 않았습니다.");
	}
	jdbc.close();
%>