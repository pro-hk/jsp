<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.prohk.jdbc.JDBC_Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JDBC_Connection jdbcConnection = new JDBC_Connection();
	Connection conn = jdbcConnection.conn;
	PreparedStatement pstmt = jdbcConnection.pstmt;
	ResultSet rs = jdbcConnection.rs;
	
	String user_id = request.getParameter("user_id");
	//System.out.println("ajax로 넘어온 값 =="+user_id);
	
	String sql = "select count(*) as count from member where ID=?";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, user_id);
	rs = pstmt.executeQuery();
	int result = 0;
	if(rs.next()) {
		result = rs.getInt("count"); // 중복이 없으면 0, 중복이 있으면 1이상의 숫자가 나옴
	}
	// json으로 결과 던지기..
	// response.setContentType("text/html; charset=UTF-8"); // html로 결과 던지기
	// 자바 파일을 json으로 바꿔주는 라이브러리 필요(gson-2.8.9.jar)
	response.setContentType("application/json; charset=UTF-8");
	Map<String, Integer> resultMap = new HashMap<>();
	resultMap.put("count",result);
	Gson gson = new Gson();
	//gson.toJson(resultMap);
	out.print(gson.toJson(resultMap));
%>