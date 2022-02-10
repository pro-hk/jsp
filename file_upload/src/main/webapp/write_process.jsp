<%@page import="com.prohk.util.ScriptWriter"%>
<%@page import="com.prohk.model.MarioDto"%>
<%@page import="com.prohk.model.MarioDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String savePath = "upload_mario";
	ServletContext context = this.getServletContext(); // 현재 돌아가는 context
	String realPath = context.getRealPath(savePath);
	int fileSize = 1024 * 1024 * 100; // 100MB
	String encoding = "UTF-8";
	DefaultFileRenamePolicy fileRenamePolicy = new DefaultFileRenamePolicy(); // 이름이 중복되는 파일이 올라갔을 때 처리 방법
	
	System.out.println(context);
	System.out.println(realPath);

	MultipartRequest multipart = new MultipartRequest(request, realPath, fileSize, encoding, fileRenamePolicy);
	
	String user_title = multipart.getParameter("user_title");
	String user_link = multipart.getParameter("user_link");
	String user_bg = multipart.getParameter("user_bg");
	String user_contents = multipart.getParameter("user_contents");
	String marioImg = multipart.getOriginalFileName("user_file"); // 진짜 이름
	String marioRealImg = multipart.getFilesystemName("user_file"); // 중복되었을 때 이름
	
	MarioDao marioDao = new MarioDao();
	MarioDto marioDto = new MarioDto();
	
	marioDto.setTitle(user_title);
	marioDto.setLink(user_link);
	marioDto.setBg(user_bg);
	marioDto.setContents(user_contents);
	marioDto.setMarioImg(marioImg);
	marioDto.setMarioRealImg(marioRealImg);
	
	int result = marioDao.insertMario(marioDto);
	if(result > 0) {
		ScriptWriter.alertAndNext(response, "이미지 업로드가 되었습니다.", "/file_upload");
	} else {
		ScriptWriter.alertAndBack(response, "DB오류입니다.");
	}
%>




