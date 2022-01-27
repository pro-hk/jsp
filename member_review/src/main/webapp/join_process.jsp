<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  // 데이터 받기
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
%>

<%  // DB 연결
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "tis";
	String pw = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "insert into member values(seq_member.nextval,?,?,?,?,?,?,?,sysdate)";
	
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url,id,pw);  // 이후에 connection pool(미리 만들어서 순차적으로..)
		System.out.print("db연결");
		// sql을 sqldeveloper에서 테스트 후 가져와서 pstmt에서 ? 대응 값을 세팅 
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
		pstmt.setString(2, user_pw);
		pstmt.setString(3, user_name);
		pstmt.setString(4, user_email);
		pstmt.setString(5, user_phone);
		pstmt.setInt(6, user_zipcode);
		pstmt.setString(7, user_address);
		// DB에 값을 던지고 결과를 받는다.
		int result = pstmt.executeUpdate();
		if(result > 0 ) {  // 입력 성공
			response.sendRedirect("/member_review");
		} else {           // 입력 오류
%>
		<script>
			alert("회원가입이 되지 않았습니다.");
			history.back();
		</script>
<%
		}
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
%>
<!--  넘어오는지 확인 
${param.user_id }
${param.user_pw }
${param.user_name }
 -->