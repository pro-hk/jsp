<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  //받기
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	
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
	
	String sql = "delete from member where id = ? and password = ?";
%>

<% // 클래스 찾아서 연결
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pw);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
		pstmt.setString(2, user_pw);
		int result = pstmt.executeUpdate(); // 영향을 미친 갯수 반환
		if(result > 0) {  // 입력이 하나 이상 되었다.
			response.sendRedirect("/member");
			session.invalidate();
		} else {          // DB오류
%>			
			<script>
				alert("아아디 또는 패스워드를 확인해주세요.");
				history.back();
			</script>
<%			
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
%>