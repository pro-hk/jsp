<%@page import="javax.websocket.SendResult"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
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
	String user_name = request.getParameter("user_name");
	String user_email = request.getParameter("user_email");
	String user_phone = "";
	String user_phone_first = request.getParameter("user_phone_first");
	String user_phone_middle = request.getParameter("user_phone_middle");
	String user_phone_last = request.getParameter("user_phone_last");
	user_phone = user_phone_first + user_phone_middle + user_phone_last;
	int zipcode = Integer.parseInt(request.getParameter("zipcode"));
	String address = "";
	String address01 = request.getParameter("address01");
	String address02 = request.getParameter("address02");
	address = address01 + " " + address02;
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
	String sql = "update member set name=?, email=?, phone=?, zipcode=?, address=? where id=? and password=?";
%>

<% // 클래스 찾아서 연결
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pw);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_name);
		pstmt.setString(2, user_email);
		pstmt.setString(3, user_phone);
		pstmt.setInt(4, zipcode);
		pstmt.setString(5, address);
		pstmt.setString(6, user_id);
		pstmt.setString(7, user_pw);
		int result = pstmt.executeUpdate(); // 영향을 미친 갯수 반환
		if(result > 0) {  // 입력이 하나 이상 되었다.
			session.setAttribute("name", user_name);
			response.sendRedirect("/member");
		} else {          // DB오류
%>			
			<script>
				alert("비밀번호를 확인해 주세요.");
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