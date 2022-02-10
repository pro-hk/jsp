package com.prohk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.model.NoticeDao;
import com.prohk.model.NoticeDto;
import com.prohk.util.ScriptWriter;

@WebServlet("/NoticeUpload.do")
public class NoticeUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeUploadController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDao noticeDao = new NoticeDao();
		NoticeDto noticeDto = new NoticeDto();
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content");
		noticeDto.setTitle(notice_title);
		noticeDto.setContents(notice_content);
		
		int result = noticeDao.insertNotice(noticeDto);
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "저장되었습니다.", "Index.do");
		} else {
			ScriptWriter.alertAndBack(response, "DB오류");
		}
	}

}
