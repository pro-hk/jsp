<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String notice_title = request.getParameter("notice_title");
	String notice_content = request.getParameter("notice_content").replaceAll("\r\n","<br>");

	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "tis";
	String pw = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String sql = "insert into notice values(seq_notice.nextval, ?, ?, sysdate)";
	
	try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, id, pw);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, notice_title);
	pstmt.setString(2, notice_content);
	int result = pstmt.executeUpdate();
	if(result > 0 ) {
		out.print("<script>alert('저장되었습니다.');location.href='/notice'</script>");
		;
	} else {
		out.print("<script>alert('저장되지 않았습니다.');history.back()</script>");
	}
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
%>