<%@page import="com.prohk.util.ScriptWriter"%>
<%@page import="com.prohk.model.NoticeDto"%>
<%@page import="com.prohk.model.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String notice_title = request.getParameter("notice_title");
	String notice_content = request.getParameter("notice_content");
	
	NoticeDao noticeDao = new NoticeDao();
	NoticeDto noticeDto = new NoticeDto();
	
	noticeDto.setTitle(notice_title);
	noticeDto.setContents(notice_content);
	
	int result = noticeDao.insertNotice(noticeDto);
	if(result > 0 ) {
		ScriptWriter.alertAndNext(response, "저장되었습니다.", "index.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "저장되지 않았습니다.");
	}
%>