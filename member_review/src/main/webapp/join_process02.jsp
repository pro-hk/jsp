<%@page import="com.prohk.util.ScriptWriter"%>
<%@page import="com.prohk.jdbc.JDBC_Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String user_name = request.getParameter("user_name");
	String user_email = request.getParameter("user_email");
	String user_phone = "";
	String user_phone_first = request.getParameter("user_phone_first");
	String user_phone_middle = request.getParameter("user_phone_middle");
	String user_phone_last = request.getParameter("user_phone_last");
	user_phone = user_phone_first + "-" + user_phone_middle + "-" + user_phone_last;
	int user_zipcode = Integer.parseInt(request.getParameter("zipcode"));
	String user_address = "";
	String user_address01 = request.getParameter("address01");
	String user_address02 = request.getParameter("address02");
	user_address = user_address01 + user_address02;

	JDBC_Connection jdbcConnection = new JDBC_Connection();
	Connection conn = jdbcConnection.conn;
	PreparedStatement pstmt = jdbcConnection.pstmt;
	String sql = "insert into member values(seq_member.nextval,?,?,?,?,?,?,?,sysdate)";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, user_id);
	pstmt.setString(2, user_pw);
	pstmt.setString(3, user_name);
	pstmt.setString(4, user_email);
	pstmt.setString(5, user_phone);
	pstmt.setInt(6, user_zipcode);
	pstmt.setString(7, user_address);
	int result = pstmt.executeUpdate();
	if(result > 0 ) {
		//response.sendRedirect("/member_review");
		ScriptWriter.alertAndNext(response, "회원가입이 완료되었습니다.", "/member_review");
	} else {
		ScriptWriter.alertAndBack(response,"회원가입이 되지 않았습니다.");
	}
	jdbcConnection.close();
	
%>
<!--  넘어오는지 확인 
${param.user_id }
${param.user_pw }
${param.user_name }
 -->