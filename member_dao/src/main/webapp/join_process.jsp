<%@page import="com.prohk.util.ScriptWriter"%>
<%@page import="com.prohk.model.MemberDao"%>
<%@page import="com.prohk.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDto memberDto = new MemberDto();
	MemberDao memberDao = new MemberDao();
	
	String user_phone = "";
	String user_phone_first = request.getParameter("user_phone_first");
	String user_phone_middle = request.getParameter("user_phone_middle");
	String user_phone_last = request.getParameter("user_phone_last");
	user_phone = user_phone_first + "-" + user_phone_middle + "-" + user_phone_last;
	String user_address = "";
	String user_address01 = request.getParameter("address01");
	String user_address02 = request.getParameter("address02");

	memberDto.setId(request.getParameter("user_id"));
	memberDto.setPassword(request.getParameter("user_pw"));
	memberDto.setName(request.getParameter("user_name"));
	memberDto.setEmail(request.getParameter("user_email"));
	memberDto.setPhone("user_phone");
	memberDto.setZipCode(Integer.parseInt(request.getParameter("zipcode")));
	memberDto.setAddress("user_address");
	
	System.out.print(memberDto);
	
	int result = memberDao.insertMember(memberDto);
	if(result>0) {
		ScriptWriter.alertAndNext(response, "회원가입이 되었습니다", "/member_dao");
	} else {
		ScriptWriter.alertAndBack(response, "회원가입에 실패하였습니다.");
	}
%>