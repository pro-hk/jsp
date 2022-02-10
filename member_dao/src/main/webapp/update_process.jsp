<%@page import="com.prohk.model.MemberDao"%>
<%@page import="com.prohk.model.MemberDto"%>
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

	MemberDto memberDto = new MemberDto();
	MemberDao memberDao = new MemberDao();
	memberDto.setId(user_id);
	memberDto.setPassword(user_pw);
	memberDto.setName(user_name);
	memberDto.setEmail(user_email);
	memberDto.setPhone(user_phone);
	memberDto.setZipCode(zipcode);
	memberDto.setAddress(user_address);
	
	int result = memberDao.updateMember(memberDto);
	
	if(result > 0) {
		session.setAttribute("loggedName", user_name);
		ScriptWriter.alertAndNext(response, "회원정보가 변경되었습니다.", "member_info.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "회원정보가 변경되지 않았습니다.");
	}
%>