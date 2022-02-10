<%@page import="com.prohk.model.MemberDao"%>
<%@page import="com.prohk.model.MemberDto"%>
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
	MemberDto memberDto = new MemberDto();
	memberDto.setId(user_id);
	memberDto.setPassword(user_pw);
	MemberDao memberDao = new MemberDao();
	MemberDto loggedMember = memberDao.getLoggedMember(memberDto);
	if(loggedMember!=null) {
		// 로그인 성공
		session.setAttribute("loggedId", loggedMember.getId());
		session.setAttribute("loggedName", loggedMember.getName());
		session.setAttribute("loggedMember", loggedMember); 
		ScriptWriter.alertAndNext(response, loggedMember.getName()+"님 안녕하세요.", "/member_dao");
	} else {
		// 로그인 실패
		ScriptWriter.alertAndBack(response, "아이디 또는 비밀번호를 확인해주세요.");
	}
%>