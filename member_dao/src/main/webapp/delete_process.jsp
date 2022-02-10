<%@page import="com.prohk.model.MemberDto"%>
<%@page import="com.prohk.model.MemberDao"%>
<%@page import="com.prohk.util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.prohk.jdbc.JDBC_Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = new MemberDto();
	memberDto.setId(user_id);
	memberDto.setPassword(user_pw);
	
	int result = memberDao.deleteMember(memberDto);
	
	if(result > 0 ) {
		ScriptWriter.alertAndNext(response, "회원탈퇴 되었습니다.", "/member_dao");
		session.invalidate();
	} else {
		ScriptWriter.alertAndBack(response, "아이디 또는 패스워드를 확인하세요.");
	}
%>